<template>
  <div class="content">
    <van-sticky>
      <van-nav-bar title="用户信息"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <van-cell-group>
      <card-item :imageUrl="imgUrl">
        <div slot="title-content" class="margin-top-normal text-big bold">
          池升恒
        </div>
      </card-item>
    </van-cell-group>

    <van-cell-group class="margin-topdown-small">
      <van-cell title="姓名">
        <template >
          <input class="input-css" :value="profile.name"/>
        </template>
      </van-cell>

      <van-cell title="昵称">
        <template >
          <input class="input-css" :value="profile.nickName"/>
        </template>
      </van-cell>

      <van-cell title="出生年月" @click.native="birthTimeClick" v-model="profile.birthtime">
      </van-cell>

      <van-cell title="性别">
        <template>
          <van-radio-group v-model="sexRadio" direction="horizontal" class="right">
            <van-radio name="male">{{maleValue}}</van-radio>
            <van-radio name="female">{{femaleValue}}</van-radio>
          </van-radio-group>
        </template>
      </van-cell>
    </van-cell-group>

    <van-cell-group class="margin-topdown-small">
      <van-cell title="学校">
        <template >
          <input class="input-css" :value="profile.school"/>
        </template>
      </van-cell>
      <van-cell title="学院">
        <template >
          <input class="input-css" :value="profile.department"/>
        </template>
      </van-cell>
      <van-cell title="学号">
        <template >
          <input class="input-css" :value="profile.studentId"/>
        </template>
      </van-cell>
    </van-cell-group>

    <van-button plain hairline type="primary" block class="margin-top-normal" @click="saveProfile">保存</van-button>

    <time-picker ref="timePick" @newTime="newTime"/>

  </div>
</template>

<script>
  import CardItem from "components/card/CardItem";

  import TimePicker from './components/TimePicker'

  import {profile} from "mock/mine/data";
  import {formatDate} from "common/utils";
  import {getProfile, updateProfile} from "../../../network/mine/home";

  export default {
    name: "Profile",
    data() {
      return {
        imgUrl: require('assets/image/mine/touxiang.png'),
        profile: profile,
        sexRadio: 'male',

        femaleValue: '男',
        maleValue: '女',

      }
    },
    created() {
      this.sexRadio = this.profile.sex
      this.getProfileData()
    },
    components: {
      CardItem,
      TimePicker
    },
    methods: {
      //获取个人信息
      getProfileData() {
        const params = {
          username: window.localStorage['userName']
        }
        console.log(params);

        getProfile(params).then(data => {
          console.log(data);
          this.femaleValue = data.femaleValue
          this.maleValue = data.maleValue
          const profile = {
            name: data.name,
            nickName: data.nickName,
            birthtime: data.birthtime,
            sex: data.sex,
            school: data.school,
            department: data.department,
            role: data.role,
            studentId: data.studentId,
            experience: data.experience,
          }

          this.sexRadio=data.sex

          this.profile = profile
        }).catch(err => {
          console.log(err);
        })
      },

      // 更新个人信息
      saveProfile() {
        console.log();
        let dateparse = this.profile.birthtime + "10日"
        let date = new Date(Date.parse(dateparse.replace('年','-').replace('月','-').replace('日','')))
        console.log(date);
        const user = {
          name: this.profile.name,
          nickname: this.profile.nickName,
          birthday: date,
          sex: this.profile.sex,
          school: this.profile.school,
          department: this.profile.department,
          role: this.profile.role,
          number: this.profile.studentId,
        }
        console.log(user);

        // const params = {
        //   profile
        // }
        updateProfile(user).then(data => {
          console.log(data);
          if (data == 'ok') {
            this.$toast('数据修改成功')
          }
        }).catch(err => {
        })
      },
      newTime(newtime) {
        this.profile.birthtime = formatDate(newtime, 'yyyy年MM月')
      },
      birthTimeClick() {
        this.$refs.timePick.show = true
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>
  .input-css {
    width: 100%;
    text-align:right;
    border: none;
  }
</style>