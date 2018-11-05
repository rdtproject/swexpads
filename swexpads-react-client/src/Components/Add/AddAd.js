import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/adActions";
import classnames from "classnames";

class AddAd extends Component {
  constructor() {
    super();

    this.state = {
      identifier: "",
      subject: "",
      text: "",
      expirationDate: "",
      errors: {}
    };

    // zamiast onChange={this.onChange.bind(this)} przy kazdym inpucie
    this.onChange = this.onChange.bind(this);
    // powiazane z klasycznym wymaganym submit w <form>
    this.onSubmit = this.onSubmit.bind(this);
  }

  // lifecycle hooks do doczytania!
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onChange(e) {
    // zamiast this.setState({ subject: e.target.value });
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    // prevent form from reloading to avoid clearing values
    e.preventDefault();
    const newAd = {
      identifier: this.state.identifier,
      subject: this.state.subject,
      text: this.state.text,
      expirationDate: this.state.expirationDate
    };

    this.props.createProject(newAd, this.props.history);
  }

  render() {
    const { errors } = this.state;
    return (
      // Klasyczny formularz html
      <div>
        <div className="add">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Create Ad form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.subject
                      })}
                      placeholder="Ad Subject"
                      name="subject"
                      value={this.state.subject}
                      onChange={this.onChange}
                    />
                    {errors.subject && (
                      <div className="invalid-feedback">{errors.subject}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.identifier
                      })}
                      placeholder="Unique Ad ID"
                      name="identifier"
                      value={this.state.identifier}
                      onChange={this.onChange}
                    />
                    {errors.identifier && (
                      <div className="invalid-feedback">
                        {errors.identifier}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.text
                      })}
                      placeholder="Ad Content"
                      name="text"
                      value={this.state.text}
                      onChange={this.onChange}
                    />
                    {errors.text && (
                      <div className="invalid-feedback">{errors.text}</div>
                    )}
                  </div>
                  <h6>Expiration date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="expirationDate"
                      value={this.state.expirationDate}
                      onChange={this.onChange}
                    />
                    <p>{errors.expirationDate}</p>
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
      </div>
    );
  }
}

AddAd.propTypes = {
  createProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { createProject }
)(AddAd);
