<template>
  <div>
    <div class="background" />
    <van-sticky>
      <van-nav-bar title="工程实践"
                   left-arrow
                   left-text=""
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <div v-if="isTeacher" class="margin-top-large text-center text-white">
      <span class="text-normal">学生详情</span><br>
    </div>
    <div v-else class="margin-top-normal text-center text-white">
<!--      <span class="text-max">第 {{member.rank}} 名</span><br>-->
      <span class="text-max">第 {{member.rank}} 名</span><br>
      <span class="text-small">当前获得{{member.experience}}经验值</span>
    </div>

    <div class="border-radius shadow card flex">
      <div class="flex1 text-center flexItem cardItem" v-for="(item,index) in option" @click="itemClick(index)">
        <van-image
                round
                width="46px"
                height="46px"
                fit="fill"
                :src="item.imageUrl"
        /><br>
        <span class="text-small">{{item.title}}</span>
      </div>
    </div>

    <div>
      <van-field

              v-model="searchData"
              center
              clearable
              placeholder="输入全局查询信息"
              :border="true"
      >
        <template #button>
          <van-icon name="search" style="line-height: inherit;" />
        </template>
      </van-field>

    </div>


    <van-sticky :offset-top="36">
      <div class="content border-bottom container-title" :class="{'margin-top-small': !isTeacher}">
        <span class="text-small left">成员总数：{{member.number}} 人</span>
        <span class="text-small font-gray right " @click="sortTypeClick">{{sortType}}</span>
      </div>
    </van-sticky>

 
      <van-cell-group>
        <member-item  v-for="item in member.members" :memberItem="item" />
      </van-cell-group>





    <van-dialog v-model="showNowSignIn"
                title="正在签到"
                confirm-button-text="确认签到"
                show-cancel-button
                @confirm="studentSignNow">
      <div class="text-center content margin-topdown-normal">
        <van-loading type="spinner" size="100px" />
      </div>
    </van-dialog>

    <md-banke-tab-bar activeValue="member"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import MemberList from "./components/MemberList";
  import MemberItem from "./components/MemberItem";

  import {member} from "mock/banke/oneclass/data.js"
  import {getOneClass} from "../../../network/banke/activity";
  import {studentSignIn, studentSignNow} from "../../../network/banke/member";

  export default {
    name: "Member",
    data() {
      return {
        member: member,
        member_option:member,
        isTeacher: false,
        searchData: '',
        sortType: '切换为学号排序',
        sigin_type: "",
        signId:0,
        showNowSignIn:false,
        tempmembers: null,
      }
    },
    computed: {
      option() {
        if (window.localStorage['role'] === 'student')
        {
          return  this.member_option.option_student

        }else {
          return this.member_option.option
        }
        console.log(this.member_option.option_student);
      }
    },
    watch: {
      'searchData':function () {
        console.log(this.tempmembers);
        let result=[]
        this.tempmembers.forEach(item => {
          if(JSON.stringify(item).indexOf(this.searchData)!=-1) {
            result.push(item)
          }
          this.member.members = result
        })

      }
    },
    created() {
      //获取页面数据
      this.getOneClassData()
      // 身份判断
      this.isTeacher = window.localStorage['role'] === 'teacher'
      console.log(this.member);
    },
    activated() {
      this.isTeacher = window.localStorage['role'] === 'teacher'
      this.getOneClassData()
    },

    components: {
      MdBankeTabBar,
      MemberList,
      MemberItem
    },
    methods: {
      //获得页面数据
      getOneClassData() {
        // 请求首页数据
        console.log(this.$route.params.classId)
        const params = {
          classId:this.$route.params.classId,
          username: window.localStorage.userName
        }
        getOneClass(params).then(data => {
          console.log(data);
          this.member = data.member
          this.tempmembers = JSON.parse(JSON.stringify(data.member.members))
        }).catch(err => {
          console.log(err);
        })
      },

      itemClick(index) {
        if (index == 0) {
          if (!this.isTeacher) {
            this.canParticipate()
            // if(this.canParticipate()) {
            //   this.$router.push('/banke/'+this.$route.params.classId+'/member/sign-in')
            // }else {
            //
            // }
          }
          else
            this.$router.push('/banke/'+this.$route.params.classId+'/member/launch-sign')
        }else {
          this.$toast('抱歉，尚未开发')
        }
      },
      sortTypeClick() {
        if (this.sortType == '切换为学号排序')
          this.sortType = '切换为经验值排序'
        else
          this.sortType = '切换为学号排序'
        this.$toast('该功能未开发')
      },
      onClickLeft()
      {
        this.$router.replace('/banke')
      },
      canParticipate() {
        const params = {
          classId:this.$route.params.classId
        }
        studentSignIn(params).then(data=> {
          console.log(data)
          if(data.code == 404) {
            this.$toast(data.msg)
          } else {
            this.sigin_type = data.data.sigin_type
            this.signId = data.data.signId

            this.$store.commit('setStudentSignId', data.data.signId)
            this.$store.commit('setStudentSignType', data.data.sigin_type)
            console.log(this.$store.getters.getStudentSignId);
            console.log(this.$store.getters.getStudentSignType)
            // 一键签到
            if (this.sigin_type == 1) {
              this.showNowSignIn = true
            } else {
              this.$router.push('/banke/'+this.$route.params.classId+'/member/sign-in'+ '')
            }
          }
        }).catch(err => {

        })
      },
      //学生一键签到
      studentSignNow() {
        let self = this
        //这边不支持浏览器，而支持真机获得经纬度 定位！
        plus.geolocation.getCurrentPosition((p) => {
              const params = {
                classId: self.$route.params.classId,
                signId: self.$store.getters.getStudentSignId,
                longitude:p.coords.longitude,
                latitude:p.coords.latitude,
                username: window.localStorage['userName']
              }
              console.log('-----------------')
              console.log(params.classId)
              console.log(params.signId)
              console.log(params.longitude)
              console.log(params.latitude)
              console.log(params.username)
              console.log('-----------------')

              studentSignNow(params).then(data => {
                console.log('data'+data);
                if (data.state=='ok') {
                  self.$store.commit('setTeacherLongitude', data.longitude)
                  self.$store.commit('setTeacherLatitude', data.latitude)
                  self.$toast('签到成功')
                  self.$router.push({
                    path:'/banke/'+self.$route.params.classId+'/member/sign-in/success',
                    query: {long:p.coords.longitude, lat:p.coords.latitude}}
                  )
                } else {
                  self.$toast('签到失败'+ data.msg)
                  console.log(data.state);
                }
              }).catch(err => {
                console.log(err);
              })

            }, function(e){
              alert('Geolocation error: ' + e.message);
            }
        );


      }

    }
  }
</script>

<style scoped>
  .background {
    position: absolute;
    z-index:-100;
    background-color: var(--blue);
    width: 100%;
    height: 168px;
  }
  .card {
    position: relative;
    z-index: 9;
    background-color: white;
    height: 88px;
    width: 94%;
    margin: 0 auto;
    margin-top: 10px;
    padding: 10px 12px;
  }
  .cardItem {
    line-height: 1.3;
  }
  .container-title {
    width: 100%;
    background-color: #fff;
    height: 36px;
  }

</style>