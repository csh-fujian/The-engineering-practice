<template>
  <div class="home">
    home
  </div>
</template>

<script>

export default {
  name: 'Home',
  created() {
    console.log(this.$store.state.test);
  },
  components: {
  }
}
</script>
