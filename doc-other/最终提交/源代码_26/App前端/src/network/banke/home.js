import {request} from 'network/network.js'

function getHomeMultidata() {
  const config = {
    url: '/home/multidata',
  }
  return request(config)
}

function getHomeGoods(type, page) {
  const config = {
    url: '/home/data',
    params: {
      type, page
    }
  }
  return request(config)
}

//创建班课
function createClass(params) {
  const config = {
    url:'/banke/create',
    params
  }
  return request(config)
}



//班课首页数据(传入username+flag)
function getBankeData(params) {
  const config = {
    url: '/banke',
    params,
  }
  return request(config)
}


//加入班课申请接口
function joinClass(request_data) {
  const config = {
    url: '/joinClass',
    params: {
      'classId':request_data
    }
  }
  return request(config)
}

//加入班课
function joinClassIn(params) {
  const config = {
    url: '/join-class/join-in',
    params,
  }
  return request(config)
}

export {
  getHomeMultidata,
  getHomeGoods,
  joinClass,
  joinClassIn,
  getBankeData,
  createClass
}