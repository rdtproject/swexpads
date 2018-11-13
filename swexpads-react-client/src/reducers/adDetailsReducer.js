import { GET_AD_DETAILS, GET_AD_ITEM, DELETE_AD_ITEM } from "../actions/types";

const initialState = {
  ad_items: [],
  ad_item: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_AD_DETAILS:
      return {
        ...state,
        ad_items: action.payload
      };

    case GET_AD_ITEM:
      return {
        ...state,
        ad_item: action.payload
      };

    case DELETE_AD_ITEM:
      return {
        ...state
        // todo
      };

    default:
      return state;
  }
}
