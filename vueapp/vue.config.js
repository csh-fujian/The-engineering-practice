const path = require("path");
const myTheme = path.resolve(__dirname, "src/assets/css/theme/var.less");

module.exports = {

  //本地测试时设置 baseUrl名字改了 !!!!打包apk要用
  publicPath: process.env.NODE_ENV === 'production' ? './' : './',



  // webpack-dev-server 相关配置
  // devServer: {
  //   host: '0.0.0.0',
  //   port: 8080,
  //   https: false,
  //   open: true,
  //   hotOnly: false,
  //   proxy: null, // 设置代理
  //   before: app => {},
  // },
  // dev模式下的跨域问题，代理解决
  devServer: {
    port:8088,
    // hotOnly: true,
    // disableHostCheck: true,

    proxy: {
      '/': {
        target: 'http://47.112.239.108:8081/',
        changeOrigin: true,
        secure: false,
        pathRewrite: {
          '^/': '/' //用/来代替 http://47.112.239.108:8081/
        }
      }
    }
  },

  css: {
    loaderOptions: {
      less: {
        modifyVars: {
          hack: `true; @import "${myTheme}";`
        },
      },
    }
  },
  configureWebpack: {
    resolve: {
      //别名的配置
      alias: {
        //内部以配置 '@': 'src'
        'assets': '@/assets',
        'components': '@/components',
        'network': '@/network',
        'views': '@/views',
        'common': '@/common',
        'config': '@/config',
        'mock': '@/mock'
      }
    }
  },
}