import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import 'config/validate/validation'
import 'config/vant/index'

Vue.config.productionTip = false




new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
