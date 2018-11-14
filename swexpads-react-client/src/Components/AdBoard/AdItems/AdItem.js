import React, { Component } from "react";
import { Link } from "react-router-dom";

class AdItem extends Component {
  render() {
    const { ad_item } = this.props;

    let priorityString;
    let priorityClass;

    if (ad_item.priority === 1) {
      priorityClass = "bg-danger text-light";
      priorityString = "HIGH";
    }

    if (ad_item.priority === 2) {
      priorityClass = "bg-warning text-light";
      priorityString = "MEDIUM";
    }

    if (ad_item.priority === 3) {
      priorityClass = "bg-info text-light";
      priorityString = "LOW";
    }

    return (
      <div className="card mb-1 bg-light">
        <div className={`card-header text-primary ${priorityClass}`}>
          ID: {ad_item.adSequence} -- Priority: {priorityString}
        </div>
        <div className="card-body bg-light">
          <h5 className="card-title">{ad_item.summary}</h5>
          <p className="card-text text-truncate ">
            {ad_item.acceptanceCriteria}
          </p>
          <Link
            to={`/updateAdItem/${ad_item.adIdentifier}/${ad_item.adSequence}`}
            className="btn btn-primary"
          >
            View / Update
          </Link>

          <button className="btn btn-danger ml-4">Delete</button>
        </div>
      </div>
    );
  }
}
export default AdItem;
