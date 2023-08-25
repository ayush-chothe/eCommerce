import "./Login.css";
import { useState } from "react"
import { useNavigate } from "react-router-dom";
import axios from "axios"

function Login() {

    let [icreds, setICreds] = useState({email : "", password : ""});
    let [user, setUser] = useState({});
    const navigate = useNavigate();

    const signIn = () => {
        console.log("in signin")
        axios.post("http://127.0.0.1:7070/user/login", icreds)
             .then(res => {
               setUser(res.data);
               console.log("Logged in successfully");
               sessionStorage.setItem("userId", res.data.id);
               sessionStorage.setItem("firstName", res.data.firstName);
               if(res.data.role === "SELLER" && res.data.status === "APPROVED")
                navigate("/seller/products")
               else if(res.data.role === "CUSTOMER")
                navigate("/home")
                else navigate("/admin")
             }).catch(error => {
                if (error.response && error.response.status === 404) {
                  console.log("Invalid credentials")
                } else {
                  setUser('An error occurred');
                }
                setUser(null);
              });  
    }


    const onInputChange = (event) => {
        let copyOfICreds = { ...icreds }
        copyOfICreds[event.target.name] = event.target.value;
        setICreds(copyOfICreds);
    }


    return (
        <div className="center">
          <form className="form">
            <p className="title">Login</p>
            <div className="form-group">
              <label>Email</label>
              <input
                required
                name="email"
                value={icreds.email}
                onChange={onInputChange}
                type="email"
                className="form-control"
              />
            </div>
            <div className="form-group">
              <label>Password</label>
              <input
                required
                name="password"
                value={icreds.password}
                onChange={onInputChange}
                type="password"
                className="form-control"
              />
            </div>
            <button type="button" onClick={signIn} className="btn btn-primary">
              Submit
            </button>
            <p className="signup">
              Create an account? <a href="#">Sign Up</a>
            </p>
          </form>
          <button className="btn btn-primary seller">
            <a className="text" onClick={() => navigate("/sellerRegistration")}>
              Become a Seller
            </a>
          </button>
        </div>
      );
}

export default Login;