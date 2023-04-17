import Carousel from "react-bootstrap/Carousel";

function UncontrolledExample(props) {
  return (
    <div>
      {props.data.map((item) => {
        return (
          <Carousel>
            <Carousel.Item key={item.id}>
              <img src={item.url} alt={item.title} />
              <Carousel.Caption>
                <h3>{item.title}</h3>
              </Carousel.Caption>
            </Carousel.Item>
            ;
          </Carousel>
        );
      })}
    </div>
  );
}

export default UncontrolledExample;
