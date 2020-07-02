import {
  PHONE, ROLE, USERNAME, CURRENTCLASSID,
  ISTEACHER,
  StudentSignType,
  StudentSignId, TeacherLongitude, TeacherLatitude, TeskData
} from './mutation-types'

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
  },

  [StudentSignType](state, payload) {
    state.studentSignType = payload
  },
  [StudentSignId](state, payload) {
    state.studentSignId = payload
  },
  [TeacherLongitude](state, payload) {
    state.teacherLongitude = payload
  },
  [TeacherLatitude](state, payload) {
    state.teacherLatitude = payload
  },
  [TeskData](state, payload) {
    state.teskData = payload
  }
}