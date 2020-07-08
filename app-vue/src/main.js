import Vue from 'vue'
import './plugins/axios'
import { Button, CellItem, Field, Icon, Switch, Popup, PopupTitleBar } from 'mand-mobile'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import 'normalize.css'

axios.defaults.timeout = 50000

Vue.config.productionTip = false
Vue.prototype._$axios = axios
Vue.component(Button.name, Button)
Vue.component(CellItem.name, CellItem)
Vue.component(Field.name, Field)
Vue.component(Icon.name, Icon)
Vue.component(Switch.name, Switch)
Vue.component(Popup.name, Popup)
Vue.component(PopupTitleBar.name, PopupTitleBar)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
