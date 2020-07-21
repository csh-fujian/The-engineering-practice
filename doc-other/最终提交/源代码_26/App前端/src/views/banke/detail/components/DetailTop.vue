<template>
  <div class="content border-radius detail-top shadow">
    <van-row>
      <van-col span="6">
        <van-image :src="require('assets/image/mine/yunbanke.png')" width="70px" height="70px"  class="right"/>
      </van-col>
      <van-col span="18" class="message-css">
        <div class="message-css">
          <div class="margin-top-small" />
          <span class="text-big bold ">{{data.className}}</span><br>
          <span class="text-normal ">{{data.teacher}}</span><br>
          <span class="text-normal font-gray">{{data.time}}</span><br>

          <div class="icon-css"
               v-if="$store.getters.getIsTeacher"
               @click="editClick">
            <van-icon name="edit" color="var(--theme-color)" size="20" />
          </div>
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
    },
    methods: {
      editClick() {
        let classId = this.$route.params.classId
        this.$router.push('/banke/'+classId+'/detail/edit')
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
  .icon-css {
    position: absolute;
    top: 5px;
    right: 5px;
  }



</style>