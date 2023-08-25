import { React, useEffect, useState } from 'react';
import axios from 'axios';



const ProductCard = ({ product }) => {

    const [imageData, setImageData] = useState(null);

    const addToCart = () => {
        let cart = {userId: sessionStorage.getItem("userId"),
                    productId: product.id,
                    quantity: 1}
        console.log(cart);
        axios.post("http://localhost:7070/product/cart", cart)
            .then(res => {
                console.log(res.data);
            })
    }

    const getImage = (images) => {
        console.log(images)
        axios.get("http://localhost:7070/product/images/"+images[0], { responseType: 'arraybuffer' })
        .then(response => {
            const base64Image = btoa(
            new Uint8Array(response.data).reduce((data, byte) => data + String.fromCharCode(byte), '')
            );
            setImageData(`data:image/jpeg;base64,${base64Image}`);
        })
        .catch(error => {
            console.error('Error fetching image:', error);
    });
  }

  useEffect(() => {
    getImage(product.productImageIds);
  }, [])

  return (
    <div className="card">
      {imageData == null && <div class="spinner-border" role="status">
        <span class="visually-hidden">Loading...</span>
    </div>}
      {imageData && <img src={imageData} alt={product.name} className="card-img-top"  style={{
                    maxHeight: "250px",
                    width: "100%",
                    objectFit: "contain",
                    borderRadius: "10px",
                  }}/>}
      <div className="card-body">
        <h5 className="card-title">{product.name}</h5>
        <p className="card-text">{product.description}</p>
        <p className="card-price">₹{product.price}</p>
        <button onClick={addToCart} className="btn btn-primary">Add to Cart</button>
      </div>
    </div>
  );
};

export default ProductCard;