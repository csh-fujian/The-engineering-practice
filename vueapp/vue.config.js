module.exports = {
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
  }
}