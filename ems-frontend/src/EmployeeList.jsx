import React, { useEffect, useState } from 'react'
import axios from 'axios';
import UpdateEmployee from './UpdateEmployee';
const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [showModal, setShowModal] = useState(false);
    const [selectedEmployeeId, setSelectedEmployeeId] = useState(null);

    const fetchEmployees = async () => {
        setLoading(true);
        try {
            const response = await axios.get("/api/employees");
            setEmployees(response.data);
        } catch (err) {
            setError("Error fetching employee data")
        } finally {
            setLoading(false);
        }
    };

    //Update Employee Logic

    const updateEmployee = (employeeId) => {

        setSelectedEmployeeId(employeeId);
        setShowModal(true);
    }


    //Delete Employee Logic
    const deleteEmployee = async (employeeId) => {
        const confirmed = window.confirm("Are you sure you want to delete this employee?");
        if (confirmed) {
            try {
                await axios.delete(`/api/employees/${employeeId}`);
                alert("Employee Deleted Successfully");
                fetchEmployees();  // Refresh the list
            } catch (error) {
                console.error("Error Deleting Employee:", error.response?.data || error.message);
                alert("Failed to delete Employee");
            }
        }
    };
    

    useEffect(() => {
        fetchEmployees();
    }, []);

    const handleModalClose = () => {
        setShowModal(false);
        setSelectedEmployeeId(null);
    }
    if (loading) return <div className='text-center mt-5'>Loading....</div>
    if (error) return <div className='alert alert-danger text-center'>{error}</div>

    return (
        <div className='container mt-5'>
            <h1 className='text-center mb-4'>Employee List</h1>
            <button className='btn btn-primary mb-4' onClick={fetchEmployees}>
                Refreash Employee List
            </button>
            {employees.length === 0 ? <p>No Employees found</p> : (
                <ul className='list-group'>{employees.map((employee) => (
                    <div key={employee.id} className='card mb-3'>
                        <div className='card-body'>
                            <h5 className='mb-2 text-muted'>{employee.firstName}{employee.lastName}</h5>
                            <p>{employee.email}</p>
                            <div className='button-container' style={{ display: 'flex', gap: '10px' }}>
                                <button className='btn btn-primary' onClick={() => updateEmployee(employee.id)}>Update Button</button>
                                <button className='btn btn-danger ' onClick={() => deleteEmployee(employee.id)}>Delete Employee</button>
                            </div>
                        </div>
                    </div>
                ))}</ul>
            )}
            {/*Render the Update Employee Modal*/}
            {showModal && (
                <UpdateEmployee employeeId={selectedEmployeeId}
                    onClose={handleModalClose}
                    onUpdate={fetchEmployees} />
            )}
        </div>
    )
}

export default EmployeeList
