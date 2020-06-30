<template>
  <div>
    <md-nav-bar title="签到" />
    <pwd ref="pwd" :isShow="true" @success="successClick" />
  </div>
</template>

<script>
  import {member} from "mock/banke/oneclass/data.js"
  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "components/pwd/Pwd";
  import {studentSignNow, studentSignPose} from "../../../../network/banke/member";


  export default {
    name: "SignIn",
    data() {
      return {
        signType: 1,
      }
    },
    computed: {

    },
    created() {

    },
    components: {
      Pwd,
      MdNavBar
    },
    methods: {
      successClick() {
        let self = this
        //这边不支持浏览器，而支持真机获得经纬度 定位！
        plus.geolocation.getCurrentPosition((p) => {

          let poseresult = ""
          for (let item of self.$refs.pwd.lastPoint) {
            console.log(item);
            poseresult = poseresult + item.index + "-"
          }
          poseresult = poseresult.substring(0, poseresult.length-1)
          const params = {
            classId: self.$route.params.classId,
            signId: self.$store.getters.getStudentSignId,
            longitude:p.coords.longitude,
            latitude:p.coords.latitude,
            username: window.localStorage['userName'],
            poseNumber: poseresult
          }
          console.log(params);
          studentSignPose(params).then(data => {
            console.log(data);
            if (data.state=='ok') {
              self.$store.commit('setTeacherLongitude', data.longitude)
              self.$store.commit('setTeacherLatitude', data.latitude)
              self.$toast('签到成功')
              self.$router.push({
                path:'/banke/'+self.$route.params.classId+'/member/sign-in/success',
                query: {long:params.longitude, lat:params.latitude}}
              )
            }else {
              this.$toast('手势错误')
            }
          }).catch(err => {
            console.log(err);
          })

        }, function(e){
          alert('Geolocation error: ' + e.message);
        });

      },
      itemClick(index) {
        if (index == 1) {
          this.showPwd = true
        }
      }
    }
  }
</script>

<style scoped>

  .card {
    position: relative;
    z-index: 9;
    background-color: white;
    height: 88px;
    margin: 0 auto;
    padding: 10px 12px;
  }
  .cardItem {
    line-height: 1.3;
  }
  .swipe-height {
    height: 100%;
  }

</style>