import React, { Component } from "react";
import "./App.css";
import Dashboard from "./Components/Dashboard";
import Header from "./Components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddAd from "./Components/Add/AddAd";
import { Provider } from "react-redux";
import store from "./store";
import UpdateAd from "./Components/Add/UpdateAd";
import AdBoard from "./Components/AdBoard/AdBoard";
import AddAdItem from "./Components/AdBoard/AdItems/AddAdItem";
import UpdateAdItem from "./Components/AdBoard/AdItems/UpdateAdItem";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/addAd" component={AddAd} />
            <Route exact path="/updateAd/:id" component={UpdateAd} />
            <Route exact path="/adBoard/:id" component={AdBoard} />
            <Route exact path="/addAdItem/:id" component={AddAdItem} />
            <Route
              exact
              path="/updateAdItem/:ad_details_id/:ad_item_id"
              component={UpdateAdItem}
            />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
