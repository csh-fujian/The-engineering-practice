<template>
  <div>
    <van-cell class="item" label-class="right-content">
      <!-- 使用 title 插槽来自定义标题 -->
      <template #icon>
        <van-image :src="imageUrl" width="65px" height="65px" class="item-img" />
      </template>

      <template #title>
        <div class="title">
          <slot name="title-content"></slot>
          <slot name="icon"></slot>
        </div>
      </template>
      <template #right-icon>
        <div class="into-position font-gray">
          <van-icon name="arrow" size="large"/>
        </div>
      </template>
    </van-cell>

  </div>
</template>

<script>
  export default {
    name: "CardItem",
    data() {
      return {
      }
    },
    props: {
      imageUrl: {
        type: String,
        // 不能是字符串格式的
        default: require('assets/image/banke/home/class.png')
      }
    }
  }
</script>

<style scoped>
  .item {
    height: 90px;
  }
  .item-img {
    margin-top: 6px;
  }
  .title {
    padding-left: 4%;
  }
  .into-position {
    margin-top: 30px;
    font-size: 20px;
  }
</style>