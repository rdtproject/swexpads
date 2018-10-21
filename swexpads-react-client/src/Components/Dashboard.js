import React, { Component } from "react";
import AddItem from "./Add/AddItem";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1 className="alert alert-warning">Welcome to the Dashboard</h1>
        <AddItem />
        <AddItem />
        <AddItem />
      </div>
    );
  }
}

export default Dashboard;
