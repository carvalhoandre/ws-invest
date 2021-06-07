import axios from 'axios'

import { BASE_URL } from './requests'

export const retrieveAllCategoria = () => {
    return axios.get(`${BASE_URL}/categoria`)
}

export const saveCategoria = (investimento) => {
    return axios.post(`${BASE_URL}/categoria`, investimento)
}

export const deleteCategoria = (id) => {
    return axios.delete(`${BASE_URL}/categoria/${id}`)
}

export const retrieveAllInvestimento = () => {
    return axios.get(`${BASE_URL}/categoria`)
}

export const saveInvestimento = (investimento) => {
    return axios.post(`${BASE_URL}/investimentos`,investimento)
}

export const deleteInvestimento = (id) => {
    return axios.delete(`${BASE_URL}/investimento/${id}`)
}
