import Login from "./Login";
import {Route} from "react-router-dom";
function SellerProtectedRoute( props ) {
    let isLoggedIn = false;

    let isValidSeller = sessionStorage.getItem("role");

    if(isValidSeller === "true" && sessionStorage.status === "APPROVED") isLoggedIn = true;
    else isLoggedIn = false;
    if (isLoggedIn) {
        return <Route exact path={props.path} element={props.component}/>
    }
    else return <Login/>
}

export default SellerProtectedRoute;