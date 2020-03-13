# vueapp

## 1.目录结构及使用说明

### 1.src目录结构

#### assets: 静态资源

* img：图像资源，对不同频道/页面的图片资源进行文件夹划分
* css：一般为全局Css的设置

#### components:公共组件

* 对于不同用途的公共组件进行文件夹划分

#### router:路由配置

* index.js：配置路由以及路由守护

#### views:一个频道为一个view

* 一级文件夹名：对应频道名

* 二级文件夹名：对应页面名

* 二级文件夹内Home.vue：对应页面组件

* 三级文件夹(components)：对应页面的组件

#### store: vuex配置V

* mutation-type：函数名的封装

* actions：封装Vuex的异步请求

* getters：封装Vuex的get对象

* mutations：封装Vuex的mutations对象

* index.js：Vuex的入口配置文件

#### network: 服务器数据异步请求封装

* network.js：封装不同的路由对象

* 以频道划分文件夹，以页面划分hs文件

#### common:公共js文件

* 常用的变量抽离
* 工具类utils.js
* mixin.js混入

### 2.public目录结构

项目编译发布的文件夹



## 2. 命名规则说明

文件夹名称：使用小写字母

组件名称：第一个字母大写，其余部分按照驼峰设置，如NavBar.vue



## 3.项目的使用

### Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Customize configuration


