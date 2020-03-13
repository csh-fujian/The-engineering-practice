import axios from 'axios'

export function request(config) {
  const instance = axios.create({
    baseURL: 'http://123.207.32.32:8000/api/wh',
    // baseURL: 'http://106.54.54.237:8000/api/wh',
    timeout: 50000
  })

  instance.interceptors.response.use(result=>{
    result = result.data
    return result
  }, error => {
    console.log(error);
  })

  return instance(config)
}

export function oriRequest(config) {
  const instance = axios.create({
    baseURL: 'http://123.207.32.32:8000/api/wh',
    // baseURL: 'http://106.54.54.237:8000/api/wh',
    timeout: 50000
  })

  return instance(config)
}