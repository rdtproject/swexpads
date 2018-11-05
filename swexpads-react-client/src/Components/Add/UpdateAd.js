import React, { Component } from "react";
import { getAd, createProject } from "../../actions/adActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";

// rcc
class UpdateAd extends Component {
  constructor() {
    super();

    this.state = {
      id: "",
      identifier: "",
      subject: "",
      text: "",
      expirationDate: ""
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    const { id, identifier, subject, text, expirationDate } = nextProps.project;

    this.setState({
      id,
      identifier,
      subject,
      text,
      expirationDate
    });
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getAd(id, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const updateAd = {
      id: this.state.id,
      identifier: this.state.identifier,
      subject: this.state.subject,
      text: this.state.text,
      expirationDate: this.state.expirationDate
    };

    this.props.createProject(updateAd, this.props.history);
  }

  render() {
    return (
      <div className="register">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Edit Ad form</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Project Name"
                    name="subject"
                    value={this.state.subject}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Project ID"
                    name="identifier"
                    value={this.state.identifier}
                    onChange={this.onChange}
                    disabled
                  />
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Project Description"
                    name="text"
                    value={this.state.text}
                    onChange={this.onChange}
                  />
                </div>
                <h6>Start Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="expirationDate"
                    value={this.state.expirationDate}
                    onChange={this.onChange}
                  />
                </div>

                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

UpdateAd.propTypes = {
  getAd: PropTypes.func.isRequired,
  createProject: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  project: state.project.project
});

export default connect(
  mapStateToProps,
  { getAd, createProject }
)(UpdateAd);
