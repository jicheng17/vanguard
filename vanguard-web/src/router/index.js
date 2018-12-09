import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import AddTicket from '@/components/AddTicket'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/add',
      name: 'add',
      component: AddTicket
    }
  ]
})
