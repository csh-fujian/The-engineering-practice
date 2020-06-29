<template>
  <div>
    <van-sticky>
      <van-nav-bar title="创建班课"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>
    <div class="content">
      <teacher-class-info :myClass="myClass"/>
      <div class="margin-top-normal">
        <van-button plain hairline type="primary" block @click="createClick">创建</van-button>
      </div>
    </div>
  </div>
</template>

<script>
  import TeacherClassInfo from "components/teacher-class-info/TeacherClassInfo";
  import {createClass} from "../../../../network/banke/home";
  export default {
    name: "TeacherCreateClass",
    data() {
      return {
        myClass:{
          className: '',
          courseName: '',
          schoolName: '',
          departmentName: '',
          semester: '2020-2021-2',
          studyDemand: '',
          examDemand: ''
        }
      }
    },
    components:
    {
      TeacherClassInfo
    },
    methods: {
      createClick() {
        console.log(this.myClass);
        const {className, courseName, schoolName, departmentName, semester, studyDemand,examDemand} = this.myClass
        const username = window.localStorage['userName']
        console.log(username);
        const params = {
          className,
          courseName,
          schoolName,
          departmentName,
          semester,
          studyDemand,
          examDemand,
          username
        }

        createClass(params).then(data => {
          console.log(data);
          if (data>0) {
            this.$toast('班课创建成果')
            this.$router.replace('/banke')
          }
        }).catch(err => {
          console.log(err);
        })
      },
      onClickLeft() {
        this.$router.back()
      },
    }
  }
</script>

<style scoped>

</style>