(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-40878902"],{"386b":function(e,t,n){var a=n("5ca1"),i=n("79e5"),l=n("be13"),s=/"/g,u=function(e,t,n,a){var i=String(l(e)),u="<"+t;return""!==n&&(u+=" "+n+'="'+String(a).replace(s,"&quot;")+'"'),u+">"+i+"</"+t+">"};e.exports=function(e,t){var n={};n[e]=t(u),a(a.P+a.F*i((function(){var t=""[e]('"');return t!==t.toLowerCase()||t.split('"').length>3})),"String",n)}},"673e":function(e,t,n){"use strict";n("386b")("sub",(function(e){return function(){return e(this,"sub","","")}}))},"6ed9":function(e,t,n){},"9bec":function(e,t,n){"use strict";var a=n("6ed9"),i=n.n(a);i.a},ef71:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("ul",[n("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[n("ul",e._l(e.datatable,(function(t,a){return n("li",[n("el-checkbox",{key:t,attrs:{label:t.name}},[n("strong",[e._v(e._s(t.name))])]),n("ul",[n("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[n("ul",e._l(e.datatable[a].sub,(function(t,i){return n("li",[n("el-checkbox",{key:t,staticStyle:{display:"inline",margin:"0px 0px 10px 23px"},attrs:{label:t.name}},[e._v(e._s(t.name))]),n("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},e._l(e.datatable[a].sub[i].sub,(function(t){return n("el-checkbox",{key:t,staticStyle:{display:"inline",margin:"0px 0px 10px 43px"},attrs:{label:t.name}},[e._v(e._s(t.name))])})),1)],1)})),0)])],1),n("el-divider")],1)})),0)])],1),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addmenu3()}}},[e._v("添加菜单")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addpagestemp()}}},[e._v("添加页面")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addbutton3()}}},[e._v("添加按钮")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.handdelete()}}},[e._v("勾选删除")]),n("el-dialog",{attrs:{title:"添加菜单",visible:e.dialogVisible1,width:"60%","before-close":e.handleClose1},on:{"update:visible":function(t){e.dialogVisible1=t}}},[n("el-form",{attrs:{model:e.menuname,"label-width":"80px"}},[n("el-form-item",{attrs:{label:"名称"}},[n("el-input",{model:{value:e.menuname,callback:function(t){e.menuname=t},expression:"menuname"}})],1),n("el-form-item",{attrs:{label:"链接"}},[n("el-input",{model:{value:e.temp1,callback:function(t){e.temp1=t},expression:"temp1"}})],1),n("el-form-item",{attrs:{label:"包含页面"}},[e._l(e.submenus,(function(t){return n("el-tag",{key:t,attrs:{closable:"","disable-transitions":!1},on:{close:function(n){return e.handleClose(t)}}},[e._v(" "+e._s(t)+" ")])})),e.inputVisible?n("el-input",{ref:"saveTagInput",staticClass:"input-new-tag",attrs:{size:"small"},on:{blur:e.handleInputConfirm},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleInputConfirm(t)}},model:{value:e.inputValue,callback:function(t){e.inputValue=t},expression:"inputValue"}}):n("el-button",{attrs:{size:"small"},on:{click:e.showInput}},[e._v("添加新页面")])],2)],1),n("el-button",{on:{click:function(t){e.dialogVisible1=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addmenu()}}},[e._v("确 定")])],1),n("el-dialog",{attrs:{title:"添加页面",visible:e.dialogVisible2,width:"60%","before-close":e.handleClose2},on:{"update:visible":function(t){e.dialogVisible2=t}}},[n("el-form",{attrs:{model:e.menuname,"label-width":"80px"}},[n("el-form-item",{attrs:{label:"名称"}},[n("el-input",{model:{value:e.menuname,callback:function(t){e.menuname=t},expression:"menuname"}})],1),n("el-form-item",{attrs:{label:"链接"}},[n("el-input",{model:{value:e.temp1,callback:function(t){e.temp1=t},expression:"temp1"}})],1),n("el-form-item",{attrs:{label:"上级菜单"}},[n("el-input",{model:{value:e.supermenu,callback:function(t){e.supermenu=t},expression:"supermenu"}})],1),n("el-form-item",{attrs:{label:"包含按钮"}},[e._l(e.submenus,(function(t){return n("el-tag",{key:t,attrs:{closable:"","disable-transitions":!1},on:{close:function(n){return e.handleClose(t)}}},[e._v(" "+e._s(t)+" ")])})),e.inputVisible?n("el-input",{ref:"saveTagInput",staticClass:"input-new-tag",attrs:{size:"small"},on:{blur:e.handleInputConfirm},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleInputConfirm(t)}},model:{value:e.inputValue,callback:function(t){e.inputValue=t},expression:"inputValue"}}):n("el-button",{attrs:{size:"small"},on:{click:e.showInput}},[e._v("添加新按钮")])],2)],1),n("el-button",{on:{click:function(t){e.dialogVisible2=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addpage()}}},[e._v("确 定")])],1),n("el-dialog",{attrs:{title:"添加按钮",visible:e.dialogVisible3,width:"50%","before-close":e.handleClose3},on:{"update:visible":function(t){e.dialogVisible3=t}}},[n("el-form",{attrs:{model:e.menuname,"label-width":"80px"}},[n("el-form-item",{attrs:{label:"名称"}},[n("el-input",{model:{value:e.button,callback:function(t){e.button=t},expression:"button"}})],1),n("el-form-item",{attrs:{label:"上级页面"}},[n("el-input",{model:{value:e.supermenu,callback:function(t){e.supermenu=t},expression:"supermenu"}})],1),n("el-form-item",{attrs:{label:"用途说明"}},[n("el-input",{model:{value:e.temp1,callback:function(t){e.temp1=t},expression:"temp1"}})],1)],1),n("el-button",{on:{click:function(t){e.dialogVisible3=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addbutton()}}},[e._v("确 定")])],1)],1)},i=[],l=(n("673e"),n("7f7f"),{data:function(){return{selected:[],temp1:"",temp2:0,dialogVisible1:!1,dialogVisible2:!1,dialogVisible3:!1,submenus:[],inputVisible:!1,inputValue:"",menuname:"",supermenu:"",button:"",delSel:{submenu:[]},button1:{button:"",supermenu:""},Menu:{menuname:"",submenus:[]},Page:{menuname:"",supermenu:""},Page1:{menuname:"",supermenu:"",buttons:[]},buttons:[],datatable:[]}},methods:{handdelete:function(){var e=this;this.delSel.submenu=this.selected,console.log(this.delSel);var t=this;this.$axios.post("http://47.112.239.108:8080/webmenu/deletemenu",this.delSel,{headers:{Authorization:localStorage.getItem("token")}}).then((function(e){t.$axios.get("http://47.112.239.108:8080/webmenu/findAll",{headers:{Authorization:localStorage.getItem("token")}}).then((function(e){t.datatable=e.data,t.$alert("删除成功","删除",{confirmButtonText:"确定",callback:function(e){}})}))})).catch((function(t){e.$confirm("token已经过期了，请点击确定重新登录","提示",{confirmButtonText:"确定",type:"warning"}).then((function(){e.$store.commit("LOGIN_OUT"),window.location.reload()}))}))},addpagestemp:function(){this.dialogVisible2=!0,this.menuname="",this.temp1="",this.supermenu="",this.submenus=[]},addbutton3:function(){this.dialogVisible3=!0,this.supermenu="",this.button="",this.temp1=""},handleClose3:function(){this.dialogVisible3=!1},addmenu3:function(){this.dialogVisible1=!0,this.menuname="",this.temp1="",this.submenus=[]},handleClose:function(e){this.submenus.splice(this.submenus.indexOf(e),1)},addmenu:function(){var e=this;this.dialogVisible1=!1,this.Menu.menuname=this.menuname,this.Menu.submenus=this.submenus,console.log(this.menuname);var t=this;""!=this.menuname?this.$axios.post("http://47.112.239.108:8080/webmenu/addmenu1/"+this.menuname,{},{headers:{Authorization:localStorage.getItem("token")}}).then((function(n){t.$message({type:"success",message:n.data}),e.$axios.post("http://47.112.239.108:8080/webmenu/addmenu",t.Menu,{headers:{Authorization:localStorage.getItem("token")}}).then((function(e){t.$axios.get("http://47.112.239.108:8080/webmenu/findAll",{headers:{Authorization:localStorage.getItem("token")}}).then((function(e){t.datatable=e.data}))}))})):t.$message({type:"success",message:"添加失败，菜单名称不能为空"})},addpage:function(){var e=this;this.dialogVisible2=!1,this.buttons=this.submenus,this.Page.menuname=this.menuname,this.Page.supermenu=this.supermenu,this.Page1.buttons=this.buttons,this.Page1.menuname=this.menuname,this.Page1.supermenu=this.supermenu;var t=this;console.log(this.Page),console.log(this.Page1),this.$axios.post("http://47.112.239.108:8080/webmenu/addpage1",this.Page,{headers:{Authorization:localStorage.getItem("token")}}).then((function(n){t.$message({type:"success",message:n.data}),e.$axios.post("http://47.112.239.108:8080/webmenu/addpage",t.Page1,{headers:{Authorization:localStorage.getItem("token")}}).then((function(n){e.$axios.get("http://47.112.239.108:8080/webmenu/findAll",{headers:{Authorization:localStorage.getItem("token")}}).then((function(e){t.datatable=e.data}))}))}))},addbutton:function(){this.dialogVisible3=!1,this.button1.button=this.button,this.button1.supermenu=this.supermenu;var e=this;console.log(this.button1),this.$axios.post("http://47.112.239.108:8080/webmenu/addbutton",this.button1,{headers:{Authorization:localStorage.getItem("token")}}).then((function(t){e.$message({type:"success",message:t.data}),e.$axios.get("http://47.112.239.108:8080/webmenu/findAll",{headers:{Authorization:localStorage.getItem("token")}}).then((function(t){e.datatable=t.data}))}))},handleClose2:function(e){this.dialogVisible2=!1},handleClose1:function(){this.dialogVisible1=!1},showInput:function(){var e=this;this.inputVisible=!0,this.$nextTick((function(t){e.$refs.saveTagInput.$refs.input.focus()}))},handleInputConfirm:function(){var e=this.inputValue;e&&this.submenus.push(e),this.inputVisible=!1,this.inputValue=""}},created:function(){var e=this;this.$axios.get("http://47.112.239.108:8080/webmenu/findAll",{headers:{Authorization:localStorage.getItem("token")}}).then((function(t){e.datatable=t.data;for(var n=0;n<e.datatable.length;++n)if("checked"==e.datatable[n].state&&e.selected.push(e.datatable[n].name),null!=e.datatable[n].sub)for(var a=0;a<e.datatable[n].sub.length;++a)if("checked"==e.datatable[n].sub[a].state&&e.selected.push(e.datatable[n].sub[a].name),null!=e.datatable[n].sub[a].sub)for(var i=0;i<e.datatable[n].sub[a].sub.length;++i)"checked"==e.datatable[n].sub[a].sub[i].state&&e.selected.push(e.datatable[n].sub[a].sub[i].name),e.datatable[n].sub[a].sub[i].sub})).catch((function(t){e.$confirm("token已经过期了，请点击确定重新登录","提示",{confirmButtonText:"确定",type:"warning"}).then((function(){e.$store.commit("LOGIN_OUT"),window.location.reload()}))}))}}),s=l,u=(n("9bec"),n("2877")),o=Object(u["a"])(s,a,i,!1,null,null,null);t["default"]=o.exports}}]);