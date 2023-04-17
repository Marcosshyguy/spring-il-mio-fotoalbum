import React, { useState, useEffect } from "react";
import axios from "axios";

function Navbar(props) {
  const [keyword, setKeyword] = useState("");

  const takeKeyword = (e) => {
    props.onSaveNewKeyword(e.target.value);
    setKeyword(e.target.value);
  };

  return (
    <nav class="navbar bg-body-tertiary">
      <div className="container-fluid">
        <a className="navbar-brand">PhotoReactive</a>
        <form class="d-flex" role="search">
          <input
            className="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
            onChange={takeKeyword}
            value={props.keyword}
          />
          {/* <button className="btn btn-outline-success" type="submit">
            Search
          </button> */}
        </form>
      </div>
    </nav>
  );
}

export default Navbar;
