<template>
  <div>

    <router-view />
    <Footer />
  </div>
</template>

<script>
  import Footer from "components/Footer";
  export default {
    name: "AccountManage",
    components: {
      Footer
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>