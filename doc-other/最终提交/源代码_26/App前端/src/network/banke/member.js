import {request} from "../network";

//老师--------------------------------------
// 获取签到的历史记录
function getSignLog(params) {
  const config = {
    url: '/banke/id/member/launch-sign',
    params
  }
  return request(config)
}

//发布手势签到
function signPoseStart(params) {
  const config = {
    url: '/banke/id/member/launch-sign/pose',
    params
  }
  return request(config)
}

//结束手势签到
function signPoseEnd(params) {
  const config = {
    url: '/banke/id/member/launch-sign/pose-end',
    params
  }
  return request(config)
}



// 发布一键签到
function signNowStart(params) {
  const config = {
    url: '/banke/id/member/launch-sign/sign-now',
    params
  }
  return request(config)
}

// 一键签到结束
function signNowEnd(params) {
  const config = {
    url: '/banke/id/member/launch-sign/sign-end',
    params
  }
  return request(config)
}


//学生--------------------------------------
// 判断是否发布了签到
function studentSignIn(params) {
  const config = {
    url: '/participate',
    params
  }
  return request(config)
}

// 学生一键签到
function studentSignNow(params) {
  const config = {
    url: '/participate/1',
    params
  }
  return request(config)
}

function studentSignPose(params) {
  const config = {
    url: '/participate/2',
    params
  }
  return request(config)
}

export {
  getSignLog,
  signNowStart,
  signNowEnd,
  signPoseStart,
  signPoseEnd,
  studentSignIn,
  studentSignNow,
  studentSignPose
}