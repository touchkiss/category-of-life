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
        :placeholder="randomPlaceholder()"
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

  .md-textarea-item__textarea {
    padding: 0.2rem!important;
    color: #111a34 !important;
    font: 500 0.32rem Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, 微软雅黑, Arial, sans-serif;
    text-indent: 0.5rem!important;
  }
</style>

<script>
export default {
  data () {
    return {
      value: '',
      results: [],
      placeholders: ['大象的分布区域', '霸王龙的体型', '翼手龙的简介', '鸵鸟的食物', '金枪鱼的别称'],
      placeholder: ''
    }
  },
  watch: {
    '$route.path' (newVal, oldVal) {
      this.value = this.$route.params.search
      this.search()
    }
  },
  created () {
    if (this.$route.params.search) {
      this.value = this.$route.params.search
      this.search()
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
        this.value = this.placeholder
      }
      await this._$axios.post('/baike/query/' + this.value).then(result => {
        this.results = result.data
      })
    },
    randomPlaceholder () {
      this.placeholder = this.placeholders[parseInt((Math.random() * this.placeholders.length))]
      return this.placeholder
    }
  }
}
</script>
