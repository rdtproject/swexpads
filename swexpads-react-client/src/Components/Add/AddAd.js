import React, { Component } from "react";

class AddAd extends Component {
  constructor() {
    super();

    this.state = {
      identifier: "",
      subject: "",
      text: "",
      expirationDate: ""
    };

    // zamiast onChange={this.onChange.bind(this)} przy kazdym inpucie
    this.onChange = this.onChange.bind(this);
    // powiazane z klasycznym wymaganym submit w <form>
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    // this.setState({ subject: e.target.value });
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

    console.log(newAd);
  }

  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Ad form</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Ad Subject"
                    name="subject"
                    value={this.state.subject}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Ad ID"
                    name="identifier"
                    value={this.state.identifier}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Ad Content"
                    name="text"
                    value={this.state.text}
                    onChange={this.onChange}
                  />
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

export default AddAd;
