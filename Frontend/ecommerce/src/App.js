import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./Routes/Login";
import Products from "./Routes/Products";
import SellerRegistration from "./Routes/SellerRegistration"
import AddProduct from "./Routes/AddProduct";
import EditProduct from "./Routes/EditProduct";
import Home from "./Routes/Home";
import Cart from "./Routes/Cart";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Orders from "./Routes/Orders";
import CustomerRegistration from "./Routes/CustomerRegistration";
import ProtectedRoute from "./Routes/ProtectedRoute";
import SellerProtectedRoute from "./Routes/SellerProtectedRoute";

function App() {
  return (
   <>
    <BrowserRouter>
    <Routes>
         <Route Exact path="/" element={<Home/>}/>
         <Route Exact path="/login" element={<Login/>}/>
         <Route exact path="/seller/products" element={<SellerProtectedRoute path="/seller/products" component={<Products/>}/>}/>
         <Route exact path="/sellerRegistration" element={<SellerRegistration/>}/>
         <Route exact path="/registration" element={<CustomerRegistration/>}/>
         <Route exact path="/seller/addProduct" element={<SellerProtectedRoute path="/seller/addProduct" component={<AddProduct/>}/>}/>
         <Route exact path="/product/edit/:productId" element={<SellerProtectedRoute path="/product/edit/:productId" component={<EditProduct/>}/>}/>
         <Route exact path="/cart" element={<ProtectedRoute path="/cart" component={<Cart/>}/>}/>
         <Route exact path="/orders" element={<ProtectedRoute path="/orders" component={<Orders/>}/>}/>
    </Routes>
    </BrowserRouter>
    <ToastContainer autoClose={1000}/>
   </>
  );
}

export default App;
