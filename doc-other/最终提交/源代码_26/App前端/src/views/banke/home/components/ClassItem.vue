<template>
  <div>
    <van-cell class="item" label-class="right-content">
      <!-- 使用 title 插槽来自定义标题 -->
      <template #icon>
        <div>
          <van-image :src="imgSrc" alt="" class="item-img" />
        </div>
      </template>
      <template #title>
        <div class="title">
          <slot name="title-content"></slot>
          <slot name="icon"></slot>
          <slot name="title-right"></slot>
        </div>
      </template>
      <template #right-icon>
        <div class="into-position font-gray">
          <van-icon name="arrow" />
        </div>
      </template>
    </van-cell>

  </div>
</template>

<script>
  import imgUrl from 'assets/image/mine/yunbanke.png'
  export default {
    name: "ClassItem",
    data() {
      return {
        test: 'assets/image/banke/home/class.png',
        imgSrc: require('assets/image/mine/yunbanke.png')
      }
    },
  }
</script>

<style scoped>
  .item {
    height: 92px;
  }
  .item-img {
    margin-top: 6px;
    height: 65px;
    width: 65px;
  }
  .title {
    padding-left: 4%;
  }
  .into-position {
    margin-top: 30px;
    font-size: 20px;
  }
</style>