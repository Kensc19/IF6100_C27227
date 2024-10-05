import axios, { AxiosInstance } from "axios";

const apiInstance: AxiosInstance = axios.create({
    baseURL: "http://localhost:8080",
});
    
apiInstance.get('/example-endpoint')
    .then(response => console.log(response.data))
    .catch(error => console.error(error));