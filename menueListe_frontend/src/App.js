import React from 'react';
import './App.css';
import Nav from './Nav';
import About from './About';
import Shop from './Shop';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Kategorie from './Kategorie';
import EssenDetail from './EssenDetail';

function App() {
  return (
    <Router>
    <div className="App">
      <Nav/>
      <Switch>
        <Route path="/" exact component={Home}/>
        <Route path="/about" component={About}/>
        <Route path="/shop" exact component={Shop}/>
        <Route path="/shop/:kategorie" exact component={Kategorie}/>
        <Route path="/shop/:kategorie/:essendetail" component={Kategorie,EssenDetail}/>
      </Switch>
    </div>
    </Router>
    
  );
}

const Home = () =>(
  <div>
    <h1>Home Page</h1>
  </div>
);

export default App;
