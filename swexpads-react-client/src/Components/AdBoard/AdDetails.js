import React, { Component } from "react";
import AdItem from "./AdItems/AdItem";

class AdDetails extends Component {
  render() {
    const { ad_items_prop } = this.props;
    const adItems = ad_items_prop.map(ad_item => (
      <AdItem key={ad_item.id} ad_item={ad_item} />
    ));

    let todoItems = [];
    let inProgressItems = [];
    let doneItems = [];

    for (let i = 0; i < adItems.length; i++) {
      if (adItems[i].props.ad_item.status === "TO_DO") {
        todoItems.push(adItems[i]);
      }
      if (adItems[i].props.ad_item.status === "IN_PROGRESS") {
        inProgressItems.push(adItems[i]);
      }
      if (adItems[i].props.ad_item.status === "DONE") {
        doneItems.push(adItems[i]);
      }
    }

    return (
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-secondary text-white">
                <h3>TO DO</h3>
              </div>
            </div>
            {todoItems}
          </div>
          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-primary text-white">
                <h3>In Progress</h3>
              </div>
            </div>
            {inProgressItems}
          </div>
          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-success text-white">
                <h3>Done</h3>
              </div>
            </div>
            {doneItems}
          </div>
        </div>
      </div>
    );
  }
}

export default AdDetails;
