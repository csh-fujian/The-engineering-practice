import {oriRequest} from "network/network.js";

function getLogin(params) {
  //params
  const config = {
    url: '/api/login',
    method: 'post',
    params: params,
    // params: {
    //   // type: 'account',
    //   username: '190327014',
    //   password: '12345678',
    // }
  }
  return oriRequest(config)
}

function register(params) {
  // 结构对象
  const {name,status,studentId,phone,passWord,checkCode,school,department} = params
  //params
  const config = {
    url: '/api/register',
    method: 'post',
    // params: params,
    params: {
      // type: 'account',
      name,status,studentId,phone,passWord,school,department
    }
  }
  return oriRequest(config)
}

export {
  getLogin,
  register
}