// src/services/authService.ts

import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/admin';

export const signupAdmin = async (name: string, password: string, email: string) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/signup`, {
            name,
            password,
            email,
            role: 'ADMIN', // Set the role to ADMIN
        });
        return response.data;
    } catch (error) {
        console.error('Error signing up admin:', error);
        throw error;
    }
};
