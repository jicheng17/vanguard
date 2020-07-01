// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuetify from 'vuetify'
import App from './App'
import router from './router'
import axios from 'axios'


Vue.config.productionTip = false

Vue.use(Vuetify)

// Setup axios to be available globally through Vue
Vue.axios = Vue.prototype.$http = axios.create({
  baseURL: 'http://localhost:8081/api'
})

/* eslint-disable */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
