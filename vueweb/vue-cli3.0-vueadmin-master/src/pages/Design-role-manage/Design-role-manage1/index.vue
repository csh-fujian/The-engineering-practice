<template  lang="html">
    <el-card class="box-card">
        <div class="fl">
            <el-button type="success" icon="el-icon-plus" @click="dialogVisible = true">新增角色</el-button>
        </div>
        <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
                label="序号"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="角色"
                width="180">
                <template slot-scope="scope">
                    <div slot="reference" class="name-wrapper">
                        <el-tag size="medium">{{ scope.row.name }}</el-tag>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">授予权限</el-button>
                    <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column >
        </el-table>
        <el-pagination
            small
            layout="prev, pager, next"
            :page-size="pageSize"
            :total="total"
            @current-change="page"
        >
        </el-pagination>
        <el-dialog
            title="新增角色"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="ro" :model="form" label-width="80px">
                <el-form-item label="角色">
                    <el-input v-model="ro.name"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit()">确定</el-button>
                    <el-button @click="dialogVisible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>
</template>

<script >
export default {
    data() {
        return {
            pageSize: '3',
            total: '100',
            name: '',
            rol: {
                name: '',
                id: 0
            },
            ro: {
                id: 1,
                name: ''
            },
            tableData: [],
            dialogVisible: false
        }
    },
    methods: {
        // 完成：新增 删除
        // 未完成：跳转的时候要带对象过去
        doAdd() {
            alert(this.addData.name)
            this.dialogVisible = false
        },
        onSubmit() {
            console.log(this.ro)
            this.dialogVisible = false
            const _this = this
            this.$axios.post('http://47.112.239.108:8080/webrole/addrole', this.ro,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                console.log(_this.ro)
                _this.$axios.get('http://47.112.239.108:8080/webrole/findrole',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                    _this.tableData = resp.data
                    _this.$alert('新增角色成功', '新增角色', {
                        confirmButtonText: '确定',
                        callback: action => {
                        }
                    })
                    // alert(321)
                })
            })

            // this.addform.Id = ''
            // this.addform.name = ''
        },
        handleEdit(index, row) {
            // 这边要传数据  还没写
            this.rolename = row.name
            this.$router.replace({
                path: '/Perminssioninformanage/Perminssionlist',
                query: {
                    rolename: row.name
                }
            })
            // console.log(index, row)
        },
        handleDelete(index, row) {
            this.rol.name = row.name
            this.rol.id = row.id
            const _this = this
            console.log(this.rol)
            this.$axios.post('http://47.112.239.108:8080/webrole/deleterole', this.rol,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                // console.log(resp)
                _this.$axios.get('http://47.112.239.108:8080/webrole/findrole',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                    _this.tableData = resp.data
                    // alert(321)
                    _this.$alert('删除角色成功', '删除角色', {
                        confirmButtonText: '确定',
                        callback: action => {
                        }
                    })
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

        },
        addUser(index, row) {
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done()
                })
                .catch(_ => {})
        }
    },
    created() {
        const _this = this
        this.$axios.get('http://47.112.239.108:8080/webrole/findrole',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
            _this.tableData = resp.data
            // alert(321)
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
}
</script>
