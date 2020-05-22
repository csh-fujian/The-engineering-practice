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

      <van-cell title="出生年月" @click.native="birthTimeClick" :value="profile.birthtime">
      </van-cell>

      <van-cell title="性别">
        <template>
          <van-radio-group v-model="sexRadio" direction="horizontal" class="right">
            <van-radio name="male">男</van-radio>
            <van-radio name="female">女</van-radio>
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

    <van-button plain hairline type="primary" block class="margin-top-normal">保存</van-button>

    <time-picker ref="timePick" @newTime="newTime"/>

  </div>
</template>

<script>
  import CardItem from "components/card/CardItem";

  import TimePicker from './components/TimePicker'

  import {profile} from "mock/mine/data";
  import {formatDate} from "common/utils";

  export default {
    name: "Profile",
    data() {
      return {
        imgUrl: require('assets/image/mine/yunbanke.png'),
        profile: profile,
        sexRadio: 'male',
      }
    },
    created() {
      this.sexRadio = this.profile.sex
    },
    components: {
      CardItem,
      TimePicker
    },
    methods: {
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