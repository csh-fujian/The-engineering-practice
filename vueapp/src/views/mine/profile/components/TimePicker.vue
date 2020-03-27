<template>
  <div>
    <van-action-sheet v-model="show">
      <div class="content">
        <van-datetime-picker
                v-model="currentDate"
                type="year-month"
                :min-date="minDate"
                :max-date="maxDate"
                :formatter="formatter"
                @cancel="onCancel"
                @confirm="onSelect"
        />
      </div>
    </van-action-sheet>
  </div>
</template>

<script>
  export default {
    name: "TimePicker",
    data() {
      return {
        show: false,
        minDate: new Date(1900, 0, 1),
        maxDate: new Date(2025, 10, 1),
        currentDate: new Date()
      }
    },
    created() {

    },
    methods: {
      onSelect() {
        this.$emit('newTime', this.currentDate)
        this.show = false
      },
      onCancel() {
        this.show = false
      },
      formatter(type, val) {
        if (type === 'year') {
          return `${val}年`;
        } else if (type === 'month') {
          return `${val}月`
        }
        return val;
      },
    }
  }
</script>

<style scoped>

</style>