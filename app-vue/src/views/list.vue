<template>
  <div class="scroll-list-wrap">
    <header class="header"><i class="cubeic-back" v-if="$route.params.id" @click="$router.go(-1)"></i></header>
    <cube-scroll
      ref="scroll"
      :data="items">
      <ul class="list-wrapper">
        <li v-for="item in items" :key="item.id" class="list-item">
          <ListItem :item="item"></ListItem>
        </li>
      </ul>
    </cube-scroll>
  </div>
</template>

<style lang="scss">
  .scroll-list-wrap {
    height: 100%;

    .header {
      position: relative;
      height: 44px;
      line-height: 44px;
      text-align: center;
      background-color: #edf0f4;
      box-shadow: 0 1px 6px #ccc;
      -webkit-backface-visibility: hidden;
      backface-visibility: hidden;
      z-index: 5;
      h1{
        font-size: 16px;
        font-weight: 700;
      }
      i{
        position: absolute;
        top: 0;
        left: 0;
        padding: 0 15px;
        color: #fc9153;
      }
    }

    .list-item {
      height: 60px;
      border-bottom: solid 1px pink;
      line-height: 50px;
      padding: 5px;
      font-size: 20px;
    }
  }
</style>

<script>
import qs from 'qs'
import ListItem from '@/components/ListItem'

export default {
  props: ['id'],
  components: {
    ListItem
  },
  data () {
    return {
      items: [],
      title: ''
    }
  },
  watch: {
    '$route.path' (newVal, oldVal) {
      this.getList(this.$route.params.id)
    }
  },
  created () {
    this.getList(this.$route.params.id)
  },
  methods: {
    async getList (id) {
      const url = '/species2000cn/browse/' + (id || '')
      await this._$axios.post(url, qs.stringify({ otherParam: 'zTreeAsyncTest' })).then(result => {
        this.items = result.data
      })
    }
  }
}
</script>
