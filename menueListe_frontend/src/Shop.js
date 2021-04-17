import React, {useState, useEffect} from 'react';
import './App.css';
import {Link} from 'react-router-dom';
function Shop() {


  const [kategorien, setKategorie] = useState([]);

  useEffect(()=>{
    fetchKategorie();
  },[]);

  
  const fetchKategorie = async () => {
      fetch('http://localhost:8080/demo/getUniqueKategorie') .then(response => response.json()) .then(data => setKategorie(data));
    };
  
  return (
    <div>
      {kategorien.map(item =>(
          <h1 key={item}>
           <Link to={`/shop/${item}`}>{item}</Link>
            </h1>
      ))}
    </div>
  );
}

export default Shop;
