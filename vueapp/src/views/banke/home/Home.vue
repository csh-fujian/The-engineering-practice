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

    <teacher-class v-if="this.$store.getters.getIsTeacher" :data="home.teacherClassList" @classItemClick="ClassItemClick"  />
    <student-class v-else :data="home.studentClassList"  @classItemClick="ClassItemClick"/>

    <md-tab-bar activeValue="banke" />
  </div>
</template>

<script>
import StudentClass from "./components/StudentClass";
import TeacherClass from "./components/TeacherClass";
import MdTabBar from "components/tabbar/MdTabBar";
import {home} from 'mock/banke/home.js'

import QrcodeDecoder from 'qrcode-decoder';
import {getBankeData} from "../../../network/banke/home";

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
    // console.log('create -- home 生命周期调用')
    //
    // // 获取用户身份
    // this.initStatus()
    //
    // //获取首页数据
    // this.getHomeData()

  },

  activated() {
    console.log('页面 activated')
    this.initStatus()
    this.getHomeData()
  },
  deactivated() {

  },
  components: {
    StudentClass,
    TeacherClass,
    MdTabBar
  },
  methods: {
    // 获取首页数据
    getHomeData() {
      const params = {
        username: window.localStorage["userName"],
        flag: this.$store.getters.getIsTeacher ? 2 : 1,
      }


      console.log(this.$store.getters.getIsTeacher ? 2 : 1);
      console.log(params);
      getBankeData(params).then(data=> {
        console.log(data);
        if (this.$store.getters.getIsTeacher) {
          this.home.teacherClassList = data
          console.log(this.home.teacherClassList);
        }else {
          this.home.studentClassList = data
        }
      }).catch(err => {
        console.log(err);
      })
    },
    // 判定用户身份
    initStatus() {
      if (window.localStorage["role"] == 'teacher') {
        this.$store.commit('setIsTeacher', true)
        this.initTeacher()
      }else {
        this.$store.commit('setIsTeacher', false)
        this.initStudent()
      }
    },

    // 网络请求
    initTeacher() {
      this.actions = [{name: '创建班课'}]
    },
    initStudent() {
      this.actions = [
        { name: '班课号加入班课' },
        { name: '二维码加入班课' },
      ]
    },
    // 进入详细班课
    ClassItemClick(classId) {
      this.$store.commit('setCurrentClassId', classId)
      this.$router.push('/banke/'+classId+'/oneclass')
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
              // alert(res.data);
              console.log(res.data);
              _this.$router.push(res.data)
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
