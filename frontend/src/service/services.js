import axios from 'axios'

import { BASE_URL } from './requests'

export const retrieveAllCategoria = () => {
    return axios.get(`${BASE_URL}/category`)
}

export const saveCategoria = (investimento) => {
    return axios.post(`${BASE_URL}/category`, investimento)
}

export const deleteCategoria = (id) => {
    return axios.delete(`${BASE_URL}/category/${id}`)
}

export const retrieveAllInvestimento = () => {
    return axios.get(`${BASE_URL}/investment`)
}

export const saveInvestimento = (investimento) => {
    return axios.post(`${BASE_URL}/investment`,investimento)
}

export const deleteInvestimento = (id) => {
    return axios.delete(`${BASE_URL}/investment/${id}`)
}
