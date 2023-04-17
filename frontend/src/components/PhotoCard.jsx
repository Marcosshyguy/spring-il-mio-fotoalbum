import React, { useState, useEffect } from "react";
import axios from "axios";
function PhotoCard(props) {
  return (
    <div class="card col-sm-12 col-md-3 mx-2 my-2">
      <img className="card-img-top" src={props.url} alt={props.title} />
      <div class="card-body">
        <h4 class="card-title">{props.title}</h4>
        {props.description ? (
          <p class="card-text">{props.description}</p>
        ) : (
          <p class="card-text">No description available</p>
        )}
        <h5 class="card-title">Categories</h5>
        {props.categories.length !== 0 ? (
          <ul class="list-group list-group-flush">
            {props.categories.map((cat) => (
              <li class="list-group-item">{cat.type}</li>
            ))}
          </ul>
        ) : (
          <p class="card-text">No categories available</p>
        )}
        {/* <a href="#" class="btn btn-primary">
          Go somewhere
        </a> */}
      </div>
    </div>
  );
}

export default PhotoCard;
