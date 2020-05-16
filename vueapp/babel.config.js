
module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset',
    // ["es2015", { "modules": false }]
  ],

  plugins: [
    [
      'import', {
        libraryName: 'vant',
        libraryDirectory: 'es',
        style: name => `${name}/style/less`
      },
      'vant'
    ]
  ]
}
