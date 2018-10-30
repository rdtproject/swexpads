import React, { Component } from "react";
import AdItem from "./Add/AdItem";
import CreateAdButton from "./Add/CreateAdButton";
import { connect } from "react-redux";
import { getAds } from "../actions/adActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  // lifecycle hook :)
  componentDidMount() {
    this.props.getAds();
  }

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

Dashboard.propTypes = {
  project: PropTypes.object.isRequired,
  getAds: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  project: state.project
});

export default connect(
  mapStateToProps,
  { getAds }
)(Dashboard);
