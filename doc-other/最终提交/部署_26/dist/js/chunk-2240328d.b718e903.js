(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2240328d"],{"386b":function(e,t,a){var n=a("5ca1"),l=a("79e5"),s=a("be13"),o=/"/g,c=function(e,t,a,n){var l=String(s(e)),c="<"+t;return""!==a&&(c+=" "+a+'="'+String(n).replace(o,"&quot;")+'"'),c+">"+l+"</"+t+">"};e.exports=function(e,t){var a={};a[e]=t(c),n(n.P+n.F*l((function(){var t=""[e]('"');return t!==t.toLowerCase()||t.split('"').length>3})),"String",a)}},"673e":function(e,t,a){"use strict";a("386b")("sub",(function(e){return function(){return e(this,"sub","","")}}))},fe93:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("ul",[a("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[a("ul",e._l(e.datatable,(function(t,n){return a("li",[a("el-checkbox",{key:t,attrs:{label:t.name}},[a("strong",[e._v(e._s(t.name))])]),a("ul",[a("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[a("ul",e._l(e.datatable[n].sub,(function(t,l){return a("li",[a("el-checkbox",{key:t,staticStyle:{display:"inline",margin:"0px 0px 10px 23px"},attrs:{label:t.name}},[e._v(e._s(t.name))]),a("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[a("ul",e._l(e.datatable[n].sub[l].sub,(function(t,s){return a("li",[a("el-checkbox",{key:t,staticStyle:{display:"inline",margin:"0px 0px 10px 43px"},attrs:{label:t.name}},[e._v(e._s(t.name))]),a("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},[a("el-checkbox-group",{model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}},e._l(e.datatable[n].sub[l].sub[s].sub,(function(t){return a("el-checkbox",{key:t,staticStyle:{display:"inline",margin:"0px 0px 10px 60px"},attrs:{label:t.name,disabled:""}},[e._v(e._s(t.name))])})),1)],1)],1)})),0)])],1)})),0)])],1),a("el-divider")],1)})),0)])],1),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.consent()}}},[e._v("确定")])],1)},l=[],s=(a("673e"),a("7f7f"),a("a481"),{data:function(){return{selected:[],rolename:"",Permission:{role:"",menus:[]},test:[],datatable:[]}},methods:{consent:function(){var e=this;this.Permission.role=this.rolename,this.Permission.menus=this.selected,console.log(this.Permission),this.$axios.post("http://47.112.239.108:8080/webpermission/addpermission",this.Permission,{headers:{Authorization:localStorage.getItem("token")}}).then((function(t){e.$alert("分配权限成功","分配权限",{confirmButtonText:"确定",callback:function(e){}})})).catch((function(t){e.$confirm("token已经过期了，请点击确定重新登录","提示",{confirmButtonText:"确定",type:"warning"}).then((function(){e.$store.commit("LOGIN_OUT"),window.location.reload()}))}))}},created:function(){var e=this;this.rolename=this.$route.query.rolename;var t=this;null==this.rolename&&(this.$alert("请前往角色管理选择角色","未选择角色",{confirmButtonText:"确定",callback:function(e){}}),this.$router.replace({path:"/designRolemanage/designRolemanage1"})),this.$axios.get("http://47.112.239.108:8080/webpermission/findAll/"+this.rolename,{headers:{Authorization:localStorage.getItem("token")}}).then((function(a){t.datatable=a.data,console.log(t.datatable);for(var n=0;n<e.datatable.length;++n)if("checked"==e.datatable[n].state&&e.selected.push(e.datatable[n].name),null!=e.datatable[n].sub)for(var l=0;l<e.datatable[n].sub.length;++l)if("checked"==e.datatable[n].sub[l].state&&e.selected.push(e.datatable[n].sub[l].name),null!=e.datatable[n].sub[l].sub)for(var s=0;s<e.datatable[n].sub[l].sub.length;++s)if("checked"==e.datatable[n].sub[l].sub[s].state&&e.selected.push(e.datatable[n].sub[l].sub[s].name),null!=e.datatable[n].sub[l].sub[s].sub)for(var o=0;o<e.datatable[n].sub[l].sub[s].sub.length;++o)"checked"==e.datatable[n].sub[l].sub[s].sub[o].state&&e.selected.push(e.datatable[n].sub[l].sub[s].sub[o].name),e.datatable[n].sub[l].sub[s].sub[o].sub})).catch((function(t){e.$confirm("token已经过期了，请点击确定重新登录","提示",{confirmButtonText:"确定",type:"warning"}).then((function(){e.$store.commit("LOGIN_OUT"),window.location.reload()}))}))}}),o=s,c=a("2877"),i=Object(c["a"])(o,n,l,!1,null,null,null);t["default"]=i.exports}}]);