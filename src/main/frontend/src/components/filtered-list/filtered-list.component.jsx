import './filtered-list.styles.scss';
import Searcher from '../searcher/searcher.component';
import { DataGrid } from '@mui/x-data-grid';
import { useState } from 'react';
import { getRestaurantsByFilter } from '../../service/restaurant.service';

const listColumns = [
    { field: 'name', headerName: 'Name', width: 300 },
    { field: 'distance', headerName: 'Distance', width: 150 },
    { field: 'customerRating', headerName: 'Rating', width: 150 },
    { field: 'price', headerName: 'Price', width: 150,  valueGetter: (params) => `$ ${params.row.price}`},
    { field: 'cuisine', headerName: 'Cuisine', width: 300, valueGetter: (params) => `${params.row.cuisine.name}`},
]

const FilteredList = () => {
    const [ restaurantList, setRestaurantList ] = useState([]);

    const searcherCallback = (filter) => {
        const fetchRestaurants = async () => {
            const data = await getRestaurantsByFilter(filter);
            setRestaurantList(data);
        };

        fetchRestaurants();
    }

    return (
        <div className='filtered-list-container'>
            <Searcher submitCallback={searcherCallback}/>
            {
                restaurantList.length > 0 
                    && <DataGrid 
                            className='list-container' 
                            columns={listColumns} 
                            rows={restaurantList} 
                            autoHeight={true} 
                            hideFooter={true}/>
            }
        </div>
    )
}

export default FilteredList;