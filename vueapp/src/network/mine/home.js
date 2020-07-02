import {request} from "../network";

function updateProfile(user) {
  const config = {
    url: '/mine/profile-update',
    data: user,
    method: 'post',
  }
  return request(config)
}

function getProfile(params) {
  const config = {
    url: '/mine',
    params
  }
  return request(config)
}



export {
  updateProfile,
  getProfile
}