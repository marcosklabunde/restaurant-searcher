import axios from 'axios';

const BASE_URL = 'http://127.0.0.1:8080/restaurants';

const getRestaurantsByFilter = async (filter) => {
    try {
        const result = await axios(`${BASE_URL}/filter`, {
            params: { ...filter }
        });
        return result.data;
    } catch (error) {
        console.error(`Error fetching restaurants: ${error}`);
        return [];
    }
}

export { getRestaurantsByFilter };