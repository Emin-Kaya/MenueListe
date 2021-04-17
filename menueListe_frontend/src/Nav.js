import React from 'react';
import logo from './logo.png';
import './App.css';
import {Link} from'react-router-dom';
function Nav() {

 

  return (
    <div>
        <nav>
            <img src={logo} alt="Logo" style={{height: '50px',width: 'auto'}}/>
            <ul className="nav-links">
                <Link style={{ textDecoration: 'none', color: 'white' }} to="/about">
                 <li className="link">About</li>
                </Link>
                <Link style={{ textDecoration: 'none', color: 'white' }} to="/shop">
                 <li className="link">Shop</li>
                </Link>
            </ul>
        </nav>
    </div>
  );
}

export default Nav;
