<template>
  <div>
    <van-nav-bar title="我的信息">
      <template #right>
        帮助
      </template>
    </van-nav-bar>

    <van-cell-group @click.native="profileClick">
      <card-item>
        <div slot="title-content" class="margin-top-normal text-big bold">
          个人信息
        </div>
      </card-item>
    </van-cell-group>

<!--    <van-grid class="margin-topdown-small">-->
<!--      <van-grid-item  text="经验值" />-->
<!--      <van-grid-item  text="签到数" />-->
<!--      <van-grid-item  text="解答数" />-->
<!--      <van-grid-item  text="点赞数" />-->
<!--    </van-grid>-->

    <div class="margin-top-large"></div>


    <van-cell title="账号管理" is-link @click.native="accountClick"/>
    <van-cell title="用户协议" is-link value="ISSA" @click.native="userClick"/>
    <van-cell title="隐私政策" is-link @click.native="privacyClick"/>
    <van-cell title="关于我们" is-link @click.native="aboutClick"/>
    <van-cell title="设置" is-link @click.native="setClick" />
    <md-tab-bar activeValue="mine" />
  </div>
</template>

<script>
  import MdTabBar from "components/tabbar/MdTabBar";
  import CardItem from "components/card/CardItem";

  export default {
    name: "MineHome",
    components: {
      MdTabBar,
      CardItem
    },
    methods: {
      accountClick() {
        this.$router.push('/mine/account-manage')
      },
      profileClick() {
        this.$router.push('/mine/profile')
      },
      privacyClick() {
        this.$router.push('/mine/privacy')
      },
      aboutClick() {
        this.$router.push('/mine/about-us')
      },
      userClick() {
        this.$router.push('/mine/user-policy')
      },
      setClick() {
        this.$router.push('/mine/setting')
      }
    }
  }
</script>

<style scoped>
</style>