<template>
  <div>
    <div class="content-css" >
      <div v-if="isTeacher">
        <div class="margin-top-normal">
          <van-button plain hairline type="primary" block @click="endshow=true">结束班课</van-button>
        </div>
        <div class="margin-top-small">
          <van-button plain hairline type="primary" block @click="deleteshow=true">删除班课</van-button>
        </div>
      </div>
      <div v-else>
        <van-button plain hairline type="primary" block @click="eixtshow=true">退出班课</van-button>
      </div>
    </div>

    <van-dialog
            v-model="endshow"
            title="结束班课"
            message="是否要结束班课"
            show-cancel-button
            @confirm="endClass"
    />
    <van-dialog
            v-model="deleteshow"
            title="删除班课"
            message="是否要删除班课"
            show-cancel-button
            @confirm="deleteClass"
    />
    <van-dialog
            v-model="eixtshow"
            title="退出班课"
            message="是否要退出班课"
            show-cancel-button
            @confirm="eixtClass"
    />
  </div>

</template>

<script>
  export default {
    name: "DetailBottom",
    data() {
      return {
        isTeacher: false,
        endshow:false,
        deleteshow:false,
        eixtshow:false
      }
    },
    created() {
      this.isTeacher = window.localStorage['role'] === 'teacher'
    },
    activated() {
      this.isTeacher = window.localStorage['role'] === 'teacher'
    },
    methods: {
      //结束班课
      endClass() {
        this.$emit('endClass', 'over')
      },
      //删除班课
      deleteClass() {
        this.$emit('endClass', 'delete')
      },
      //退出班课
      eixtClass() {
        this.$emit('exitClass')
      }
    }
  }
</script>

<style scoped>
  .content-css {
    padding: 0 4%;
    margin-bottom: 50px;
  }
</style>