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

function App() {
  return (
   <>
    <BrowserRouter>
    <Routes>
         <Route Exact path="/" element={<Home/>}/>
         <Route Exact path="/login" element={<Login/>}/>
         <Route exact path="/seller/products" element={<Products/>}/>
         <Route exact path="/sellerRegistration" element={<SellerRegistration/>}/>
         <Route exact path="/seller/addProduct" element={<AddProduct/>}/>
         <Route exact path="/product/edit/:productId" element={<EditProduct/>}/>
         <Route exact path="/cart" element={<Cart/>}/>
         <Route exact path="/orders" element={<Orders/>}/>
    </Routes>
    </BrowserRouter>
    <ToastContainer/>
   </>
  );
}

export default App;
