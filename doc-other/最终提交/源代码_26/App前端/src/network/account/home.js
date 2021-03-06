import {oriRequest} from "network/network.js";

function getLogin(params) {
  //params
  const config = {
    url: '/login',
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
    url: '/loginbyphone',
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

//修改密码
function modifyPassWord(params) {
  //params
  const config = {
    url: '/resetpassword',
    params,
  }
  return oriRequest(config)
}


function register(profile) {
  // 结构对象
  // const {name,status,studentId,phone,passWord,checkCode,school,department} = params
  const params = profile
  //params
  const config = {
    url: '/register',
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
  getVerifyLogin,
  modifyPassWord
}