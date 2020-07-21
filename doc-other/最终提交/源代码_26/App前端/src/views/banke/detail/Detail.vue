<template>
  <div>
    <div class="background" />
    <van-nav-bar title="工程实践"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <detail-top class="top-css" :data="dataTop" />
    <deatil-content :data="dataContent"/>
    <detail-bottom  @endClass="teaherEndClass" @exitClass="studentExitClass"/>
    <md-banke-tab-bar activeValue="detail"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import DetailTop from "./components/DetailTop";
  import DeatilContent from "./components/DeatilContent";
  import DetailBottom from "./components/DetailBottom";

  import {detail} from "mock/banke/oneclass/data";
  import {getOneClass, getTeacherOneClass} from "../../../network/banke/activity";
  import {endClass, exitClass, getTeacherOneClassDetail} from "../../../network/banke/detail";

  export default {
    name: "Detail",
    data() {
      return {
        data: detail,
        dataTop: {},
        dataContent: {},
        isTeacher: false,
      }
    },
    created() {
      //网络获取首页数据
      // this.getOneClassData()
      // this.dataTop = this.data.dataTop
      // this.dataContent = this.data.dataContent
    },
    activated() {
      console.log('activate');
      this.isTeacher = this.$store.getters.getIsTeacher
      console.log(this.isTeacher);
      if (this.isTeacher) {
        this.getTeacherOneClassData()
      } else {
        this.getOneClassData()
      }

    },
    components: {
      MdBankeTabBar,
      DetailTop,
      DeatilContent,
      DetailBottom,
    },
    methods: {
      //学生退出班课
      studentExitClass() {
        const params= {
          username: window.localStorage['userName'],
          classId: this.$route.params.classId,
        }
        exitClass(params).then(data => {
          if(data == 'ok') {
            this.$toast('退出班课成功')
            this.$router.push('/banke')
          }
        }).catch(err => {
          console.log(err);
        })
      },

      //结束 删除班课
      teaherEndClass(state) {
        console.log(state);
        const params = {
          username: window.localStorage['userName'],
          classId: this.$route.params.classId,
          state: state
        }
        console.log(params);
        endClass(params).then(data => {
          if(data == 'ok') {
            this.$toast(state+ ' 班课成功')
            this.$router.replace('/banke')
          }
        }).catch(err => {
          console.log(err);
        })
      },

      //获得页面数据
      getOneClassData() {
        // 请求首页数据

        const params = {
          classId:this.$route.params.classId,
          username: window.localStorage.userName
        }
        console.log(params)
        getOneClass(params).then(data => {
          console.log(data);
          this.data = data.detail
          this.dataTop = data.detail.dataTop
          this.dataContent = data.detail.dataContent
        }).catch(err => {
          console.log(err);
        })
      },

      //老师页面获取数据
      getTeacherOneClassData() {
        const params = {
          classId:this.$route.params.classId,
          username: window.localStorage.userName
        }
        console.log(params);
        getTeacherOneClassDetail(params).then(data => {
          console.log(data);

          const dataTop={
            description: data.data.description,
            className: data.data.className,
            teacher: data.data.teacher,
            time: data.data.semester,
          }
          this.dataTop = dataTop
          this.dataContent = data.dataContent
        }).catch(err => {
          console.log(err);
        })
      },
      onClickLeft()
      {
        this.$router.replace('/banke')
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
    height: 140px;
  }
  .top-css {
    position: relative;
    z-index: 9;
    background-color: white;
    margin-top: 50px;
  }

</style>