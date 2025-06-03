import axios from 'axios';

import React, { useState } from 'react'

const CreateEmployee = () => {

  const [employee, setEmployee] = useState(
    {
      firstName: "",
      lastName: "",
      email: ""
    });
  const [message, setMessage] = useState('');
  const handleInputChanges = (e) => {
    const { name, value } = e.target;
    setEmployee({ ...employee, [name]: value });
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/employees', employee);
      setMessage("Employee Created Successfully");
      setEmployee({
        firstName: "",
        lastName: "",
        email: "",
      });

    } catch (error) {
      setMessage("Error creating employee..")
    }
  };
  return (
    <div>
      <h1 className='text-center mb-4'>
        Create New Employee
      </h1>
      <form className='text-center mb-4' onSubmit={handleSubmit}>
        <div className='text-center mb-4' ><label>First Name: </label><input type='text' name='firstName' value={employee.firstName} onChange={handleInputChanges} required /></div>
        <div className='text-center mb-4'><label>Last Name: </label><input type='text' name='lastName' value={employee.lastNameName} onChange={handleInputChanges} required /></div>
        <div className='text-center mb-4'><label>Email: </label><input type='email' name='email' value={employee.email} onChange={handleInputChanges} required /></div>
        <button className='btn btn-danger'type='submit'>Create New Employee</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  )
}

export default CreateEmployee
