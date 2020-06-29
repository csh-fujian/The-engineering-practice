export default {
  getPhone(state) {
    return this.state.phone
  },
  getStatus(state) {
    if (state.role == '学生')
      return 'student'
    else if (state.role == '老师')
      return 'teacher'
  },
  getRole(state) {
    return state.role
  },
  getUserName(state) {
    return state.userName
  },
  getCurrentClassId(state) {
    return state.currentClassId
  },
  getIsTeacher(state) {
    return state.isTeacher
  }
}