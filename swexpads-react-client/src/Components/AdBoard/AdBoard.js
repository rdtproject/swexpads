import React, { Component } from "react";
import { Link } from "react-router-dom";
import AdDetails from "./AdDetails";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import { getAdDetails } from "../../actions/adDetailsActions";

class AdBoard extends Component {
  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getAdDetails(id);
  }

  render() {
    const { id } = this.props.match.params;
    // to idzie z dev tools redux mozna podejrzec skad
    const { ad_items } = this.props.adDetails;
    return (
      <div className="container">
        <Link to={`/addAdItem/${id}`} className="btn btn-primary mb-3">
          <i className="fas fa-plus-circle"> Create Project Task</i>
        </Link>
        <br />
        <hr />
        <AdDetails ad_items_prop={ad_items} />
      </div>
    );
  }
}

AdBoard.propTypes = {
  adDetails: PropTypes.object.isRequired,
  getAdDetails: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  adDetails: state.adDetails
});

export default connect(
  mapStateToProps,
  { getAdDetails }
)(AdBoard);
