import axios from "axios";
import Navbar from "../Components/Navbar";
import ProductCard from "../Components/ProductCard";
import { useEffect, useState } from "react"


function Home() {
    
    const [products, setProducts] = useState([])

    useEffect(() => {
        axios.get(`http://127.0.0.1:7070/product/allProducts`)
            .then(res => {
                setProducts(res.data)
                console.log(res.data)
            })
            .catch(err => console.log(err));
        }, [])

    return(
        <>
        <Navbar/>
        <div className="container my-4">
        <div className="row">
          {products.map((product, index) => (
            <div key={index} className="col-md-4 col-sm-6 mb-4">
              <ProductCard product={product} />
            </div>
          ))}
        </div>
      </div>
        </>
    )
}

export default Home;