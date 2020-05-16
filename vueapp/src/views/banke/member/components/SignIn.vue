<template>
  <div>
    <md-nav-bar title="签到" />



    <pwd :isShow="true" @success="successClick" />

  </div>
</template>

<script>
  import {member} from "mock/banke/oneclass/data.js"
  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "components/pwd/Pwd";


  export default {
    name: "SignIn",
    data() {
      return {
        signType: 1
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
        console.log('test11');
        this.$router.push('/banke/'+this.$route.params.classId+'/member/sign-in/success')
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