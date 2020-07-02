import {request} from "../network";

//获得一个班课信息
function getOneClass(params) {
  const config = {
    url: '/banke/id/one-class',
    params
  }
  return request(config)
}

//创建任务
function createWork(params) {
  const config = {
    url: '/banke/id/oneclass/createWork',
    params
  }
  return request(config)
}
//上传任务
function upLoadWork(params) {
  const config = {
    url: '/banke/id/oneclass/upLoadWork',
    params
  }
  return request(config)
}


export {
  getOneClass,
  createWork,
  upLoadWork
}