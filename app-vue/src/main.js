import Vue from 'vue'
import './plugins/axios'
import './cube-ui'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

axios.defaults.timeout = 50000

Vue.config.productionTip = false
Vue.prototype._$axios = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
