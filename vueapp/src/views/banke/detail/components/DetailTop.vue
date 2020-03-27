<template>
  <div class="content border-radius detail-top shadow">
    <van-row>
      <van-col span="6">
        <van-image :src="require('assets/image/banke/detail/class-icon.png')" width="70px" height="70px"  class="right"/>
      </van-col>
      <van-col span="18" class="message-css">
        <div class="message-css">
          <span>2019工程实践</span><br>
          <span class="text-normal">工程实践</span><br>
          <span class="text-small">池ch</span><br>
          <span class="text-small">2019-2020-2 学校课表班课</span><br>
        </div>
      </van-col>
    </van-row>


  </div>
</template>

<script>
  export default {
    name: "DetailTop"
  }
</script>

<style scoped>
  .detail-top {
    height: 95px;
    width: 94%;
    margin: 0 auto;
  }
  .message-css {
    padding-left: 5px;
    height: 75px;
  }
  .image-css {
    margin-top: 4px;
  }



</style>