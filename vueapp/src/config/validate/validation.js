import Vue from 'vue'
import { extend } from 'vee-validate';
import { ValidationProvider } from 'vee-validate'; // 表单验证
Vue.component('ValidationProvider', ValidationProvider);

//全局设置交互模式
import { setInteractionMode } from 'vee-validate';
setInteractionMode('lazy'); //失去焦距激活


// 导入库规则
import { required, email } from 'vee-validate/dist/rules';
// 安装规则
extend('email', email);
// Override the default message.
extend('email', {
  ...required,
  message: 'email format error'
});


//css 配置
import { configure } from 'vee-validate';
configure({
  classes: {
    valid: 'is-valid',
    invalid: 'is-invalid',
    dirty: ['is-dirty', 'is-dirty'], // multiple classes per flag!
  }
})


import { localize } from 'vee-validate';
import en from 'vee-validate/dist/locale/en.json';
import zh from 'vee-validate/dist/locale/ar.json';
// Install English and Arabic locales.
localize({
  en,
  zh
});
//本地化的字段名称
localize({
  en: {
    names: {
      email: 'email format error',
      mobile: 'mobile format error'
    }
  },
  zh: {
    names: {
      email: '电子邮箱格式错误',
      mobile: '手机号码格式错误'
    }
  }
});



// 定义规则
extend('positive', {
  validate: value => {
    return value>0
  },
  message: 'This field must be an odd number'
});

extend('mobile', {
  validate: value => {
    return /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)
  },
  message: '手机格式错误',
})

