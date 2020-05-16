<template>
  <div>
    <md-nav-bar title="签到信息" :backto="-2" />

    <div class="amap-wrapper">
      <el-amap
              vid="amapDemo"
              :center="center"
              :zoom="zoom"
              class="amap-wrapper"
              :events="events">
      </el-amap>
      <div class="toolbar">
        position: [{{ lng }}, {{ lat }}] address: {{ address }}
      </div>
    </div>

  </div>
</template>

<script>
  import MdNavBar from "components/nav-bar/MdNavBar";

  export default {
    name: "SignInSuccess",
    data() {
      let self = this;
      return {
        zoom: 12,
        center: [121.59996, 31.197646],
        address: '',
        events: {
          click(e) {
            let { lng, lat } = e.lnglat;
            self.lng = lng;
            self.lat = lat;

            // // 这里通过高德 SDK 完成。
            // var geocoder = new AMap.Geocoder({
            //   radius: 1000,
            //   extensions: "all"
            // });
            // geocoder.getAddress([lng ,lat], function(status, result) {
            //   if (status === 'complete' && result.info === 'OK') {
            //     if (result && result.regeocode) {
            //       self.address = result.regeocode.formattedAddress;
            //       self.$nextTick();
            //     }
            //   }
            // });
          }
        },
        lng: 0,
        lat: 0
      };
    },
    components: {
      MdNavBar
    }
  }
</script>

<style scoped>
  .amap-wrapper {
    width: 100%;
    height: 50vh;
  }

</style>