import './searcher.styles.scss';
import { TextField, Button } from '@mui/material';
import { useState } from 'react';

const defaultFormFields = {
    restaurantName: '',
    distance: '',
    customerRating: '',
    price: '',
    cuisineName: '',
}

const Searcher = ({submitCallback}) => {
    const [ formFields, setFormFields ] = useState(defaultFormFields);
    const { restaurantName, distance, customerRating, price, cuisineName } = formFields;

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormFields({ ...formFields, [name]: value});
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        submitCallback(formFields);
    };

    return (
        <div className='searcher-container'>
            <form className='form' onSubmit={handleSubmit}>
                <div className='fields-container'>
                    <TextField 
                        className='field'
                        variant='filled'
                        type='text'
                        label='Name'
                        name='restaurantName'
                        value={restaurantName}
                        onChange={handleChange}/>
                    <TextField 
                        className='field'
                        variant='filled'
                        type='number'
                        label='Distance'
                        name='distance'
                        value={distance}
                        onChange={handleChange}/>
                    <TextField 
                        className='field'
                        variant='filled'
                        type='number'
                        label='Rating'
                        name='customerRating'
                        value={customerRating}
                        onChange={handleChange}/>
                    <TextField 
                        className='field'
                        variant='filled'
                        type='number'
                        label='Price'
                        name='price'
                        value={price}
                        onChange={handleChange}/>
                    <TextField 
                        className='field'
                        variant='filled'
                        type='text'
                        label='Cuisine'
                        name='cuisineName'
                        value={cuisineName}
                        onChange={handleChange}/>
                </div>
                <Button type='submit' variant='contained' color='primary'>Search</Button>
            </form>
        </div>
    )
}

export default Searcher;