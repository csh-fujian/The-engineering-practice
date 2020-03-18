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

export {
  getHomeMultidata,
  getHomeGoods
}