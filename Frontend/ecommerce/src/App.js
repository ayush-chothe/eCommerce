import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./Routes/Login";
import Products from "./Routes/Products";
import SellerRegistration from "./Routes/SellerRegistration"
import AddProduct from "./Routes/AddProduct";
import EditProduct from "./Routes/EditProduct";

function App() {
  return (
   <>
    <BrowserRouter>
    <Routes>
         <Route Exact path="/login" element={<Login/>}/>
         <Route exact path="/seller/products" element={<Products/>}/>
         <Route exact path="/sellerRegistration" element={<SellerRegistration/>}/>
         <Route exact path="/seller/addProduct" element={<AddProduct/>}/>
         <Route exact path="/product/edit/:productId" element={<EditProduct/>}/>
    </Routes>
    </BrowserRouter>
   </>
  );
}

export default App;
