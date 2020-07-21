<template>
  <div>
    <van-nav-bar title="提交任务"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft"
                 @click-right="onClickRight">
      <template #right>
        提交
      </template>
    </van-nav-bar>

    <div class="content">
      <van-cell-group class="margin-topdown-small">
        <van-cell title="任务标题" :value="workData.title"  />
        <van-cell title="任务分值" :value="workData.scoreMax"  />
        <van-cell title="任务状态" :value="workData.timeState"  />
        <van-cell title="任务描述" :label="workData.description" />
      </van-cell-group>

      <van-cell-group class="margin-topdown-normal">
        <van-cell title="提交内容" />
        <textarea class="textarea-css" v-model="message" placeholder="任务内容"></textarea>
      </van-cell-group>


    </div>


  </div>
</template>

<script>
  import {upLoadWork} from "../../../../network/banke/activity";

  export default {
    name: "WorkUpLoad",
    data() {
      return {
        workData: null,
        message: ''
      }
    },
    components: {

    },
    activated() {
      this.workData = this.$store.getters.getTeskData
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      },
      // 提交
      onClickRight() {
        console.log('提交任务');
        const  params ={
          workId: this.$route.params.workId,
          username: window.localStorage['userName'],
          workcontent: this.message
        }

        console.log(params);
        upLoadWork(params).then(data => {
          console.log(data);
          if (data.msg == 'ok') {
            this.$toast(data.data)
          }else {
            this.$toast(data.data)
          }
        }).catch(err => {
          console.log(err);
        })
      },
    }
  }
</script>

<style scoped>
.textarea-css {
  width: 100%;
  height: 150px;
}
</style>