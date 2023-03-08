import React, { Component } from 'react';
import axios from 'axios';
import './create.css';
import {Link} from 'react-router-dom';
import { color } from '@mui/system';

class Shopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: '',
      name: '',
      quantity: '',
      price: ''
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleidChange = (event) => {
    this.setState({ id: event.target.value });
  }
  handleNameChange = (event) => {
    this.setState({ name: event.target.value });
  }
  handleQuantityChange = (event) => {
    this.setState({ quantity: event.target.value });
  }
  handlePriceChange = (event) => {
    this.setState({ price: event.target.value });
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value }); 
}
  
  handleSubmit(event) {
    event.preventDefault();
    const orderData = {
      id: this.state.id,
      name: this.state.name,
      quantity: this.state.quantity,
      price: this.state.price,
    };
    console.log(orderData)
    axios.post('http://127.0.0.1:8080/addProduct', orderData)
    //   .then((response) => {
    //     console.log(response);
    //   })
    //   .catch((error) => {
    //     console.log(error);
    //   });
  };
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <h2 className='color1'>Shopping Details</h2>
        <input
          placeholder='Id'
          type="text"
          name="id"
          value={this.state.id}
          onChange={this.handleChange}
        />
        <input
          placeholder='Name'
          type="text"
          name="name"
          value={this.state.name}
          onChange={this.handleChange}
        />
        <input
          placeholder='Quantity'
          type="text"
          name="quantity"
          value={this.state.Quantity}
          onChange={this.handleChange}
        />
              

        <input
          placeholder='Price'
          type="text"
          name="price"
          value={this.state.price}
          onChange={this.handleChange}
        />
       
            <button>Submit</button>
            <div className='next'>
            <Link to="/table" style={{color: "white"}}> View Table </Link>
            </div>
            </form>
        );
    }
}
export default Shopping;