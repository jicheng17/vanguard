import axios from 'axios';
const API_URL = 'http://localhost:8000';
export class APIService{

  constructor(){
  }

  getContacts() {
      const url = `${API_URL}/api/contacts/`;
      return axios.get(url).then(response => response.data);
  }

  getContact(pk) {
      const url = `${API_URL}/api/contacts/${pk}`;
      return axios.get(url).then(response => response.data);
  }
}
