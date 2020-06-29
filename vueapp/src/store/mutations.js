import {PHONE,ROLE,USERNAME,CURRENTCLASSID, ISTEACHER} from './mutation-types'

export default {
  // 输数量加1
  [PHONE](state, payload) {
    state.phone = payload
  },
  // 赋值role
  [ROLE](state, payload) {
    state.role = payload
  },

  //赋值username
  [USERNAME](state, payload) {
    state.userName = payload
  },

  [CURRENTCLASSID](state, payload) {
    state.currentClassId = payload
  },

  [ISTEACHER](state, payload) {
    state.isTeacher = payload
  }
}