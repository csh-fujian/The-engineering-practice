<template>
  <div>
    <md-nav-bar title="签到信息" :backto="-2" />

    <!--    :plugin="plugin"-->
    <div class="amap-page-container">
      <el-amap vid="amap"
               class="amap-demo"
               :zoom="zoom"
               :center="center"
      >
        <el-amap-marker v-for="marker in markers" :position="marker.position" :key="marker.id"></el-amap-marker>
      </el-amap>

      <div class="toolbar">
        <span v-if="loaded">
          location: lng = {{ lng }} lat = {{ lat }}
        </span>
      </div>

      <van-button plain hairline type="primary" block @click="exit">退出签到</van-button>
    </div>

  </div>
</template>

<script>
  import MdNavBar from "components/nav-bar/MdNavBar";

  export default {
    name: "SignInSuccess",
    data() {
      return {
        center: [121.59996, 31.197646],
        zoom: 14,
        lng: 0,
        lat: 0,
        markers: [
          {
            position: [119.655705,26.956929], //从store中拿到老师的坐标
          },
          {
            position: [119.656705,26.956929],
          },
        ],
        loaded: false,
        // plugin: [{
        //   pName: 'Geolocation',
        //   events: {
        //     init(o) {
        //   plus.geolocation.getCurrentPosition((p) => {
        //         // alert('Geolocation\nLatitude:' + p.coords.latitude + '\nLongitude:' + p.coords.longitude + '\nAltitude:' + p.coords.altitude);
        //         self.lng = parseFloat(p.coords.longitude);
        //         self.lat = parseFloat(p.coords.latitude);
        //         self.center = [self.lng, self.lat];
        //         self.loaded = true;
        //         self.$nextTick();
        //         // alert (this.center[0]+'  '+ this.center[1])
        //       }, function(e){
        //         alert('Geolocation error: ' + e.message);
        //       } );
        //
        //     }
        //   }
        // }],
        EARTH_RADIUS: 6378.137
      }
    },
    // props: {
    //   center: {
    //     type: Array,
    //     default() {
    //       return [121.59996, 31.197646]
    //     }
    //   }
    // },
    created() {
      let lat = parseFloat(this.$route.query.lat)
      let long = parseFloat(this.$route.query.long)
      console.log(lat);
      console.log(long);
      this.center[0] = long
      this.center[1] = lat
    },
    components: {
      MdNavBar
    },

    methods: {
      exit() {
        this.$router.go(-2)
      },
      GetDistance( lat1,  lng1,  lat2,  lng2){
        var radLat1 = lat1*Math.PI / 180.0;
        var radLat2 = lat2*Math.PI / 180.0;
        var a = radLat1 - radLat2;
        var  b = lng1*Math.PI / 180.0 - lng2*Math.PI / 180.0;
        var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
            Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s *6378.137 ;// EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
      }
    }
  }
</script>

<style scoped>
  .amap-demo {
    height: 300px;
  }

</style>