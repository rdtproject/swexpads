import { GET_ADS, GET_AD } from "../actions/types";

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

    case GET_AD:
      return {
        ...state,
        project: action.payload
      };

    default:
      return state;
  }
}
