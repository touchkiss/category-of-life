import Vue from 'vue'
import './plugins/axios'
import { Button, CellItem, Field, Icon, Switch, Popup, PopupTitleBar, Transition, InputItem, TextareaItem } from 'mand-mobile'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import 'normalize.css'

axios.defaults.timeout = 50000
// axios.defaults.baseURL = 'http://192.168.1.11:8090/'

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

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
