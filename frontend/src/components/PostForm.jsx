import React, { useState, useEffect } from "react";
import axios from "axios";

function PostForm() {
  // Post
  const [dataToSend, setDataToSend] = useState({
    email: "",
    message: "",
  });

  // Post method
  const sendData = async (formData) => {
    try {
      const response = await axios.post(
        "http://localhost:8080/api/messages",
        formData
      );
    } catch (error) {
      console.log(error);
    }
  };

  // Post form
  // set email
  const messageEmailhandler = (e) => {
    setDataToSend((previusState) => {
      return { ...previusState, email: e.target.value };
    });
  };
  // set message
  const messageTextHandler = (e) => {
    setDataToSend((previusState) => {
      return { ...previusState, message: e.target.value };
    });
  };
  // subit the form
  const formPostHandler = (e) => {
    e.preventDefault();

    if (dataToSend.email && dataToSend.message) {
      sendData(dataToSend);

      setDataToSend({
        email: "",
        message: "",
      });
    }
  };

  return (
    <form onSubmit={formPostHandler}>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">
          Email address
        </label>
        <input
          type="email"
          className="form-control"
          id="email"
          aria-describedby="emailHelp"
          onChange={messageEmailhandler}
          value={dataToSend.email}
        />
      </div>

      <div className="mb-3">
        <label htmlFor="email" className="form-label">
          Message
        </label>
        <input
          type="text"
          className="form-control"
          id="email"
          aria-describedby="emailHelp"
          onChange={messageTextHandler}
          value={dataToSend.message}
        />
      </div>

      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}

export default PostForm;
