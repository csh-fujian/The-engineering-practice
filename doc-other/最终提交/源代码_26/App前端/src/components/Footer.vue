<template>
  <div class="text-desc text-center bottom_positon">{{CopyRight}}</div>
</template>

<script>
  import {Copyright} from 'config/global.js'

  export default {
    name: "LoginFooter",
    data() {
      return {
        CopyRight: Copyright
      }
    }
  }
</script>

<style scoped>
  .bottom_positon {
    position: absolute;
    bottom: 30px;
    width: 100%;
  }
</style>