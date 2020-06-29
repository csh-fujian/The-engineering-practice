import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'
import mutations from './mutations'
import getters from "./getters";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    test: 'test',
    phone: '',
    token: {
      status: 'student'
    },
    //系统业务
    role: 'student',
    userName: '',
    currentClassId: '1',
    isTeacher: true
  },
  mutations,
  actions,
  getters,
  modules: {
  }
})
