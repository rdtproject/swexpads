import React, { Component } from "react";
import { Link } from "react-router-dom";
import AdDetails from "./AdDetails";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import { getAdDetails } from "../../actions/adDetailsActions";

class AdBoard extends Component {
  constructor() {
    super();
    this.state = {
      errors: {}
    };
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getAdDetails(id);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  render() {
    const { id } = this.props.match.params;
    // to idzie z dev tools redux mozna podejrzec skad
    const { ad_items } = this.props.adDetails;
    const { errors } = this.state;

    let BoardContent;

    const boardAlgorithm = (errors, ad_items) => {
      if (ad_items.length < 1) {
        if (errors.adNotFound) {
          return (
            <div className="alert alert-danger text-center" role="alert">
              {errors.adNotFound}
            </div>
          );
        } else {
          return (
            <div className="alert alert-info text-center" role="alert">
              No Ad items on this board
            </div>
          );
        }
      } else {
        return <AdDetails ad_items_prop={ad_items} />;
      }
    };

    BoardContent = boardAlgorithm(errors, ad_items);

    return (
      <div className="container">
        <Link to={`/addAdItem/${id}`} className="btn btn-primary mb-3">
          <i className="fas fa-plus-circle"> Create Project Task</i>
        </Link>
        <br />
        <hr />
        {BoardContent}
      </div>
    );
  }
}

AdBoard.propTypes = {
  adDetails: PropTypes.object.isRequired,
  getAdDetails: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  adDetails: state.adDetails,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { getAdDetails }
)(AdBoard);
