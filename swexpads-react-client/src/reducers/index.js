import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import adReducer from "./adReducer";

export default combineReducers({
  errors: errorReducer,
  project: adReducer
});
