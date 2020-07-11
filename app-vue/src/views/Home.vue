<template>
  <div class="home">
    <md-tab-bar
      v-model="current"
      :items="tabbarTitles"
      @change="onTabChange"
    ></md-tab-bar>
    <md-field class="home-search">
      <md-input-item
        type="text"
        placeholder="大象的分布区域"
        is-amount
        is-highlight
      >
        <i class="md-icon icon-font md-icon-search search lg" slot="right"></i>
      </md-input-item>
    </md-field>
    <md-swiper
      ref="swiper"
      :autoplay="0"
      :is-prevent="false"
      :is-loop="false"
      :has-dots="false"
      @before-change="onSwiperChange"
    >
      <md-swiper-item>
        <md-field class="main-recommend-area">
          <md-field class="banner">
          </md-field>
        </md-field>
        <md-field class="classify-btn-area">
          <el-row :gutter="20">
            <el-col v-for="cbtn in cbtns" :key="cbtn.name" :span="6"><div class="classify-btn"><el-avatar :size="100" :src="cbtn.img" fit="cover"></el-avatar><label>{{cbtn.name}}</label></div></el-col>
          </el-row>
        </md-field>
        <router-view path="/list"></router-view>
      </md-swiper-item>
      <md-swiper-item>
        又是一年，她又遇到了他，他正牵着孩子的手，走的飞快。
      </md-swiper-item>
    </md-swiper>
  </div>
</template>
<style lang="scss">
  .md-tab-bar {
    padding-left: 0rem;
    padding-right: 0rem;
    margin-top: -0.3rem;
    background: #5370a5;

    .md-tab-bar-inner {
      .md-scroll-view {
        .md-tab-bar-list {
          a.md-tab-bar-item {
            color: white;
            font-size: 0.3rem;
          }

          a.md-tab-bar-item.is-active {
            font-size: 0.35rem;
          }
        }
      }

    }
  }

  .home-search {
    background: #5370a5;
    padding: 0.2rem 0.4rem;

    .md-field-item-content {
      min-height: 0.6rem;
      border-radius: 0.3rem;
      border: none;
      background: #ffffff;
      padding: 0 0.3rem;

      .md-input-item-input {
        line-height: 0.6rem;
        height: 0.6rem;
        border: none;
      }
    }

    .md-field-item-content:before {
      border-bottom: none !important;
    }
  }

  .main-recommend-area {
    background: #5370a5;

    .banner {
      border-radius: 0.2rem;
      padding: 0.1rem;
      background-image: url("http://pic1.win4000.com/wallpaper/4/543f715e9a2ab.jpg?down");
      background-size: cover;
      background-position-y: center;
      height: 2.5rem;
      z-index: 999;
    }

    .classify-btn-area {
      margin-top: -0.5rem;
      background: white;
      .md-field-content{
        .el-row{
          .el-col{
            .classify-btn{
              background: pink;
              font-size: 0.1rem!important;
              position: relative;
              span{
                margin: 0 auto;
              }
            }

          }
        }
      }
    }
  }
</style>
<script>
export default {
  name: 'home',
  data () {
    return {
      tabbarTitles: [
        { name: 0, label: '推荐' },
        { name: 1, label: '动物界' },
        { name: 2, label: '植物界' },
        { name: 3, label: '细菌界' },
        { name: 4, label: '真菌界' },
        { name: 5, label: '色素界' },
        { name: 6, label: '病毒' },
        { name: 7, label: '原生动物界' },
        { name: 8, label: '古细菌界' }
      ],
      current: 0,
      mainSwiperImgs: [
        { src: 'http://picture.ik123.com/uploads/allimg/161203/3-1612030ZG5.jpg', text: '称霸森林的动物' },
        { src: 'http://5b0988e595225.cdn.sohucs.com/images/20180620/e7e33799729847828e79b684b1be6479.jpg', text: '兔子' },
        { src: 'http://pic1.win4000.com/wallpaper/4/543f715e9a2ab.jpg?down', text: '鸟' }
      ],
      cbtns: [
        { name: '濒临灭绝', img: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3591085026,2645681060&fm=26&gp=0.jpg' },
        { name: '本地特有', img: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3591085026,2645681060&fm=26&gp=0.jpg' },
        { name: '最近发现', img: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3591085026,2645681060&fm=26&gp=0.jpg' },
        { name: '世界之最', img: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3591085026,2645681060&fm=26&gp=0.jpg' }
      ]
    }
  },
  methods: {
    onSwiperChange (from, to) {
      this.current = to
    },
    onTabChange (item, index) {
      this.$refs.swiper.goto(index)
    }
  }
}
</script>
