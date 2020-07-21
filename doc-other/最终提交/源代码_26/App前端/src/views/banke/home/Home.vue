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
            placeholder="全局搜索"
            clearable
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
      isTeacher: true,
      tempData: null
    }
  },
  watch: {
    'value':function () {
      let result=[]
      this.tempData.forEach(item => {
        if(JSON.stringify(item).indexOf(this.value)!=-1) {
          result.push(item)
        }
        console.log(result);
      })

      if (this.$store.getters.getIsTeacher) {
        this.home.teacherClassList = result
      } else {
        this.home.studentClassList = result
      }
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
    // this.initStatus()
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
        this.tempData = JSON.parse(JSON.stringify(data))

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
      let _this = this;
      function onmarked( type, result ) {  //这个是扫描二维码的回调函数，type是扫描二维码回调的类型
        var text = '';
        switch(type){ //QR,EAN13,EAN8都是二维码的一种编码格式,result是返回的结果
          case plus.barcode.QR:
            text = 'QR: ';
            break;
          case plus.barcode.EAN13:
            text = 'EAN13: ';
            break;
          case plus.barcode.EAN8:
            text = 'EAN8: ';
            break;
        }
        console.log('type'+type);
        result = result.replace(/\"/g, "");
        // alert(result);
        _this.$router.push(result)
      }

      plus.gallery.pick(function(path){
        plus.barcode.scan(path,onmarked,function(error){
          plus.nativeUI.alert( "无法识别此图片" );
          _this.$router.replace('/banke')
        });
      },function(err){
        plus.nativeUI.alert("Failed: "+err.message);
      });

    },
      onSearch() {
      console.log('search');
    },
    onSort() {
      console.log('调序');
      this.$toast('功能尚未开发')
      // // this.galleryImg1()
      // let data = '"/banke/src"'
      // console.log(data);
      //
      // console.log(data);


    }
  }
}
</script>
