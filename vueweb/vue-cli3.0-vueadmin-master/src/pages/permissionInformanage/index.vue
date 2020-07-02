<template>
    <div>
        <ul>
            <el-checkbox-group v-model="selected" >
                <ul>
                    <li  v-for="(item1,index1) in datatable">
                        <el-checkbox :label="item1.name" :key="item1"><strong >{{item1.name}}</strong></el-checkbox>
                        <ul>
                            <el-checkbox-group v-model="selected" >
                                <ul>
                                    <li  v-for="(item2,index2) in datatable[index1].sub">
                                        <el-checkbox  style="display:inline;margin: 0px 0px 10px 23px" :label="item2.name" :key="item2">{{item2.name}}</el-checkbox>
                                        <el-checkbox-group v-model="selected" >
                                            <ul>
                                                <li  v-for="(item3,index3) in datatable[index1].sub[index2].sub">
                                                    <el-checkbox  style="display:inline;margin: 0px 0px 10px 43px" :label="item3.name" :key="item3">{{item3.name}}</el-checkbox>
                                                    <el-checkbox-group v-model="selected" >
                                                        <el-checkbox-group v-model="selected" >
                                                        <el-checkbox style="display:inline;margin: 0px 0px 10px 60px" v-for="item4 in datatable[index1].sub[index2].sub[index3].sub" :label="item4.name" :key="item4" disabled>{{item4.name}}</el-checkbox>
                                                     </el-checkbox-group>
                                                    </el-checkbox-group>
                                                </li>
                                            </ul>
                                        </el-checkbox-group>
                                    </li>
                                </ul>
                            </el-checkbox-group>
                        </ul>
                        <el-divider></el-divider>
                    </li>
                </ul>
            </el-checkbox-group>
        </ul>
        <el-button type="primary" @click="consent()">确定</el-button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            selected: [],
            rolename: '',
            Permission: {
                role: '',
                menus: []
            },
            test: [],
            datatable: [
            ]
        }
    },
    methods: {
        consent() {
            this.Permission.role = this.rolename
            this.Permission.menus = this.selected
		
			console.log(this.Permission)
            this.$axios.post('http://47.112.239.108:8080/webpermission/addpermission',this.Permission,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                this.$alert('分配权限成功', '分配权限', { 
                    confirmButtonText: '确定',
                    callback: action => {
                    }  
                })
            }).catch(err => {
                        this.$confirm('token已经过期了，请点击确定重新登录', '提示', {
                        confirmButtonText: '确定',
                        type: 'warning'
                        }).then(() => {
                        this.$store.commit('LOGIN_OUT')
                        /* 防止切换角色时addRoutes重复添加路由导致出现警告 */
                        window.location.reload()
                        })
	
			}) 
        } 
    },
    created() {
        // alert(this.$route.query.rolename)
        this.rolename = this.$route.query.rolename
        const _this = this
        if(this.rolename==null)
            {   this.$alert('请前往角色管理选择角色', '未选择角色', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                })
                this.$router.replace({
                path: '/designRolemanage/designRolemanage1',
            })}
        this.$axios.get('http://47.112.239.108:8080/webpermission/findAll/' + this.rolename,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
            _this.datatable = res.data
            console.log(_this.datatable)
            for (let i = 0; i < this.datatable.length; ++i) {
                if (this.datatable[i].state == 'checked') {
                    this.selected.push(this.datatable[i].name)
                }
                if (this.datatable[i].sub == null) { continue }
                for (let j = 0; j < this.datatable[i].sub.length; ++j) {
                    if (this.datatable[i].sub[j].state == 'checked') {
                        this.selected.push(this.datatable[i].sub[j].name)
                    }
                    if (this.datatable[i].sub[j].sub == null) { continue }
                    for (var k = 0; k < this.datatable[i].sub[j].sub.length; ++k) {
                        if (this.datatable[i].sub[j].sub[k].state == 'checked') {
                            this.selected.push(this.datatable[i].sub[j].sub[k].name)
                        }
                        if (this.datatable[i].sub[j].sub[k].sub == null) { continue }
                        for (var t = 0; t < this.datatable[i].sub[j].sub[k].sub.length; ++t) {
                        if (this.datatable[i].sub[j].sub[k].sub[t].state == 'checked') {
                            this.selected.push(this.datatable[i].sub[j].sub[k].sub[t].name)
                        }
                        if (this.datatable[i].sub[j].sub[k].sub[t].sub == null) { continue }
                    }
                    }
                }
            }
        }
        ).catch(err => {
                        this.$confirm('token已经过期了，请点击确定重新登录', '提示', {
                        confirmButtonText: '确定',
                        type: 'warning'
                        }).then(() => {
                        this.$store.commit('LOGIN_OUT')
                        /* 防止切换角色时addRoutes重复添加路由导致出现警告 */
                        window.location.reload()
                        })
	
			}) 
    }
}
</script>
