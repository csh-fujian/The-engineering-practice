import {TEST} from './mutation-types'


export default {
  [TEST](context, payload) {
    return new Promise((resolve, reject) => {
      resolve('测试')
    })

  }
}