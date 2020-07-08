<template>
  <div>
    <md-field title="百科搜索">
      <div
        class="field-operator"
        slot="action"
      >
        <i class="md-icon icon-font md-icon-home home lg" @click="$router.push('/')"></i>
      </div>
      <md-input-item
        type="text"
        v-model="value"
        placeholder="大象的分布区域"
        :size="size"
        is-highlight
        @confirm="search"
      >
        <i class="md-icon icon-font md-icon-search search lg" slot="right" @click="search"></i>
      </md-input-item>
    </md-field>
    <md-textarea-item
      :autosize="true"
      v-model="results[0].value"
      v-if="results.length==1"
      readonly
      class="correctResult"
    >
    </md-textarea-item>
    <md-field v-if="results.length>1">
      <md-cell-item v-for="item in results" :key="item.key" :title="item.key" :brief="item.value">
      </md-cell-item>
    </md-field>
  </div>
</template>

<style lang="scss">
  .search {
    margin-right: 0.3rem;
  }

  textarea {
    padding: 0.2rem;
    color: #111a34 !important;
    font: 500 0.32rem Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, 微软雅黑, Arial, sans-serif;
    text-indent: 0.5rem;
  }
</style>

<script>
export default {
  data () {
    return {
      value: '',
      results: []
    }
  },
  computed: {
    size () {
      return this.value.length > 10 ? 'small' : 'middle'
    }
  },
  methods: {
    async search () {
      if (this.value === '') {
        this.value = '大象的分布区域'
      }
      await this._$axios.post('/query/' + this.value).then(result => {
        this.results = result.data
      })
    }
  }
}
</script>
