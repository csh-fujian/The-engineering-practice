import {request} from "../network";

function getOneClass(params) {
  const config = {
    url: '/api/banke/id/one-class',
    params
  }
  return request(config)
}

export {
  getOneClass
}