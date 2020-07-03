<template>
  <div class="content">
    <van-nav-bar title="修改密码"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft" >
    </van-nav-bar>
    <div class="content">


      <div class="margin-top-large">
        <van-cell-group class="margin-topdown-small">

          <van-cell title="手机号" >
            <template >
              <input class="input-css" v-model="phone" placeholder="输入手机号"/>
            </template>
          </van-cell>
          <div class="margin-topdown-small" />
        <van-cell title="验证码">
          <template >
            <van-row>
              <van-col span="12"><input class="input-css" v-model="checkCode" placeholder=""/></van-col>
              <van-col span="12"><van-button size="small" type="primary" @click="checkCodeClick">获取验证码</van-button></van-col>
            </van-row>
          </template>
        </van-cell>
        <div class="margin-topdown-small" />
          <van-cell title="密码" >
            <template >
              <input class="input-css" type="password" v-model="passWord"  placeholder="新密码"/>
            </template>
          </van-cell>

        </van-cell-group>
<!--        <van-icon  name="lock" class="iconCss" size="20px"/> <span class="spanLabel">密码</span><br>-->
<!--        <van-field-->
<!--                class="fieldCss"-->
<!--                v-model="passWord"-->
<!--                placeholder="请输入新密码"-->
<!--                size="large"-->

<!--        />-->
      </div>
      <div class="margin-top-normal" />
      <van-button type="primary" block class="margin-top-normal" @click="btnClick">修改密码</van-button>

    </div>
  </div>
</template>

<script>
  import {checkPhone, getCheckCode, setSha256} from "../common/utils";
  import {singleSendMessage} from "../network/network";
  import {modifyPassWord} from "../network/account/home";

  export default {
    data() {
      return {
        phone: '',
        passWord: '',
        checkCode: '',
      }
    },
    name: "ResetPassword",
    methods: {
      //验证码
      checkCodeClick() {
        const code = getCheckCode()
        const phone = this.phone
        if (checkPhone(phone)) {
          singleSendMessage(phone, code)
        }else {
          this.$toast('手机号输入错误')
        }
      },
      // 修改密码
      btnClick() {
        if (window.localStorage['checkCode'] == this.checkCode) {
          const params = {
            phone:this.phone,
            newPassWord:setSha256(this.passWord)
          }
          modifyPassWord(params).then(res => {
            let data = res.data
            if (data.msg == "ok") {
              this.$toast(data.data)
            }else {
              this.$toast('服务器错误，修改密码失败')
            }
          }).catch(err => {

          })
        }
      },
      onClickLeft() {

        this.$router.back();
      }
    }
  }
</script>

<style scoped>
  .iconCss {
    vertical-align: middle;
  }
  .spanLabel {
    font-size: 16px;
    text-align: center;
    vertical-align: middle;
  }

  .fieldCss {
    border-bottom : 0.5px outset var(--theme-color);
  }

  .input-css {
    width: 100%;
    text-align:right;
    border: none;
  }
</style>