export default {
  getPhone(state) {
    return this.state.phone
  },
  getStatus(state) {
    return state.token.status
  },
  getRole(state) {
    return state.role
  }
}