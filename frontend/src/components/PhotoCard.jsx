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
          <p>No description avaible</p>
        )}

        {/* <a href="#" class="btn btn-primary">
          Go somewhere
        </a> */}
      </div>
    </div>
  );
}

export default PhotoCard;
