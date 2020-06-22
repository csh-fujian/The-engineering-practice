import axios from 'axios'

// 带有拦截器的请求，用于登录成功后的api请求操作
export function request(config) {
  const instance = axios.create({
    // baseURL: 'http://47.112.239.108:8080',
    // baseURL: 'http://106.54.54.237:8000/api/wh',
    timeout: 50000
  })
  // 拦截器的请求
  instance.interceptors.request.use(request_config => {
    if (localStorage.token) {
      request_config.headers.Authorization = localStorage.token;
    }
    return request_config
  },
  error => {
    console.log(error)
  })


  // 拦截器的响应
  instance.interceptors.response.use(result=>{
    // token过期的问题 要商量

    result = result.data
    return result
  }, error => {
    console.log(error);
  })

  return instance(config)
}

//没带拦截器的请求，用于登录、注册、修改秘密
export function oriRequest(config) {
  const instance = axios.create({
    // 设置了代理
    // baseURL: 'http://47.112.239.108:8080',
    // baseURL: 'http://106.54.54.237:8000/api/wh',
    timeout: 50000
  })

  return instance(config)
}

export function singleSendMessage(phone, randcode) {
  // 发送验证码
  const Qsms=require("qcloudsms")
  const qsms=new Qsms("1400297576",'e1f6556578926674e1bfbe94e43e3aca')
  qsms.singleSendWithParams({
    phoneNumber: phone,
    tpl_id: 642205,
    params: [randcode],
    sign: '党务系统',
    nationCode : "86",
    extend : "",
    ext : ""
  }).then(res=>{

    console.log(res.data)
    if(res.data.result===0){
      console.log("success");
      // do success
    }else{
      //errors
      console.log("errors");
      //find your error code in this list
      //https://cloud.tencent.com/document/product/382/3771
    }
  })
}