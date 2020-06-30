<template>
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-button type="success" icon="el-icon-plus" @click="addManagement()">新增管理员</el-button>
            <el-input
                v-model="search"
                icon="el-icon-plus"
                style="width:130px;height:10px"
                placeholder="输入名字搜索"/>
        </div>
        <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
                label="id"
                prop="id">
            </el-table-column>
            <el-table-column
                label="姓名"
                prop="name">
            </el-table-column>
            <el-table-column
                label="手机"
                prop="phone">
            </el-table-column>
            <el-table-column
                align="right">
                <template slot="header" slot-scope="scope">
                </template>
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
                        <el-table-column
                align="right">
                <template slot="header" slot-scope="scope">
                </template>
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="Initialization(scope.$index, scope.row)">重置密码</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
            title="新增用户"
            :visible.sync="dialogVisible"
            width="25%"
            >
            <el-form ref="ro" :model="Management" label-width="80px">
                <el-form-item label="id">
                    <el-input v-model="Management.id"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="Management.name"></el-input>
                </el-form-item>
                <el-form-item label="手机号">
                    <el-input v-model="Management.phone"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit()">确定</el-button>
                    <el-button @click="dialogVisible=false">取消</el-button>
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
                dialogVisible2: false,
                Admin:{
                    name:'',
                    phone:''
                },
                Management: {
                    id: '190327064111',
                    name: '王小虎',
                    phone:''
                },
                userinfo: {
                    id: '190327064111',
                    name: '王小虎',
                    phone:''
                },
                tableData: [],
                search: '',
                value: [],
            }
        },
        methods: {
            addManagement() {
                this.dialogVisible = true
                this.Management.id=''
                this.Management.name=''
                this.Management.phone=''
            },
            handleChange(value) {
                console.log(value)
                this.user.school = value[0]
                this.user.department = value[1]
            },
            handleDelete(index, row) {
                this.Management = row
                const _this = this
				console.log(this.Management.name)
                this.$axios.post('http://47.112.239.108:8080/webadmin/delete/'+this.Management.name,{},{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
						_this.$alert('删除数据成功', '删除数据', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        })	
                    _this.$axios.get('http://47.112.239.108:8080/webadmin/getAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                    })
                })
            },
            addDelete(index, row) {
                console.log(index, row)
            },
            Initialization(index, row) {
				const _this = this 
				this.$axios.post('http://47.112.239.108:8080/webadmin/defaultadmin/'+row.name,{},{
									headers: {
										Authorization: localStorage.getItem('token')
									}
								}).then(function(resp) {
						_this.$alert('初始化数据成功', '初始化数据', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        })	
					})
            },
            doAdd(index, row) {
                this.dialogVisible = false
            },
            onSubmit() {
                this.dialogVisible = false
                console.log(this.Management.name) 
                this.Admin.name=this.Management.name
                this.Admin.phone=this.Management.phone
                const _this=this
                this.$axios.post('http://47.112.239.108:8080/webadmin/addadmin/',this.Admin,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
					_this.$message({
                            type: 'success',
                            message: resp.data
                        })		
                    _this.$axios.get('http://47.112.239.108:8080/webadmin/getAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data

                    })
                })
            },
            handle() {
            }
        },
        created() {
            const _this = this
            this.$axios.get('http://47.112.239.108:8080/webadmin/getAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                _this.tableData = resp.data
            })
        }
    }
</script>
