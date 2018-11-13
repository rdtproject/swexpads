import axios from "axios";
import { GET_ERRORS, GET_AD_DETAILS } from "./types";

export const addAdItem = (
  ad_details_id,
  ad_item,
  history
) => async dispatch => {
  try {
    await axios.post(`/api/backlog/${ad_details_id}`, ad_item);
    history.push(`/adBoard/${ad_details_id}`);
    // if no errors we are cleaning up any errors to avoid popping out when it should no longer be visible
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const getAdDetails = ad_details_id => async dispatch => {
  try {
    const res = await axios.get(`/api/backlog/${ad_details_id}`);
    dispatch({
      type: GET_AD_DETAILS,
      payload: res.data
    });
  } catch (error) {}
};
