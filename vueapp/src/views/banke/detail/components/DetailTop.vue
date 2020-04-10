<template>
  <div class="content border-radius detail-top shadow">
    <van-row>
      <van-col span="6">
        <van-image :src="require('assets/image/banke/detail/class-icon.png')" width="70px" height="70px"  class="right"/>
      </van-col>
      <van-col span="18" class="message-css">
        <div class="message-css">
          <span>{{data.description}}</span><br>
          <span class="text-normal">{{data.className}}</span><br>
          <span class="text-small">{{data.teacher}}</span><br>
          <span class="text-small font-gray">{{data.time}}</span><br>
        </div>
      </van-col>
    </van-row>


  </div>
</template>

<script>
  export default {
    name: "DetailTop",
    props: {
      data: {
        type: Object,
      }
    }
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