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

//加入班课申请接口
function joinClass(request_data) {
  const config = {
    url: '/api/join-class',
    params: {
      'classId':request_data
    }
  }
  return request(config)
}

//加入班课
function joinClassIn(request_data) {
  const config = {
    url: '/api/join-class/join-in',
    params: {
      'classId':request_data
    }
  }
  return request(config)
}

export {
  getHomeMultidata,
  getHomeGoods,
  joinClass,
  joinClassIn
}