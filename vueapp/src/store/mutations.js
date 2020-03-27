import {PHONE} from './mutation-types'

export default {
  // 输数量加1
  [PHONE](state, payload) {
    state.phone = payload
  },
}