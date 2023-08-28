import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Navbar( {setData, data}) {
  const navigate = useNavigate();

  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <a className="navbar-brand" onClick={() => navigate('/')}>
          Flipkart
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="navbar-collapse collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <button className="nav-link btn" onClick={() => navigate('/')}>
                Home
              </button>
            </li>
            <li className="nav-item">
              <button className="nav-link btn" onClick={() => navigate('/cart')}>
                Cart
              </button>
            </li>
            <li className="nav-item">
              <button className="nav-link btn" onClick={() => navigate('/orders')}>
                Orders
              </button>
            </li>
          </ul>
          <form className="d-flex" role="search">
            <input className="form-control me-2" onChange={(e) => setData(e.target.value)} value={data} type="search" placeholder="Search" aria-label="Search" />
          </form>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
