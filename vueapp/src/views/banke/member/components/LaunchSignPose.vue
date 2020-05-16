<template>
  <div>
    <md-nav-bar title="发布签到" />
    <pwd ref="pwd" :is-show="showPwd" :teacherOption="true">
      <van-row>
        <van-col span="12"><div  class="text-center border-radius bold text-color"  @click="resetPassword()">重置密码</div></van-col>
        <van-col span="12"><div class="text-center border-radius bold text-color" @click="startPwd()">开始</div></van-col>
      </van-row>


    </pwd>
  </div>
</template>

<script>

  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "components/pwd/Pwd";


  export default {
    name: "LaunchSignPose",
    data() {
      return {
        showPwd: true
      }
    },
    created() {

    },
    components: {
      Pwd,
      MdNavBar
    },
    methods: {
      startPwd() {
        console.log(this.$refs.pwd.lastPoint);
      },
      resetPassword() {
        this.$refs.pwd.reset()
      },
    }
  }
</script>

<style scoped>
.text-color {
  color: white;
}


</style>