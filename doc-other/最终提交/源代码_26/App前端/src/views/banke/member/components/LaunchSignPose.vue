<template>
  <div>
    <md-nav-bar title="发布签到" />
    <pwd ref="pwd" :is-show="showPwd" :teacherOption="true">
      <van-row>
        <van-col span="12"><div  class="text-center border-radius bold text-color"  @click="resetPassword()">重置密码</div></van-col>
        <van-col span="12"><div class="text-center border-radius bold text-color" @click="startPwd()">开始</div></van-col>
      </van-row>
    </pwd>

    <van-dialog v-model="showPoseSignIn"
                title="正在签到"
                confirm-button-text="结束签到"
                show-cancel-button
                @confirm="signPoseEnd">
      <div class="text-center content margin-topdown-normal">
        <van-loading type="spinner" size="100px" />
      </div>
    </van-dialog>
  </div>
</template>

<script>

  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "components/pwd/Pwd";
  import {
    signNowEnd,
    signNowStart,
    signPoseEnd,
    signPoseStart,
    studentSignPose
  } from "../../../../network/banke/member";


  export default {
    name: "LaunchSignPose",
    data() {
      return {
        showPwd: true,
        signId:0,
        showPoseSignIn:false
      }
    },
    created() {

    },
    components: {
      Pwd,
      MdNavBar
    },
    methods: {
      //结束签到
      signPoseEnd() {
        console.log('结束签到')
        const params = {
          signId: this.signId
        }
        signPoseEnd(params).then(data=> {
          if (data == 'ok') {
            this.$router.back()
          }
        }).catch(err => {
          console.log(err);
        })
      },

      // 发布签到
      startPwd() {
        console.log(this.$refs.pwd.lastPoint);
        let poseresult = ""
        for (let item of this.$refs.pwd.lastPoint) {
          poseresult = poseresult + item.index + "-"
        }
        poseresult = poseresult.substring(0, poseresult.length-1)
        console.log(poseresult);
        // alert(poseresult)

        plus.geolocation.getCurrentPosition((p) => {

          console.log('poseresult:' + poseresult);
          console.log('p.coords.longitude:' + p.coords.longitude);
          console.log('p.coords.latitude:' + p.coords.latitude);

          const params = {
            posenumber:poseresult,
            username: window.localStorage['userName'],
            classId: this.$route.params.classId,
            longitude: p.coords.longitude,
            latitude:p.coords.latitude
          }
          console.log('params.longitude:' + params.longitude);
          signPoseStart(params).then(data => {
            console.log('data'+data);
            this.signId = data
            this.showPoseSignIn = true
          }).catch(err => {
            console.log(err);
          })

        }, function(e){
          alert('Geolocation error: ' + e.message);
        });

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