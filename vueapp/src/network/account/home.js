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

function getVerifyLogin(params) {
  //params
  const config = {
    url: '/api/loginbyphone',
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

function register(profile) {
  // 结构对象
  // const {name,status,studentId,phone,passWord,checkCode,school,department} = params
  const params = profile
  //params
  const config = {
    url: '/api/register',
    method: 'get',
    // params: params,
    // params: {
    //   // type: 'account',
    //   name,status,studentId,phone,passWord,school,department
    // }
    params
  }
  return oriRequest(config)
}

export {
  getLogin,
  register,
  getVerifyLogin
}