<template>
  <div >
    <van-cell-group>
      <member-item />
    </van-cell-group>
  </div>
</template>

<script>
  import MemberItem from "./MemberItem";
  export default {
    name: "MemberList",
    components: {
      MemberItem
    }
  }
</script>

<style scoped>

</style>