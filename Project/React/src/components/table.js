import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import {Link} from 'react-router-dom';

export default function Table1() {
    const [data,setData] = useState([]);

    function init() {
        axios.get('http://localhost:8080/products')
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.log(error);
            });     
    };

    const deleteData = (id) => {
        axios.delete(`http://localhost:8080/delete/${id}`)
          .then((response) => {
            const newdata = data.filter((item) => item.id !== id);
            setData(newdata);
          })
          .catch((error) => {
            console.log(error);
          });
      };

    const updateData = (id, newData) => {
        axios.put(`http://localhost:8080/update`, newData)
          .then((response) => {
            const newdata = data.map((item) => {
              if (item.id === id) {
                return { ...item, ...newData };
              }
              return item;
            });
            setData(newdata);
          })
          .catch((error) => {
            console.log(error);
          });
      };

    useEffect(() => { init() }, [])
    return (

      <div className="table">
      <h1> Shopping Details </h1>
        <table border={1}>
            <thead>

                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    
                </tr>
            </thead>
            <tbody>
                {data.map(user => (
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.name}</td>
                        <td>{user.quantity}</td>
                        <td>{user.price}</td>
                        <td>
                        <button
                        className="btn btn-primary"
                        onClick={() => deleteData(user.id)}
                      >
                        Delete
                      </button>
                      <button
                        className="btn btn-secondary"
                        onClick={() => {
                          const newData = prompt("Enter new data:");
                          if (newData) {
                            updateData(user.id, { price: newData });
                          }
                        }}
                      >
                        Update
                      </button> 
                        </td>

                    </tr>

                ))}
            </tbody>
        </table>
        <Link to="/"> Previous </Link>
      </div>
    );
}