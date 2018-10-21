import React from "react";
import { Link } from "react-router-dom";

const CreateAdButton = () => {
  return (
    <React.Fragment>
      <Link to="/addAd" className="btn btn-lg btn-info">
        Create an Ad
      </Link>
    </React.Fragment>
  );
};

export default CreateAdButton;
