const path = require("path");
const myTheme = path.resolve(__dirname, "src/assets/css/theme/var.less");

module.exports = {
  css: {
    loaderOptions: {
      less: {
        modifyVars: {
          hack: `true; @import "${myTheme}";`
        }
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
        'common': '@/common'
      }
    }
  },
}