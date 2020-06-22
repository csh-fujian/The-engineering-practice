<template>
  <div>
    <md-nav-bar title="加入班课" />

    <div class="content">

      <div class="content text-center margin-top-normal">
        <van-image :src="require('assets/image/mine/yunbanke.png')" width="75" height="70" />
        <h3>工程实践</h3>

        <div class="border-radius shadow margin-top-normal content text-left">
          <van-cell title="老师" :value="teacher" />
          <van-cell title="班课号" :value="classId"/>
          <van-cell title="学校" :value="school"/>
          <van-cell title="学院" :value="department"/>
        </div>

        <div class="margin-top-normal">
          <van-button plain hairline type="primary" block @click="participate">加入</van-button>
        </div>

      </div>

    </div>
  </div>
</template>

<script>
  import MdNavBar from "components/MdNavBar";
  import {joinClass, joinClassIn} from "../../../../network/banke/home";
  export default {
    name: "AddClassDetail",
    data() {
      return {
        classId: '',
        school: 'xx',
        department: 'xx',
        teacher: 'xxx',
      }
    },
    created() {
      this.classId = this.$route.params.classId
      // 加入班课
      joinClass(this.classId).then(data=>{
        this.school = data.school
        this.department = data.department
        this.teacher = data.teacher
        console.log(data);
      }).catch(err=>{
        console.log(err);
      })
    },
    components: {
      [MdNavBar.name]: MdNavBar
    },
    methods: {
      participate() {
        joinClassIn(this.classId).then(data=>{
          console.log('加入成功');
          this.$router.replace('/banke')
        }).catch(err=>{

        })
        this.$router.replace('/banke')
      }
    }
  }
</script>

<style scoped>

</style>