<template>
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-button
                type="success" icon="el-icon-plus"
                @click="add()">添加数据</el-button>
            <el-input
                v-model="search"
                icon="el-icon-plus"
                style="width:130px;height:10px"
                placeholder="输入关键字搜索"/>
        </div>
        <el-table
            :data="tableData.filter(data => !search || data.keyd.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
                label="序号"
                prop="id">
            </el-table-column>
            <el-table-column
                label="类型"
                prop="typed">
            </el-table-column>
            <el-table-column
                label="关键字"
                prop="keyd">
            </el-table-column>
            <el-table-column
                label="值"
                prop="valued">
            </el-table-column>
            <el-table-column
                label="是否为默认值"
                prop="defaultvalued">
            </el-table-column>
            <el-table-column
                align="right">
                <template slot="header" slot-scope="scope">
                </template>
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                        size="mini"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
            title="添加数据"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="ro" :model="adddata" label-width="80px">

                <el-form-item label="类型">
                    <el-input v-model="adddata.typed" disabled=""></el-input>
                </el-form-item>
                <el-form-item label="关键字">
                    <el-input v-model="adddata.keyd"></el-input>
                </el-form-item>
                <el-form-item label="值">
                    <el-input v-model="adddata.valued"></el-input>
                </el-form-item>
                <el-form-item label="是否为默认值">
                    <el-input v-model="adddata.defaultvalued"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit()">确定</el-button>
                    <el-button @click="dialogVisible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <el-dialog
            title="编辑数据"
            :visible.sync="dialogVisible1"
            width="60%"
            :before-close="handleClose">
            <el-form ref="ro" :model="adddata" label-width="80px">
                <el-form-item label="类型">
                    <el-input v-model="adddata.typed" disabled></el-input>
                </el-form-item>
                <el-form-item label="关键字">
                    <el-input v-model="adddata.keyd"></el-input>
                </el-form-item>
                <el-form-item label="值">
                    <el-input v-model="adddata.valued"></el-input>
                </el-form-item>
                <el-form-item label="是否为默认值">
                    <el-input v-model="adddata.defaultvalued"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="edit()">确定</el-button>
                    <el-button @click="dialogVisible1=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>
</template>
<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                dialogVisible1: false,
                typed: '',
                record: {
                    valued: '',
                    typed:''
                },
                Data:{
                    dicd: {
                        typed: '性别',
                        keyd: 'male',
                        valued: '男',
                        defaultvalued: 0
                    },
                    record:''
                },
                dicd: {
                    typed: '性别',
                    keyd: 'male',
                    valued: '男',
                    defaultvalued: 0
                },
                adddata: {
                    typed: '性别',
                    keyd: 'male',
                    valued: '男',
                    defaultvalued: 0
                },
                tableData: [],
                search: '',
                temp:{
                    keyd:'',
                    valued:'',
                    defaultvalued:''
                }
            }
        },
        methods: {
            handleEdit(index, row) {
                this.record.valued = row.valued
                this.record.typed = row.typed
                this.adddata = row
                console.log(this.adddata)
                this.dialogVisible1 = true
            },
            add(){
                this.dialogVisible = true
                this.adddata.typed = this.typed,
                    this.adddata.keyd = this.temp.keyd,
                    this.adddata.valued = this.temp.valued,
                    this.adddata.defaultvalued = this.temp.defaultvalued
            },
            edit() {
                // this.dicd = this.adddata
                console.log(this.adddata)
                const _this = this
                this.dicd.valued = this.adddata.valued
                this.dicd.keyd = this.adddata.keyd
                this.dicd.defaultvalued = this.adddata.defaultvalued
                this.dicd.typed = this.adddata.typed
                this.Data.dicd = this.dicd
                this.Data.record = this.record
                console.log(this.Data)
                this.$axios.post('http://47.112.239.108:8080/webdictionary/updatedata', this.Data,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                    _this.$axios.get('http://47.112.239.108:8080/webdictionary/finddata/' +_this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                        _this.$alert('编辑数据成功', '编辑数据', {
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
                })
                this.dialogVisible1 = false

            },
            handleDelete(index, row) {
                this.dicd.typed = row.typed
                this.dicd.defaultvalued = row.defaultvalued
                this.dicd.keyd = row.keyd
                this.dicd.valued = row.valued
                const _this = this
                console.log(this.dicd)
                this.$axios.post('http://47.112.239.108:8080/webdictionary/deletedata', this.dicd,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                    console.log(resp)
                    _this.$axios.get('http://47.112.239.108:8080/webdictionary/finddata/' + _this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                        _this.$alert('删除数据成功', '删除数据', {
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
            addDelete(index, row) {
                console.log(index, row)
            },
            onSubmit() {
                this.dialogVisible = false
                const _this = this
                // eslint-disable-next-line no-unused-vars
                this.dicd.typed = this.adddata.typed
                this.dicd.defaultvalued = this.adddata.defaultvalued
                this.dicd.keyd = this.adddata.keyd
                this.dicd.valued = this.adddata.valued
                console.log(this.dicd)
                this.$axios.post('http://47.112.239.108:8080/webdictionary/adddata', this.dicd,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                    console.log(resp)
                    _this.$axios.get('http://47.112.239.108:8080/webdictionary/finddata/' + _this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                        _this.$alert('新增数据成功', '新增数据', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        })
                    })
                })

            }
        },
        created() {
            this.dicd.typed = this.$route.query.dicd
            const _this = this
            this.typed = this.dicd.typed
            if(this.typed==null)
            {   this.$alert('请前往类型管理选择参数名称', '未选择参数', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                })
                this.$router.replace({
                path: '/Datadictionary/typemanage',
            })}
            this.$axios.get('http://47.112.239.108:8080/webdictionary/finddata/' + this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                _this.tableData = resp.data
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
