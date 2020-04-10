<template>
  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item name="resource" icon="debit-pay">资源</van-tabbar-item>
    <van-tabbar-item name='member' icon="user-o" dot>成员</van-tabbar-item>
    <van-tabbar-item name="activity" icon="flag-o" badge="5">活动</van-tabbar-item>
    <van-tabbar-item name="message" icon="chat-o" badge="99+">消息</van-tabbar-item>
    <van-tabbar-item name="detail" icon="label-o" badge="5">详情</van-tabbar-item>
  </van-tabbar>
</template>

<script>
  export default {
    name: "MdTabBar",
    data() {
      return {
        active: 'activity'
      }
    },
    props: {
      activeValue: {
        type: String,
        default: ''
      }
    },
    activated() {
      this.active = this.activeValue
    },
    methods: {
      onChange(name) {
        switch(name) {
          case'detail':
            this.$router.replace('/banke/123/detail')
            break
          case 'message':
            this.$router.replace('/banke/123/message')
            break
          case 'activity':
            this.$router.replace('/banke/123/oneclass')
            break
          case'member':
            this.$router.replace('/banke/123/member')
            break
          case 'resource':
            this.$router.replace('/banke/123/resource')
            break
        }
      }
    }
  }
</script>

<style scoped>

</style>