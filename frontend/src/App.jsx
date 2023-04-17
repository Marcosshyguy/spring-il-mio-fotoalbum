import React, { useState, useEffect } from "react";
import axios from "axios";
import PostForm from "./components/PostForm";
import PhotoCard from "./components/PhotoCard";
import Navbar from "./components/Navbar";
import UncontrolledExample from "./components/Carousel";
import { Carousel } from "react-bootstrap";

function App() {
  // Get
  const [apiData, setApiData] = useState(null);
  const [carouselData, setCarouselData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [params, setParams] = useState({
    input: "",
  });

  // keyword from Navbar
  const [currentKeyword, setCurrentKeyword] = useState("");

  // Get Method
  const getData = async (keyword) => {
    try {
      setParams({
        ...params,
        input: keyword,
      });

      setLoading(true);

      const response = await axios.get("http://localhost:8080/api/photos", {
        params,
      });
      const data = response.data;
      setCarouselData(data);
      setApiData(data);
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  useEffect(() => {
    getData(currentKeyword);
  }, [currentKeyword]);

  const saveNewerKeywordHandler = (newKeywordFromNavbar) => {
    setCurrentKeyword(newKeywordFromNavbar);
    getData(newKeywordFromNavbar);
  };

  return (
    <div>
      <Navbar
        onSaveNewKeyword={saveNewerKeywordHandler}
        keyword={currentKeyword}
      />

      <div className="container">
        {!loading ? (
          <Carousel>
            {carouselData.slice(0, 2).map((item) => {
              return (
                <Carousel.Item key={item.id}>
                  <img
                    className="d-block w-100"
                    src={item.url}
                    alt={item.title}
                  />
                  <Carousel.Caption>
                    <h3>{item.title}</h3>
                  </Carousel.Caption>
                </Carousel.Item>
              );
            })}
          </Carousel>
        ) : (
          <p>Loading carousel...</p>
        )}

        {!loading ? (
          <div className="row">
            {apiData.map((item) => (
              <PhotoCard
                title={item.title}
                url={item.url}
                description={item.description}
                key={item.id}
              />
            ))}
          </div>
        ) : (
          <p>Loading...</p>
        )}
      </div>
      <PostForm />
    </div>
  );
}

export default App;
