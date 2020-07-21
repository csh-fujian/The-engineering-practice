<template>
  <div class="content">
    <van-sticky>
      <van-nav-bar title="注册用户"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <ValidationObserver slim ref="profile">

      <van-cell-group class="margin-topdown-small">

        <ValidationProvider name="姓名" rules="required" v-slot="{ errors }" slim>
          <van-cell title="* 姓名" :label="errors[0]">
            <template >
                <input class="input-css" v-model="profile.Name"/>
            </template>
          </van-cell>
        </ValidationProvider>

        <ValidationProvider name="昵称" rules="required" v-slot="{ errors }" slim>
          <van-cell title="* 昵称" :label="errors[0]">
            <template >
              <input class="input-css" v-model="profile.nickName"/>
            </template>
          </van-cell>
        </ValidationProvider>


        <van-cell title="* 身份">
          <template>
            <van-radio-group v-model="statusRadio" direction="horizontal" class="right">
              <van-radio name="student">学生</van-radio>
              <van-radio name="teacher">老师</van-radio>
            </van-radio-group>
          </template>
        </van-cell>

        <ValidationProvider name="手机号" rules="required|phone" v-slot="{ errors }" slim>
          <van-cell title="* 电话" :label="errors[0]">
            <template >
              <input class="input-css" v-model="profile.phone"/>
            </template>
          </van-cell>
        </ValidationProvider>
      </van-cell-group>


      <van-cell-group class="margin-topdown-small">
        <ValidationProvider name="学号" rules="required" v-slot="{ errors }" slim>
        <van-cell title="* 学号" :label="errors[0]">
          <template >
            <input class="input-css" v-model="profile.studentId"/>
          </template>
        </van-cell>
        </ValidationProvider>


        <van-cell title="学校">
          <template >
            <input class="input-css" v-model="profile.school"/>
          </template>
        </van-cell>
        <van-cell title="学院">
          <template >
            <input class="input-css" v-model="profile.department"/>
          </template>
        </van-cell>
          <van-cell title="专业" >
            <template >
              <input class="input-css" v-model="profile.master"/>
            </template>
          </van-cell>


      </van-cell-group>


      <van-cell-group class="margin-topdown-small">
        <ValidationProvider name="验证码" rules="required" v-slot="{ errors }" slim>
        <van-cell title="* 验证码" :label="errors[0]">
          <template >
            <van-row>
              <van-col span="12"><input class="input-css" v-model="checkcode"/></van-col>
              <van-col span="12"><van-button size="small" type="primary" @click="checkCodeClick">验证码 </van-button></van-col>
            </van-row>
          </template>
        </van-cell>
        </ValidationProvider>

        <ValidationProvider name="密码" rules="required" v-slot="{ errors }" slim>
        <van-cell title="* 密码" :label="errors[0]">
          <template >
            <input class="input-css" type="password" v-model="profile.passWord" />
          </template>
        </van-cell>
        </ValidationProvider>

        <ValidationProvider name="确认密码" rules="required" v-slot="{ errors }" slim>
        <van-cell title="* 确认密码" :label="errors[0]">
          <template >
            <input class="input-css" type="password" v-model="profile.repassWord"/>
          </template>
        </van-cell>
        </ValidationProvider>
      </van-cell-group>
    </ValidationObserver>

    <van-checkbox v-model="checked"
                  class="margin-topdown-small">已阅读并同意《用户协议》</van-checkbox>



    <van-button plain
                hairline
                type="primary"
                block
                :disabled="!checked"
                class="margin-top-normal"
                @click="register">注册</van-button>

  </div>
</template>

<script>

  // import {profile} from "mock/mine/data";
  import {formatDate} from "common/utils";
  import {register} from "../../../network/account/home";
  import {checkPhone, getCheckCode, setSha256} from "../../../common/utils";
  import {singleSendMessage} from "../../../network/network";

  export default {
    name: "Profile",
    data() {
      return {
        // profile: profile,
        sexRadio: 'male',
        statusRadio: 'student',
        checked: false,
        cannt_click: true,
        checkcode: '',
        checkCodeIsY: false,
        profile: {
          Name: '',
          school: '',
          phone: '',
          department: '',
          status: '',
          studentId: '',
          experience: 0,
          passWord: '',
          repassWord: '',
          master:'',
          nickName:''
        }
      }
    },
    created() {
      this.sexRadio = this.profile.sex
      this.statusRadio = 'student'
    },
    components: {
    },

    methods: {

      //验证码
      checkCodeClick() {
        const code = getCheckCode()
        const phone = this.profile.phone
        if (checkPhone(phone)) {
          singleSendMessage(phone, code)
        }

      },

      register() {

        this.$refs.profile.validate().then(success => {
          // success结果返回布尔值
          if (!success) {
            this.$toast('信息填写有误')
            return
          }
          // 处理请求
          if (window.localStorage['checkCode'] == this.checkcode) {
            this.requestRegister()
          } else {
            this.$toast('验证码错误')
            return;
          }

          this.$nextTick(() => {
            // 清除验证状态，需注意值不会清除要自己手动清除
            this.$refs.profile.reset()
          })
        })

      },
      requestRegister() {
        if (this.statusRadio == 'student')
          this.profile.status = 'student'
        else
          this.profile.status = 'teacher'

        if (this.profile.passWord != this.profile.repassWord) {
          this.$toast('密码不一致')
          return;
        }
        let profiledata = JSON.parse(JSON.stringify(this.profile))
        profiledata.passWord = setSha256(this.profile.passWord)
        profiledata.repassWord = setSha256(this.profile.repassWord)

        console.log(profiledata);
        // 注册
        register(profiledata).then(res=> {
          console.log(res);
          if (res.data == 1) {
              this.$toast('注册成功')
              this.$router.replace('\login')
            }else if(res.data == -1){
              this.$toast('注册失败')
            } else {
              this.$toast('手机号、昵称或学号重复')
          }
        }).catch(err=>{
          console.log(err);
        })
      },
      birthTimeClick() {
        this.$refs.timePick.show = true
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>
  .input-css {
    width: 100%;
    text-align:right;
    border: none;
  }
</style>