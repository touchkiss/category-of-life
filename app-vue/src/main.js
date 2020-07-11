import Vue from 'vue'
import './plugins/axios'
import { CellItem, Field, Icon, Switch, Popup, PopupTitleBar, Transition, InputItem, TextareaItem, TabBar, Swiper, SwiperItem } from 'mand-mobile'
import { Button } from 'element-ui'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import animated from 'animate.css'
import './plugins/element.js'

axios.defaults.timeout = 50000
axios.defaults.baseURL = 'http://192.168.8.67:8090/'

Vue.config.productionTip = false
Vue.prototype._$axios = axios
Vue.component(Button.name, Button)
Vue.component(CellItem.name, CellItem)
Vue.component(Field.name, Field)
Vue.component(Icon.name, Icon)
Vue.component(Switch.name, Switch)
Vue.component(Popup.name, Popup)
Vue.component(PopupTitleBar.name, PopupTitleBar)
Vue.component(Transition.name, Transition)
Vue.component(InputItem.name, InputItem)
Vue.component(TextareaItem.name, TextareaItem)
Vue.component(TabBar.name, TabBar)
Vue.component(Swiper.name, Swiper)
Vue.component(SwiperItem.name, SwiperItem)

Vue.use(animated)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
