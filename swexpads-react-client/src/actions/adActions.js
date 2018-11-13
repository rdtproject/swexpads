import axios from "axios";
import { GET_ERRORS, GET_ADS, GET_AD, DELETE_AD } from "./types";

export const createProject = (project, history) => async dispatch => {
  try {
    await axios.post("/api/project", project);
    history.push("/dashboard");
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const getAds = () => async dispatch => {
  const res = await axios.get("/api/project/all");
  dispatch({
    type: GET_ADS,
    payload: res.data
  });
};

export const getAd = (id, history) => async dispatch => {
  const res = await axios.get(`/api/project/${id}`);
  dispatch({
    type: GET_AD,
    payload: res.data
  });
};

export const deleteAd = id => async dispatch => {
  if (window.confirm("Are you sure?")) {
    await axios.delete(`/api/project/${id}`);
    dispatch({
      type: DELETE_AD,
      payload: id
    });
  }
};
