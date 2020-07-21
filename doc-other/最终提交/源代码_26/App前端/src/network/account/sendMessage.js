


export class SendMsgService {



  sendMessage(phone, random) {

    (window as any).global = window;
    global.Buffer = global.Buffer || require('buffer').Buffer;
    (window as any).process = {
      version: ''
    };
    global.process.nextTick = setImmediate;
    let QcloudSms = require('qcloudsms_js');
    // 短信应用 SDK AppID
    let appid = 1400297576;  // SDK AppID 以1400开头
    // 短信应用 SDK AppKey
    let appkey = 'e1f6556578926674e1bfbe94e43e3aca';
    // 需要发送短信的手机号码
    let phoneNumbers = [phone];
    // 短信模板 ID，需要在短信控制台中申请
    let templateId = 506791;  // NOTE: 这里的模板ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
    // 签名
    let smsSign = '党务系统';  // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名'腾讯云'只是示例，真实的签名需要在短信控制台申请
    // 实例化 QcloudSms
    let qcloudsms = QcloudSms(appid, appkey);
    // 设置请求回调处理, 这里只是演示，用户需要自定义相应处理回调

    let msender = qcloudsms.SmsSingleSender();
    let params = [random];
    msender.sendWithParam("86", phoneNumbers, templateId, params, smsSign, "", "", this.callback);

    return 'success';
  }




  // 简单封装一下, 向指定手机下发验证码
  // sendCode('18212341234', 1234) // 发送短信
  sendCode (phone, code, time = 10) {
    const QcloudSms = require('qcloudsms_js');
    const cfg = {
      appid: 1400297576, // SDK AppID 以1400开头
      appkey:  'e1f6556578926674e1bfbe94e43e3aca', // 短信应用 SDK AppKey
      templateId: 506791, // 短信模板 ID，需要在短信控制台中申请
      smsSign: '腾讯云', // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
    };

    phone = typeof(phone) === 'object' ? phone : [phone]
    const qcloudsms = QcloudSms(cfg.appid, cfg.appkey) // 实例化 QcloudSms
    const msender = qcloudsms.SmsMultiSender();
    msender.sendWithParam(86,
        phone, // 一个数组
        cfg.templateId, // 模版 id
        [code, time], // 正文中的参数值
        cfg.smsSign, // 签名 未提供或者为空时，会使用默认签名发送短信
        '', '',
        (err, res, resData) => { // 回调函数
          err && console.log('err: ', err)
          console.log('request data: ', res.req)
          console.log('response data: ', resData)
        })
  }

  callback(err, res, resData) {
    if (err) {
      console.log("err: ", err);
    } else {
      console.log("request data: ", res.req);
      console.log("response data: ", resData);
    }
  }

}
