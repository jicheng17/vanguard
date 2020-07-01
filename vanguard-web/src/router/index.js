import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import AddTicket from '@/components/AddTicket'
import ProductList from '@/components/ProductList'
import Login from '@/components/Login'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
     },
    {
      path: '/add',
      name: 'add',
      component: AddTicket
    },
    {
        path: '/productlist',
        name: 'ProductList',
        component: ProductList
    },
    {
        path: '*',
        redirect: '/'
    }
  ]
})
