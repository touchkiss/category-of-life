<template>
<div class="container">
  <h1 class="welcome-header">Welcome to the museum</h1>
  <div class="body">
    <img src="../assets/images/bird.gif">
    <div class="content">
      <div class="nature">Nature</div>
    </div>
  </div>
  <div class="footer">
    <a class="museum"><i class="cubeic-navigation"></i>&nbsp;&nbsp;Into the museum<i class="cubeic-arrow"></i></a>
    <a class="search"><i class="cubeic-search"></i>&nbsp;Search the database<i class="cubeic-arrow"></i></a>
  </div>
</div>
</template>

<script>
export default {
  name: 'Welcome'
}
</script>

<style lang="scss">
  .container{
    background-color: #fa3f35;
    width: 100%;
    height: 100%;
    .welcome-header{
      font-size: 50px;
      color:white;
      font-weight: 600;
      padding-top: 80px;
      padding-left: 20px;
    }
    .body{
      width: 100%;
      img{
        width: 230px;
        height: 230px;
        position: absolute;
        top: 200px;
        right: 40px;
      }
      .content{
        .nature{
          font-size: 50px;
          font-weight: 600;
          color: white;
        }
      }
    }
    .footer{
      position: absolute;
      bottom: 20px;
      width: 100%;
      padding-left: 20px;
      a{
        height: 50px;
        width: 100%;
        line-height: 50px;
        color: white;
        font-size: 20px;
        font-weight: 200;
        display: block;
        .cubeic-arrow{
          position: absolute;
          right: 20px;
          font-size: 30px;
          font-weight: 100;
        }
      }
    }
  }
</style>
