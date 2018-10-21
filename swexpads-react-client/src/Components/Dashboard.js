import React, { Component } from "react";
import AdItem from "./Add/AdItem";
import CreateAdButton from "./Add/CreateAdButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Ads</h1>
              <br />
              <CreateAdButton />
              <br />
              <hr />
              <AdItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
