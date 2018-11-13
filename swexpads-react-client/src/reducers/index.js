import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import adReducer from "./adReducer";
import adDetailsReducer from "./adDetailsReducer";

export default combineReducers({
  errors: errorReducer,
  project: adReducer,
  adDetails: adDetailsReducer
});
