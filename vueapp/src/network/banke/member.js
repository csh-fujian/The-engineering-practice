import {request} from "../network";

// 获取签到的历史记录
function getSignLog(params) {
  const config = {
    url: '/api/banke/id/member/launch-sign',
    params
  }
  return request(config)
}

export {
  getSignLog
}