//防抖函数
export function debounce(func, delay) {
  let timer = null
  return function (...args) {
    if(timer) clearTimeout(timer)
    timer = setTimeout(()=>{
      func.apply(this, args)
    }, delay)
  }
}


export function setSha256(data) {
  let sha256 = require("js-sha256").sha256
  data = sha256(data)
  console.log(data)
  return data
}

export  function checkPhone(phone){
  if(!(/^1[3456789]\d{9}$/.test(phone))){
    alert("手机号码有误，请重填");
    return false;
  }else {
    return true
  }
}


//生成四位验证码
export function getCheckCode() {
  const count = 4
  let res= ""
  for (let i=0 ; i<4; i++) {
    res = res + Math.round(Math.random() * 9)
  }
  console.log(res);
  window.localStorage['checkCode'] = res
  return res
}


// 设置时间
export function formatDate(date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
  }
  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  return fmt;
};

function padLeftZero (str) {
  return ('00' + str).substr(str.length);
};