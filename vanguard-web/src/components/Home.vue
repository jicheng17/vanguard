<template>
  <div class="hello">
    <h2>{{ msg }}</h2>

    <ul>
      <li><router-link to="/login">Login</router-link></li>
      <li><router-link to="/productList">Product List</router-link> </li>
    </ul>
  </div>
</template>

<script>
import ProductList from './ProductList'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Vanguard Home'
    }
  },
  components: {
    ProductList
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
