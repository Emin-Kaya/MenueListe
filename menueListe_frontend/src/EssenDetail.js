import React, {useState, useEffect} from 'react';
import './App.css';
function EssenDetail({match}) {


  const [item, setItem] = useState([]);

  useEffect(()=>{
    fetchEssen();
  },[]);

  
  const fetchEssen = async () => {
      fetch(`http://localhost:8080/demo/getByName?essen_name=${match.params.essendetail}`) .then(response => response.json()) .then(data => setItem(data));
    };
  
  return (
    <div>
     {item.map(item =>(
        <div key={item.id}>
              <h1>{item.essen_name}</h1>
              <h2>{item.kategorie}</h2>
              <h2>{item.preis}€</h2>
              <img src={item.bild}/>  
              <h2>{item.zutaten}</h2>


           
      </div>
      ))}
    </div>
  );
}

export default EssenDetail;
