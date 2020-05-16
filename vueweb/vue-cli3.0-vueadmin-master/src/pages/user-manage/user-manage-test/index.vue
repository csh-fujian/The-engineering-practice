<template>
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
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
            title="新增用户"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="ro" :model="user" label-width="80px">
                <el-form-item label="学号">
                    <el-input v-model="user.number"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="user.name"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="user.sex"></el-input>
                </el-form-item>
                <el-form-item label="身份">
                    <el-input v-model="user.role"></el-input>
                </el-form-item>
                <el-form-item label="电话号码">
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
                    <el-button type="primary" @click="onSubmit()">确定</el-button>
                    <el-button @click="dialogVisible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <el-dialog
            title="编辑用户"
            :visible.sync="dialogVisible2"
            width="60%"
            :before-close="handleClose">
            <el-form ref="ro" :model="user" label-width="80px">
                <el-form-item label="学号">
                    <el-input v-model="user.number"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="user.name"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="user.sex"></el-input>
                </el-form-item>
                <el-form-item label="身份">
                    <el-input v-model="user.role"></el-input>
                </el-form-item>
                <el-form-item label="电话号码">
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
                    <el-button type="primary" @click="edit()">确定</el-button>
                    <el-button @click="dialogVisible2 = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </el-card>

</template>
<script>
    export default {
        // 完成：新增用户、搜索、删除
        // 未完成：编辑、权限设置
        data() {
            return {
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
                    number: '190327064111',
                    name: '王小虎',
                    sex: '男',
                    role: '教师',
                    phone: '1335855555',
                    school: '福州大学',
                    department: '数学与计算机科学'
                }],
                search: '',
                value: [],
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
            handleEdit(index, row) {
                this.editUser.oldnumber = row.number
                this.user = row
                this.dialogVisible2 = true
                console.log(index, row)
            },
            adduser() {
                this.dialogVisible = true
                this.user = []
                // this.user.department='数学与计算机科学学院'
                // this.user.school='福州大学'
            },
            handleChange(value) {
                console.log(value)
                this.user.school = value[0]
                this.user.department = value[1]
            },
            edit() {
                console.log(this.user)
                this.dialogVisible2 = false
                this.editUser.user = this.user
                console.log(this.editUser)
                this.$axios.post('http://localhost:8080/webuser/updateuser/' ,this.editUser).then(function(resp) {
                })
            },
            handleDelete(index, row) {
                console.log(this.user)
                this.user = row
                this.$axios.post('http://localhost:8080/webuser/deleteuser', this.user).then(function(resp) {
                    _this.$axios.get('http://localhost:8080/webuser/finduser').then(function(resp) {
                        _this.tableData = resp.data
                        console.log(_this.tableData)
                        // alert(321)
                        // 这个url要改下
                    })
                })
                const _this = this

            },
            addDelete(index, row) {
                console.log(index, row)
            },
            doAdd(index, row) {
                this.dialogVisible = false
            },
            onSubmit() {
                this.dialogVisible = false
                const _this = this
                this.userinfo.number = this.user.number
                this.userinfo.name = this.user.name
                this.userinfo.sex = this.user.sex
                this.userinfo.role = this.user.role
                this.userinfo.phone = this.user.phone
                this.userinfo.school = this.user.school
                this.userinfo.department = this.user.department
                console.log(this.userinfo)
                this.$axios.post('http://localhost:8080/webuser/adduser', this.userinfo).then(function(resp) {
                    _this.$axios.get('http://localhost:8080/webuser/finduser').then(function(resp) {
                        _this.tableData = resp.data
                    })
                })

                // this.user = []
            },
            handle() {
            }
        },
        created() {
            const _this = this
            this.$axios.get('http://localhost:8080/webuser/finduser').then(function(resp) {
                _this.tableData = resp.data
                console.log(_this.tableData)
                // alert(321)
                // 这个url要改下
            })
        }
    }
</script>
