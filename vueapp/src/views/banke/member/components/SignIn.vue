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
        //这边不支持浏览器，而支持真机获得经纬度 定位！
        plus.geolocation.getCurrentPosition((p) => {
                      this.$router.push({
                        path:'/banke/'+this.$route.params.classId+'/member/sign-in/success',
                        query: {long:p.coords.longitude, lat:p.coords.latitude}}
                      )
                    }, function(e){
                      alert('Geolocation error: ' + e.message);
                    }
        );
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