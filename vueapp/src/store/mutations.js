import {PHONE,ROLE} from './mutation-types'

export default {
  // 输数量加1
  [PHONE](state, payload) {
    state.phone = payload
  },
  // 输数量加1
  [ROLE](state, payload) {
    state.role = payload
  },
}