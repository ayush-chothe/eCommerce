import React, { useEffect, useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate} from "react-router-dom"
const CartPage = () => {
  const [cartItems, setCartItems] = useState([]);

  const navigate = useNavigate()

  useEffect(() => {
    axios.get("http://127.0.0.1:7070/user/cart/" + sessionStorage.getItem("userId"))
        .then(res => setCartItems(res.data))
        .catch(err => console.log(err))
  }, [])

  useEffect(() => {
    axios.get("http://127.0.0.1:7070/user/cart/" + sessionStorage.getItem("userId"))
        .then(res => setCartItems(res.data))
        .catch(err => console.log(err))
  }, [cartItems])

  const handleQuantityChange = (itemId, newQuantity) => {
    let cart = {userId: sessionStorage.getItem("userId"),
                productId: itemId,
                quantity: newQuantity}
    axios.post("http://127.0.0.1:7070/product/cart/", cart)
        .then(res => {

        })
    
  };

  const checkout = () => {
    axios.get("http://127.0.0.1:7070/user/checkout/" + sessionStorage.getItem("userId"))
        .then(res => navigate("/"))
        .catch(err => console.log(err))
  }

  const calculateTotal = () => {
    return cartItems.reduce((total, item) => total + item.quantity * item.product.price, 0);
  };

  return (
    <div className="container mt-5">
      <h1>Shopping Cart</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {cartItems.map(item => (
            <tr key={item.id}>
              <td>{item.product.name}</td>
              <td>${item.product.price}</td>
              <td>
                <button
                  className="btn btn-sm btn-secondary"
                  onClick={() =>
                    handleQuantityChange(item.product.id, -1)
                  }
                  disabled={item.quantity === 1}
                >
                  -
                </button>
                {item.quantity}
                <button
                  className="btn btn-sm btn-secondary"
                  onClick={() =>
                    handleQuantityChange(item.product.id, 1)
                  }
                >
                  +
                </button>
              </td>
              <td>${item.product.price * item.quantity}</td>
              <td>
                <button className="btn btn-sm btn-danger">Remove</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="text-right">
        <h5>Total Price: ${calculateTotal()}</h5>
        <button className="btn btn-primary" onClick={checkout}>Checkout</button>
      </div>
    </div>
  );
};

export default CartPage;
