import Vue from 'vue'
import App from './App'
import store from './store'
import router from './router'
import iView from 'iview'
import axios from 'axios'
import 'iview/dist/styles/iview.css'
import './permission'
import Element from 'element-ui'
import moment from 'moment'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
Vue.use(iView)
Vue.use(Element)

// 设置基础URL
axios.defaults.baseURL = 'http://127.0.0.1:8081'
// axios.defaults.baseURL = 'https://768959b5.ngrok.io/'
// 设置请求超时时间
axios.defaults.timeout = 50000
axios.defaults.headers.common['Authorization'] = 'AUTH_TOKEN'

Vue.prototype.$axios = axios
// 定义全局过滤器
Vue.filter('timestampToDate', (timestamp, pattern = 'YYYY-MM-DD') => {
  return moment(timestamp).format(pattern)
})
// eslint-disable-next-line no-new
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
