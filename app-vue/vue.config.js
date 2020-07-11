  // 引入路由配置文件
  const URL = require('./config/url')
 // 定义公共路由
  process.env.VUE_APP_BASE_URL = URL[process.env.ENV]
module.exports = {
  outputDir: 'dist',
  indexPath: 'index.html',
  filenameHashing: true,
  pages: {
    index: {
      entry: 'src/main.js',
      template: 'public/index.html',
      filename: 'index.html',
      chunks: ['chunk-vendors','chunk-common','index']
    }
  },
  assetsDir: "assets",
  runtimeCompiler: false,
  css: {
    loaderOptions: {
      postcss: {
        plugins: [
          require('postcss-pxtorem')({
            rootValue: 100,
            propWhiteList: [],
            minPixelValue: 2
          }),
          require('autoprefixer')()
        ]
      }
    }
  },
  publicPath: './',
  lintOnSave: true, // default false
  productionSourceMap: false,
  devServer: {
    open: true,
    host: 'localhost',
    port: 8080,
    https: false,
    hotOnly: false,
    proxy: {
        //配置跨域
        '/': {
            target: process.env.VUE_APP_BASE_URL,
            ws: true,
            changeOrigin: true,
            pathRewrite: {
                '^/': ''
            }
        }
    }
  }
}
