<template>
  <div>

    <van-tabbar v-model="active" @change="onChange">
      <van-tabbar-item name="resource" icon="debit-pay">资源</van-tabbar-item>
      <van-tabbar-item name='member' icon="user-o" dot>成员</van-tabbar-item>

      <van-tabbar-item name="activity" icon="flag-o" v-if="!isActivity && isTeacher">活动</van-tabbar-item>
      <van-tabbar-item name="activity"
                       icon="plus"
                       v-if="isActivity && isTeacher"
                       class="activity-css"
                       @click="activityClick"
      >{{teacherActivity}}</van-tabbar-item>
      <van-tabbar-item name="activity" icon="flag-o" badge="5" v-if="!isTeacher">活动</van-tabbar-item>
      <van-tabbar-item name="message" icon="chat-o" badge="99+">消息</van-tabbar-item>
      <van-tabbar-item name="detail" icon="label-o" badge="5">详情</van-tabbar-item>
    </van-tabbar>

    <van-overlay :show="showOverlay" class="overlay" @click="showOverlay = !showOverlay">
      <div class="overlay-line" @click.stop>
        <div class="overlay-item text-center" @click="workClick">
          <van-image :src="imageUrl" width="46px" height="46px" />
          <p class="font-css">作业任务</p>
        </div>
        <div class="overlay-item text-center">
          <van-image :src="imageUrl" width="46px" height="46px" />
          <p class="font-css">测试</p>
        </div>
        <div class="overlay-item text-center">
          <van-image :src="imageUrl" width="46px" height="46px" />
          <p class="font-css">活动库</p>
        </div>
        <div class="overlay-item text-center">
          <van-image :src="imageUrl" width="46px" height="46px" />
          <p class="font-css">头脑风暴</p>
        </div>
      </div>
    </van-overlay>
  </div>
</template>

<script>
  export default {
    name: "MdTabBar",
    data() {
      return {
        active: 'activity',
        isTeacher: false,
        isActivity: false,
        teacherActivity: '添加',
        showOverlay: false,
        imageUrl: require('assets/image/banke/home/class.png')
      }
    },
    props: {
      activeValue: {
        type: String,
        default: ''
      }
    },
    created() {
      this.isTeacher = this.$store.getters.getStatus === 'teacher'
    },
    activated() {
      this.active = this.activeValue
      if(this.activeValue === 'activity') {
        this.isActivity = true
      }else
      {
        this.isActivity = false
      }
    },
    methods: {
      workClick() {
        this.$router.push(this.$route.path + '/createWork')
      },
      activityClick() {
        this.showOverlay = !this.showOverlay
        if (this.showOverlay) {
          this.teacherActivity = '取消'
        } else
        {
          this.teacherActivity = '添加'
        }
      },
      onChange(name) {
        const classId = this.$store.getters.getCurrentClassId
        switch(name) {
          case'detail':
            this.$router.replace('/banke/'+classId+'/detail')
            break
          case 'message':
            this.$router.replace('/banke/'+classId+'/message')
            break
          case 'activity':
            this.$router.replace('/banke/'+classId+'/oneclass')
            break
          case'member':
            this.$router.replace('/banke/'+classId+'/member')
            break
          case 'resource':
            this.$router.replace('/banke/'+classId+'/resource')
            break
        }
      }
    }
  }
</script>

<style scoped>
.font-css {
  font-size: 6px;
  color: white;
}
.activity-css {
  color: white;
  background-color: var(--theme-color-low);
}

.overlay {
  position: absolute;
  top: 46px;
  height: calc(100% - 96px);
  left: 0;
  right: 0;
}
.overlay-line {
  width: 100%;
  position: absolute;
  bottom: 8px;
  display: flex;
}
.overlay-item {
  padding: 2%;
  height: 80px;
  flex: 1;
}
</style>