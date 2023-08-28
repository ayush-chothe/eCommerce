import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';

function Products() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get(`http://127.0.0.1:7070/product/allProducts/${sessionStorage.getItem("userId")}`)
             .then(res => {
                setProducts(res.data);
             })
             .catch(err => console.log(err));
    }, []);

    const navigate = useNavigate();

    const deleteProduct = (productId) => {
        axios.get(`http://127.0.0.1:7070/product/deleteProduct/${productId}`)
            .then(res => console.log(res.data))
            .catch(err => console.log(err));
    }

    return (
        <div className='container mt-5'>
            <div className="card p-4 shadow-sm">
                <div className="d-flex justify-content-between align-items-center mb-3">
                    <h2 className="mb-0">List of Products</h2>
                    <Link to='/seller/addProduct' className='btn btn-primary'>
                        Add Product
                    </Link>
                </div>
                <div className="table-responsive">
                    <table className='table table-hover'>
                        <thead className='thead-dark'>
                            <tr>
                                <th>ID</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category ID</th>
                                <th className="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {products
                                .filter(p => p.status === "ADDED")
                                .map((product) => (
                                    <tr key={product.id}>
                                        <td>{product.id}</td>
                                        <td>{product.name}</td>
                                        <td>{product.price}</td>
                                        <td>{product.quantity}</td>
                                        <td>{product.categoryId}</td>
                                        <td className="text-center">
                                            <div className="btn-group" role="group">
                                                <button
                                                    className='btn btn-sm btn-info'
                                                    onClick={() => navigate(`/product/edit/${product.id}`)}
                                                >
                                                    Edit
                                                </button>
                                                <button
                                                    className='btn btn-sm btn-danger'
                                                    onClick={() => deleteProduct(product.id)}
                                                >
                                                    Delete
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default Products;
