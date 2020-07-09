<template>
  <div id="app">
    <md-transition transition="md-slide-left">
      <router-view/>
    </md-transition>
  </div>
</template>

<style scoped>
  html{
    touch-action: manipulation;
    background: #f3f4f5;
  }
  body{
    font-family: Helvetica Neue,Helvetica,PingFang SC,Hiragino Sans GB,Microsoft YaHei,微软雅黑,Arial,sans-serif;
    -webkit-tap-highlight-color: transparent;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
</style>
