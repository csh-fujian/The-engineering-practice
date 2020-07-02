<template>
  <div>
    <md-nav-bar title="签到" />


    <p class="content background-gray text-small">选择签到方式</p>

    <div class="shadow card flex">
      <div class="flex1 text-center flexItem cardItem"
           v-for="(item,index) in member.launchSignInOption"
           @click="itemClick(index)">
        <van-image
                width="46px"
                height="46px"
                fit="fill"
                :src="item.imageUrl"
        /><br>
        <span class="text-small">{{item.title}}</span>
      </div>
    </div>

    <p class="content background-gray text-small">历史签到记录，左滑可删除</p>

    <van-swipe-cell v-for="(item, index) in launchHistory">
      <van-cell size="" :value="item.statistic" >
        <template #title>
          <span class="text-small">{{item.signDate}} {{item.signWeek}} </span>
          <span class="text-small font-gray">{{item.signTime}}</span><br>
          <span class="text-small font-gray">{{item.signType}}</span>
        </template>
      </van-cell>
      <template #right>
        <van-button square type="danger" text="删除" class="swipe-height"/>
      </template>
    </van-swipe-cell>

    <pwd ref="pwd" :is-show="showPwd" :teacherOption="true">
      <a style="position: absolute;left: 5px;top: 5px;color:#fff;font-size: 13px;display:block;" @click="resetPassword()">重置密码</a>
      <a style="position: absolute;right: 5px;top: 5px;color:#fff;font-size: 13px;display:block;" @click="startPwd()">开始</a>
    </pwd>


    <van-dialog v-model="showNowSignIn"
                title="正在签到"
                confirm-button-text="结束签到"
                @confirm="signNowEnd">
      <div class="text-center content margin-topdown-normal">
        <van-loading type="spinner" size="100px" />
      </div>
    </van-dialog>

  </div>
</template>

<script>
  import {member} from "mock/banke/oneclass/data.js"
  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "../../../../components/pwd/Pwd";
  import {getSignLog, signNowEnd, signNowStart} from "../../../../network/banke/member";


  export default {
    name: "LaunchSignIn",
    data() {
      return {
        member: member,
        showPwd: false,
        launchHistory: [],
        showNowSignIn: false,
        signId: 0,
      }
    },
    created() {
      // 获取历史签到记录
      this.getSignInLog(this.$route.params.classId)
    },
    activated() {
      this.getSignInLog(this.$route.params.classId)
    },
    components: {
      Pwd,
      MdNavBar
    },
    methods: {
      //结束签到
      signNowEnd() {
        console.log('结束签到')
        const params = {
          signId: this.signId
        }

        signNowEnd(params).then(data=> {
          if (data == 'ok') {
            console.log('结束一键签到成功');
            this.getSignInLog(this.$route.params.classId)
          }
        }).catch(err => {
          console.log(err);
        })

      },

      //获得签到的历史记录
      getSignInLog(classId) {
        const params = {
          classId: classId
        }
        getSignLog(params).then(data => {
          console.log(data);
          this.launchHistory = data
        }).catch(err => {
          console.log(err);
        })
      },

      startPwd() {
        console.log(this.$refs.pwd.lastPoint);
      },
      resetPassword() {
        this.$refs.pwd.reset()
      },
      itemClick(index) {
        //一键签到
        if (index == 0) {

          plus.geolocation.getCurrentPosition((p) => {
            console.log('p.coords.longitude:' + p.coords.longitude);
            console.log('p.coords.latitude:' + p.coords.latitude);
            // 发布签到
            console.log('发布签到');
            const params = {
              username: window.localStorage['userName'],
              classId: this.$route.params.classId,
              longitude: p.coords.longitude,
              latitude:p.coords.latitude
            }
            console.log(params);
            signNowStart(params).then(data => {
              console.log(data);
              this.signId = data
              this.showNowSignIn = true
            }).catch(err => {
              console.log(err);
            })

          }, function(e){
            alert('Geolocation error: ' + e.message);
          });

        }

        // 手势签到
        if (index == 1) {
          this.$router.push('/banke/'+this.$route.params.classId+'/member/launch-sign/pose')
        }

        if (index == 2) {
          this.$toast('抱歉，未开发')
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