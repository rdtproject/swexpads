import { GET_ADS } from "../actions/types";

const initialState = {
  projects: [],
  project: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_ADS:
      return {
        ...state,
        projects: action.payload
      };

    default:
      return state;
  }
}
