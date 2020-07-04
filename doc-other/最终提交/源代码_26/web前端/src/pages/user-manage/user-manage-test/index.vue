<template>
<div>
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-button type="success" icon="el-icon-plus" @click="adduser()">新增用户</el-button>
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
                label="学号"
                prop="number">
            </el-table-column>
            <el-table-column
                label="姓名"
                prop="name">
            </el-table-column>
			<el-table-column
                label="昵称"
                prop="nickname">
            </el-table-column>
            <el-table-column
                label="性别"
                prop="sex">
            </el-table-column>
            <el-table-column
                label="身份"
                prop="role">
            </el-table-column>
            <el-table-column
                label="电话"
                prop="phone">
            </el-table-column>
            <el-table-column
                label="所在学校"
                prop="school">
            </el-table-column>
            <el-table-column
                label="所在学院"
                prop="department">
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
					<el-button 
                        size="mini"
                        @click="Initialization(scope.$index, scope.row)">重置密码</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
            title="新增用户"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="user" :model="user" label-width="80px" :rules="rules">
                <el-form-item label="学号">
                    <el-input v-model="user.number"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="user.name"></el-input>
                </el-form-item>
				 <el-form-item label="昵称">
                    <el-input v-model="user.nickname"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <div class="block">
                        <el-cascader 
                            v-model="user.sex"
                            :options="options1"
                            :placeholder="user.sex"
                            @change="handleChange"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item label="身份">
                <div class="block">
                        <el-cascader
                            v-model="user.role"
                            :options="options2"
                            :placeholder="user.role"
                            @change="handleChange"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item label="电话号码" prop="phone">
                    <el-input v-model="user.phone"></el-input>
                </el-form-item>
                <el-form-item label="选择院校">
                    <div class="block">
                        <el-cascader
                            v-model="value"
                            :options="options"
                            @change="handleChange"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit('user')">确定</el-button>
                    <el-button @click="dialogVisible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <el-dialog
            title="编辑用户"
            :visible.sync="dialogVisible2"
            width="60%"
            :before-close="handleClose" >
            <el-form ref="user" :model="user" label-width="80px" :rules="rules" >
                <el-form-item label="学号">
                    <el-input v-model="user.number"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="user.name"></el-input>
                </el-form-item>
				<el-form-item label="昵称">
                    <el-input v-model="user.nickname"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <div class="block">
                        <el-cascader 
                            v-model="user.sex"
                            :options="options1"
                            :placeholder="user.sex"
                            @change="handleChange1"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item label="身份">
                        <el-cascader
                            v-model="user.role"
                            :options="options2"
                            :placeholder="user.role"
                            @change="handleChange2"></el-cascader>
                </el-form-item>
               <el-form-item label="电话号码" prop="phone">
                    <el-input v-model="user.phone"></el-input>
                </el-form-item>
                <el-form-item label="选择院校">
                    <div class="block">
                        <el-cascader
                            v-model="value"
                            :options="options"
							:placeholder="temp"
                            @change="handleChange"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="edit('user')">确定</el-button>
                    <el-button @click="dialogVisible2 = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>
<el-pagination
  background
  layout="prev, pager, next"
  page-size="8"
  :total="total"
  @current-change="pagetemp"
  >
</el-pagination>
</div>
</template>
<script>
    export default {
			data() {
			var checkphone = (rule, value, callback) => {
				if (value.length!=11) {
				  return callback(new Error('手机号码应该为11位'));
				}else{
					callback();
				}
			};
            return {
			rules: {
			  phone: [
				{ validator: checkphone, trigger: 'blur' }
				  ]
				}, 
				typed:'',
				temp:'福建师范大学/音乐学院',
                total:null,
				pageNum:null,
                page:{
                    pageNum:1,
                    pageSize:6
                },
                dialogVisible: false,
                dialogVisible2: false,
                user: {
                    number: '190327064111',
                    name: '王小虎',
                    sex: '男',
                    role: '教师',
                    phone: '1335855555',
                    school: '福州大学',
                    department: '数学与计算机科学'
                },
                dicd: {
                    typed:''
                },
                userinfo: {
                    number: '190327064111',
                    name: '王小虎',
                    sex: '男',
                    role: '教师',
                    phone: '1335855555',
                    school: '福州大学',
                    department: '数学与计算机科学'
                },
                editUser: {
                    user: {
                        number: '190327064111',
                        name: '王小虎',
                        sex: '男',
                        role: '教师',
                        phone: '1335855555',
                        school: '福州大学',
                        department: '数学与计算机科学'
                    },
                    oldnumber:''
                },
                tableData: [{

                }],
                search: '',
                value: ['',''],
                options1: [{
                    label: '男',
					value:'男'
                }, {
                    label: '女',
					value:'女'
                }],
                options2: [{
                    label: '教师',
					value:'教师'
                }, {
                    label: '学生',
					value:'学生'
                }],
                options: [{
                    value: '福州大学',
                    label: '福州大学',
                    children: [{
                        value: '数学与计算机科学学院',
                        label: '数学与计算机科学学院'
                    }, {
                        value: '经济与管理学院',
                        label: '经济与管理学院'
                    }]
                }, {
                    value: '福建师范大学',
                    label: '福建师范大学',
                    children: [{
                        value: '软件学院',
                        label: '软件学院'
                    }, {
                        value: '音乐学院',
                        label: '音乐学院'
                    }]
                }, {
                    value: '厦门大学',
                    label: '厦门大学',
                    children: [{
                        value: '国际关系学院',
                        label: '国际关系学院'
                    }, {
                        value: '管理学院',
                        label: '管理学院'
                    }]
                }]
            }
        },
        methods: {
			Initialization(index, row){
				const _this = this 
				this.$axios.post('http://47.112.239.108:8080/webuser/setpassword/'+row.number,{},{
									headers: {
										Authorization: localStorage.getItem('token')
									}
								}).then(function(resp) {
						_this.$alert('初始化数据成功', '初始化数据', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        })	
					}).catch(err => {
				alert(1)
			})
			},
			handleChange1(){
				
			},
            pagetemp(currentPage){
				const _this = this
				this.pageNum = currentPage
				this.$axios.get('http://47.112.239.108:8080/webuser/pagefind/'+this.pageNum,{
									headers: {
										Authorization: localStorage.getItem('token')
									}
								}).then(function(resp) {
					_this.tableData = resp.data
				})    
            }, 
            handleEdit(index, row) {
                this.editUser.oldnumber = row.number
                this.user = row
				console.log(this.user)
				this.temp=row.school+'/'+row.department
				
                const _this=this
                this.dicd.typed='sex'
				this.typed='sexy'
				console.log(this.typed)
				this.$axios.get('http://47.112.239.108:8080/webdictionary/findAllvalued2/' + this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							_this.options1=resp.data
							_this.typed='role'
							_this.$axios.get('http://47.112.239.108:8080/webdictionary/findAllvalued2/' + _this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							console.log(resp.data)
							_this.options2=resp.data
							_this.dialogVisible2 = true
                       
                    })  
                    }).catch(err => {
				alert(1)
			}) 
            },
            adduser(user) {

                this.user = [] 
				this.value=[]
                const _this=this  
                this.typed='sexy'
                this.$axios.get('http://47.112.239.108:8080/webdictionary/getdefault/'+this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							_this.user.sex=resp.data

							_this.typed='role'
							_this.$axios.get('http://47.112.239.108:8080/webdictionary/getdefault/'+_this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							_this.user.role=resp.data
							_this.dialogVisible = true
							_this.typed='sexy'
							_this.$axios.get('http://47.112.239.108:8080/webdictionary/findAllvalued2/' + _this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							_this.options1=resp.data
							_this.typed='role'
							
							_this.$axios.get('http://47.112.239.108:8080/webdictionary/findAllvalued2/' + _this.typed,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
							console.log(resp.data)
							_this.options2=resp.data
                       
                    }) 
                    }) 
                })
                }).catch(err => {
				alert(1)
			})
            },
            handleChange(value) {
                console.log(value)
				
                this.user.school = value[0]
                this.user.department = value[1]
            },
            edit(user) {
				const _this = this
				this.$refs[user].validate((valid) => {
				if (valid) {
                this.dialogVisible2 = false
                this.editUser.user = this.user
                console.log(this.editUser)
				const _this = this
				this.editUser.school=this.user.scholl
				this.editUser.department=this.user.department
                this.$axios.post('http://47.112.239.108:8080/webuser/updateuser/' ,this.editUser,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
						_this.$message({
                            type: 'success',
                            message: resp.data
                        })
					_this.$axios.get('http://47.112.239.108:8080/webuser/pagefind/'+_this.pageNum,{
                                headers: {

                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                    }).catch(err => {
                    alert(1)
                    })
                })}else{
					console.log('error submit!!'); 
				  }
				})
            },
            handleDelete(index, row) {
                console.log(this.user)
                this.user = row
                this.$axios.post('http://47.112.239.108:8080/webuser/deleteuser', this.user,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
						_this.$message({
                            type: 'success',
                            message: resp.data
                        })
                    _this.$axios.get('http://47.112.239.108:8080/webuser/pagefind/'+_this.pageNum,{
                                headers: {

                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
                        console.log(_this.tableData)

                        // alert(321)
                        // 这个url要改下
                    })
                }).catch(err => {
				alert(1)
			})
                const _this = this
            },
            addDelete(index, row) {
                console.log(index, row)
            },
            doAdd(index, row) {
                this.dialogVisible = false
            },
            onSubmit(user) {
				const _this = this
				this.$refs[user].validate((valid) => {
				if (valid) {
				this.dialogVisible = false
                this.userinfo.number = this.user.number
                this.userinfo.name = this.user.name
                this.userinfo.sex = this.user.sex
                this.userinfo.role = this.user.role
                this.userinfo.phone = this.user.phone
                this.userinfo.school = this.user.school
                this.userinfo.department = this.user.department
				this.userinfo.nickname=this.user.nickname
                console.log(this.userinfo)
                this.$axios.post('http://47.112.239.108:8080/webuser/adduser', this.userinfo,{
                                headers: {

                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
					_this.$message({
                            type: 'success',
                            message: resp.data
                     })
					 _this.$axios.get('http://47.112.239.108:8080/webuser/totalSize/',{
					headers: {
							Authorization: localStorage.getItem('token')
					}
					}).then(function(resp) {
					_this.total = resp.data
					 _this.$axios.get('http://47.112.239.108:8080/webuser/pagefind/'+_this.pageNum,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(function(resp) {
                        _this.tableData = resp.data
						
                    }) 
				})   

                }).catch(err => {
				alert(1)
			})
					console.log('success');
				  } else {
					console.log('error submit!!'); 
				  }
				})


                // this.user = []
            },
            handle() {
            }
        },
        created() {
            const _this = this
            this.$axios.get('http://47.112.239.108:8080/webuser/totalSize/',{
					headers: {
							Authorization: localStorage.getItem('token')
					}
					}).then(function(resp) {
					_this.total = resp.data
				})    
			this.pageNum=1
				this.$axios.get('http://47.112.239.108:8080/webuser/pagefind/'+this.pageNum,{
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
