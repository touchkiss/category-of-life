<template>
  <div class="item">
    <div class="left">
      <label>{{ item.cnName.length>15? item.cnName.substring(0,15):item.cnName}}</label>
    </div>
    <div class="right" v-if="item.parent" @click="go(item.id)">
      <i class="cubeic-arrow"></i>
    </div>
  </div>
</template>

<style lang="scss">
  .item {
    width: 100%;

    .left {
      float: left;
      width: 85%;
      padding-left: 10px;
    }

    .right {
      border-left: solid 1px pink;
      padding-left: 15px;
      float: left;
    }
  }
</style>

<script>
export default {
  props: ['item'],
  data () {
    return {}
  },
  methods: {
    go (id) {
      this.$router.push('/list/' + id)
    }
  }
}
</script>
