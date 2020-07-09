<template>
  <div class="scroll-list-wrap">
    <div class="md-nav">
      <p class="home" @click="$router.push('/')">
        <i class="md-icon icon-font md-icon-home home lg"></i>
      </p>
      <p class="name">{{title}}</p>
      <p class="search" @click="$router.push('/search')">
        <i class="md-icon icon-font md-icon-search search lg"></i>
      </p>
    </div>
    <div class="list-field">
      <md-field>
        <md-cell-item v-for="item in items" :key="item.id" :title="item.cnName" :brief="item.className"
                      @click="showData(item)">
          <i v-if="item.parent" class="md-icon icon-font md-icon-arrow-right lg" slot="right"
             @click.stop="$router.push('/list/' +item.id)"></i>
        </md-cell-item>
      </md-field>
    </div>
    <md-popup
      v-model="showPopup"
      position="bottom"
    >
      <md-popup-title-bar
        :title="popupItem.cnName"
        :describe="popupItem.enName"
        large-radius
      ></md-popup-title-bar>
      <div class="popup-main">
        <iframe v-if="popupItem.cnName" :src="'https://baike.baidu.com/item/'+popupItem.cnName"></iframe>
      </div>
    </md-popup>
  </div>
</template>

<style lang="scss" scoped>
  .scroll-list-wrap {
    background: #f3f4f5;

    .md-nav {
      position: relative;
      display: -webkit-box;
      display: -webkit-flex;
      display: flex;
      padding: 0.32rem 0.2rem 0.2rem 0.2rem;

      p {
        position: relative;
        display: inline-block;
        line-height: 1;
      }

      .home,.search {
        font-size: 0.6rem;
        color: #0099CC;
      }

      .name {
        margin-left: 0.32rem;
        font-size: 0.6rem;
        font-weight: 500;
        color: #111a34;
      }
      .search{
        right: 0.1rem;
        position: absolute;
      }
    }

    .md-field {
      padding-top: 0;
    }

    .md-popup-title-bar {
      height: 1rem !important;

      div {
        padding-top: 0.1rem !important;
      }
    }

    .popup-main {
      background: #ecf6ff;
      min-height: 8rem;

      iframe {
        border: none;
        width: 100%;
        height: 8rem;
      }
    }
  }

</style>

<script>
import qs from 'qs'

export default {
  props: ['id'],
  data () {
    return {
      items: [],
      title: '物种百科',
      showPopup: false,
      popupItem: {}
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
    },
    showData (item) {
      this.showPopup = true
      this.popupItem = item
      this.$set(this.popupItem, 'bottom', true)
    }
  }
}
</script>
