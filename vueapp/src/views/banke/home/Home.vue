<template>
  <div class="home">

    <van-action-sheet v-model="plusShow"
                      :actions="actions"
                      @select="onSelect"
                      cancel-text="取消"
                      @cancel="onCancel" />

    <van-nav-bar title="我加入的">
      <template #right>
        <van-icon name="plus" @click.native="plusItemClick"/>
      </template>
    </van-nav-bar>


    <van-search
            v-model="value"
            show-action
            placeholder="请输入搜索关键词"
            label="搜索"
    >
      <template #action>
        <div @click="onSort">调序</div>
      </template>
    </van-search>



    <teacher-class v-if="isTeacher" :data="home.teacherClassList"  />
    <student-class v-else :data="home.studentClassList"  />



    <md-tab-bar activeValue="banke" />
  </div>
</template>

<script>
import StudentClass from "./components/StudentClass";
import TeacherClass from "./components/TeacherClass";
import MdTabBar from "components/tabbar/MdTabBar";
import {home} from 'mock/banke/home.js'

import QrcodeDecoder from 'qrcode-decoder';

export default {
  name: 'Home',
  data() {
    return {
      home: home,
      value: '',
      plusShow: false,
      actions: [
        { name: '班课号加入班课' },
        { name: '二维码加入班课' },
      ],
      videoImageData:[],
      isTeacher: true
    }
  },
  created() {
    // 初始化根据用户不同身份显示不同内容
    this.isTeacher = this.$store.getters.getStatus === 'teacher'
    if (this.isTeacher) {
      this.initTeacher()
    }
  },
  components: {
    StudentClass,
    TeacherClass,
    MdTabBar
  },
  methods: {
    initTeacher() {
      this.actions = [{name: '创建班课'}]
    },
    // 添加班课按钮事件 ----
    onCancel() {
      this.plusShow = false;
    },
    plusItemClick() {
      console.log("plusItemClick");
      this.plusShow = true
    },
    onSelect(item) {
      // 默认情况下点击选项时不会自动收起
      // 可以通过 close-on-click-action 属性开启自动收起
      console.log(item.name);
      if (item.name === '班课号加入班课') {
        this.$router.push('/banke/add-class')
      }
      if (item.name === '创建班课') {
        this.$router.push('/banke/create')
      }
      if (item.name === '二维码加入班课') {
        this.galleryImg()
      }
      this.plusShow = false;
    },
    //从相册选择照片
    galleryImg(){
      var _this = this;
      plus.gallery.pick(
          (path) => {
            console.log('test',path);
            let qr = new QrcodeDecoder();
            qr.decodeFromImage(path).then((res) => {
              //打印结果为 解析出来的 二维码地址
              alert(res.data);
              //不是二维码： undefine
              // 不是我们定义的二维码
              // alert('失败文案');
            })
          },
          ( e ) => {
            console.log( "取消选择图片" );
          },
          {filter:"image"});
    },
    onSearch() {
      console.log('search');
    },
    onSort() {
      console.log('调序');
    }
  }
}
</script>
