<template lang="html">
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-button
                type="success" icon="el-icon-plus"
                @click="dialogVisible = true">添加班课</el-button>
            <el-input
                v-model="search"
				@input = "change($event)"
                icon="el-icon-plus"
                style="width:130px;height:10px"
                placeholder="输入班课名称"/>
        </div>
        <el-table :data="tableData1.slice((currentPage-1)*pagesize,currentPage*pagesize).filter(data => !search || data.classname.toLowerCase().includes(search.toLowerCase()))"
                  border style="width: 100%">
            <el-table-column  prop="classid" label="班课id" width="100">
            </el-table-column>
            <el-table-column prop="classname" label="课程名称" width="120">
            </el-table-column>
			<el-table-column prop="teacherid" label="教师工号" width="120">
            </el-table-column>
            <el-table-column prop="teachername" label="教师姓名" width="120">
            </el-table-column>
            <el-table-column prop="school" label="所在学校" width="170">
            </el-table-column>
            <el-table-column prop="college" label="所属学院" width="170">
            </el-table-column>
            <el-table-column prop="creattime" label="注册时间" width="200">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button  @click.native.prevent="dialogVisible1 = true,handleEdit(scope.$index, scope.row)" type="text" size="small"
                        >编辑</el-button
                    >
                    <el-button  @click.native.prevent="Getinfo(scope.$index, scope.row)" type="text" size="small"
                    >查看详情</el-button
                    >
                    <el-button
                        @click.native.prevent="
                            deletedata(scope.$index, tableData1)
                        "
                        type="text"
                        size="small"
                        >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10, 20, 40]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="tableData1.length">
        </el-pagination>
        <el-dialog
            title="添加班课"
            :visible.sync="dialogVisible"
            width="60%"
            >
            <el-form ref="ro" :model="dict" label-width="80px">
                <el-form-item label="班课号">
                    <el-input v-model="dict.classid"></el-input>
                </el-form-item>
                <el-form-item label="课程名称">
                    <el-input v-model="dict.classname"></el-input>
                </el-form-item>
                <el-form-item label="教师工号">
                    <el-input v-model="dict.teacherid"></el-input>
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
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="addclass()">确定</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-dialog
            title="编辑班课"
            :visible.sync="dialogVisible1"
            width="60%"
            >
            <el-form ref="ro" :model="dict1" label-width="80px">
                <el-form-item label="班课号">
                    <el-input v-model="dict1.classid"></el-input>
                </el-form-item>
                <el-form-item label="课程名称">
                    <el-input v-model="dict1.classname"></el-input>
                </el-form-item>
                <el-form-item label="选择院校">
                    <div class="block">
                        <el-cascader
                            v-model="value"
                            :options="options"
                            @change="handleChange1"></el-cascader>
                    </div>
                </el-form-item>
                <el-form-item>
                    <el-button @click="dialogVisible1 = false">取消</el-button>
                    <el-button type="primary" @click="editclass()">确定</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

    </el-card>
</template>

<script>
// import { getRoleList, getAllPermissiion } from '@/api/permission'
export default {
    data() {
        return {
            classid1: null,
teacherid1:null,
            dict: {
                classid: '',
                classname: '',
                teacherid: null,
                school: '',
                college: ''
            },
            dict1: {
                classid: '',
                classname: '',
                school: '',
                college: ''
            },
            dialogVisible: false,
            dialogVisible1: false,

            currentPage: 1,
            pagesize: 5,
            // 总条数
            totalCount: 1,
            totalCount1: null,
            PageSize: 1,
            search: '',
            searchData: {
                idnum: '190327105'
            },
			datalen:null,
            tableData1: [],
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
    created: function() {
        console.log('1')
        this.$axios
            .get('http://47.112.239.108:8080/webclass/findAll', {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
            })
            .then(res => {
                console.log(res)
				this.tableData1 = res.data

				this.datalen = res.data.length
				console.log(this.datalen)
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
    methods: {
	change(e){
            this.$forceUpdate()
        },
        handleSizeChange: function (size) {
            this.pagesize = size;
            console.log(this.pagesize)
        },
        handleCurrentChange: function(currentPage){
            this.currentPage = currentPage;
            console.log(this.currentPage)
        },
        handleEdit(index, row) {
            console.log(index, row);
            this.classid1 = row.classid
			this.teacherid1 = row.teacherid
			this.dict1.classid = row.classid
			this.dict1.classname = row.classname
			this.dict1.school = row.school

        },
        handleChange(value) {
            console.log(value)
            this.dict.school = value[0]
            this.dict.college = value[1]
        },
        handleChange1(value) {
            console.log(value)
            this.dict1.school = value[0]
            this.dict1.college = value[1]
        },
       onSearch() {

           },


            //console.log('success')

    editclass(){

        var Class2={
        Class1:{
            classid:Number(this.dict1.classid),
            classname:this.dict1.classname,
            school:this.dict1.school,
            college:this.dict1.college,
			teacherid:this.teacherid1
        },
            oldclassid:this.classid1,

        }
		 console.log(Class2)
        this.$axios
            .post(
                'http://47.112.239.108:8080/webclass/update',
                Class2,
                {
                    headers: {
                        Authorization: localStorage.getItem('token')
                    }
                }
            )
            .then(res => {
			this.$message({
                            type: 'success',
                            message: res.data.message
                        })
                this.$axios
            .get('http://47.112.239.108:8080/webclass/findAll', {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
            })
            .then(res => {
                console.log(res)
				this.tableData1 = res.data
            })
                this.dialogVisible1 = false
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
	Getinfo(index, row) {


            let delid = row.classid
			console.log(delid)
			this.$router.replace({
                path: '/Classtmanage/checkmanage',
                query: {
                    classid: delid
                }
            })

            console.log(index, row)
        },
        addclass() {
            // let classget = {
            //     id: 2020622001,
            //     classname: '中国特色社会主义',
            //     teachername: '张三',
            //     school: '福州大学',
            //     college: '人文学院'
            // }

			console.log(this.dict)
            this.$axios
                .post(
                    'http://47.112.239.108:8080/webclass/adminaddclass',
                    this.dict,
                    {
                        headers: {
                            Authorization: localStorage.getItem('token')
                        }
                    }
                )
                .then(res => {

                        console.log(res)
                        this.$message({
                            type: 'success',
                            message: res.data.message
                        })
                    this.$axios
                        .get('http://47.112.239.108:8080/webclass/findAll', {
                            headers: {
                                Authorization: localStorage.getItem('token')
                            }
                        })
                        .then(res => {
                            console.log(res)
                            this.tableData1 = res.data
                            this.dialogVisible = false
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


            //console.log('success')
        },
        Click() {
            console.log('success')
        },
        deletedata(index, rows) {
            //console.log(this.tableData1)
            console.log(rows[index].id)
			console.log(rows[index].classid)
			let delid = rows[index].classid
            this.$axios
                .post(
                    'http://47.112.239.108:8080/webclass/delete/' + delid,
                  {},
                    {
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded',
                            Authorization: localStorage.getItem('token')
                        }
                    }
                )
                .then(res => {
                    console.log(res.status)
                    this.$message({
                        type: 'success',
                        message: '删除成功'
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
            rows.splice(index, 1)
        }
    }
	}

</script>

<style>
.fr {
    float: right;
}
.fl {
    float: left;
}
.search-bar {
    overflow: hidden;
}
.tools-bar {
    margin-bottom: 20px;
}
</style>
