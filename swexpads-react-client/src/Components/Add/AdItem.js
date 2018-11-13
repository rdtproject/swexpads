import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteAd } from "../../actions/adActions";

class AdItem extends Component {
  onDeleteClick = id => {
    this.props.deleteAd(id);
  };

  render() {
    const { project } = this.props;

    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{project.subject}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{project.identifier}</h3>
              <p>{project.text}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <Link to={`/adBoard/${project.identifier}`}>
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">Ads Board </i>
                  </li>
                </Link>
                <Link to={`/updateAd/${project.identifier}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1">Update Ad Info</i>
                  </li>
                </Link>
                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClick.bind(this, project.identifier)}
                >
                  <i className="fa fa-minus-circle pr-1">Delete Ad</i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AdItem.propTypes = {
  deleteAd: PropTypes.func.isRequired
};

export default connect(
  null,
  { deleteAd }
)(AdItem);
