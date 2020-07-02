import {request} from "../network";

function endClass(params) {
  const config = {
    url: '/banke/id/detail/end',
    params
  }
  return request(config)
}

function exitClass(params) {
  const config = {
    url: '/login-out',
    params
  }
  return request(config)
}
//
//
// function deleteClass(params) {
//   const config = {
//     url: '/api/banke/id/one-class',
//     params
//   }
//   return request(config)
// }

export {
  endClass,
  exitClass,
  // deleteClass
}