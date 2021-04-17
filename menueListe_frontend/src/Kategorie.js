import React, {useState, useEffect} from 'react';
import './App.css';
import {Link} from 'react-router-dom';
function Kategorie({match}) {


  const [essen, setEssen] = useState([]);

  useEffect(()=>{
    fetchEssen();
  },[]);

  
  const fetchEssen = async () => {
      fetch(`http://localhost:8080/demo/getByKategorie?kategorie=${match.params.kategorie}`) .then(response => response.json()) .then(data => setEssen(data));
    };
  
  return (
    <div>
      {essen.map(item =>(
        <div key={item.id}>
          <Link to={`${match.params.kategorie}/${item.essen_name}`}> 
              <h1>{item.essen_name}</h1>
              <img src={item.bild}/>  
           </Link>
      </div>
      ))}
    </div>
  );
}

export default Kategorie;
