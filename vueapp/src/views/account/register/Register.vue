<template>
  <div class="content">
    <van-sticky>
      <van-nav-bar title="注册用户"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <van-cell-group class="margin-topdown-small">
      <van-cell title="* 姓名">
        <template >
          <input class="input-css" :value="profile.Name"/>
        </template>
      </van-cell>

      <van-cell title="* 身份">
        <template>
          <van-radio-group v-model="statusRadio" direction="horizontal" class="right">
            <van-radio name="student">学生</van-radio>
            <van-radio name="teacher">老师</van-radio>
          </van-radio-group>
        </template>
      </van-cell>

      <van-cell title="* 电话">
        <template >
          <input class="input-css" :value="profile.phone"/>
        </template>
      </van-cell>

    </van-cell-group>

    <van-cell-group class="margin-topdown-small">
      <van-cell title="* 学号">
        <template >
          <input class="input-css" :value="profile.studentId"/>
        </template>
      </van-cell>

      <van-cell title="学校">
        <template >
          <input class="input-css" :value="profile.school"/>
        </template>
      </van-cell>
      <van-cell title="学院">
        <template >
          <input class="input-css" :value="profile.department"/>
        </template>
      </van-cell>
    </van-cell-group>

    <van-cell-group class="margin-topdown-small">
      <van-cell title="* 验证码">
        <template >
          <van-row>
            <van-col span="12"><input class="input-css" :value="profile.studentId"/></van-col>
            <van-col span="12"><van-button size="small" type="primary">验证码 </van-button></van-col>

          </van-row>


        </template>
      </van-cell>

      <van-cell title="* 密码">
        <template >
          <input class="input-css" type="password" :value="profile.passWord" />
        </template>
      </van-cell>
      <van-cell title="* 确认密码">
        <template >
          <input class="input-css" type="password" :value="profile.repassWord"/>
        </template>
      </van-cell>
    </van-cell-group>


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

  export default {
    name: "Profile",
    data() {
      return {
        // profile: profile,
        sexRadio: 'male',
        statusRadio: 'student',
        checked: false,
        cannt_click: true,
        profile: {
          Name: '池升恒',
          school: 'xx大学',
          phone: '15963248122',
          department: '计算机学院',
          status: '学生',
          studentId: '8546785',
          experience: 20,
          passWord: '123',
          repassWord: '123',
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
      register() {
        if (this.statusRadio == 'student')
          this.profile.status = '学生'
        else
          this.profile.status = '老师'
        // 注册
        register(this.profile).then(res=> {
          console.log(res);
          if (res.data) {

            this.$toast('注册成果')
            this.$router.replace('\login')
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