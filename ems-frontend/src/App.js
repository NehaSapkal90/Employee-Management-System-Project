import React from 'react'
import EmployeeList from './EmployeeList'

import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import CreateEmployee from './CreateEmployee';
// import { Link } from 'react-router-dom';


const App = () => {

  return (
    <Router>

      <div>
        <nav>
          <ul className='nav'>
            <li className='nav-item'>
              <Link className='nav-link' to={"/create"}>Create Employee</Link>
            </li>
            <li className='nav-item'>

              <Link className='nav-link' to={"/get"}>Employee List</Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path='/create' element={<CreateEmployee />} />
          <Route path='/get' element={<EmployeeList />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App
