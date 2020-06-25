<template lang="html">
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-button
                type="success" icon="el-icon-plus"
                @click="dialogVisible = true">添加班课</el-button>
            <el-input
                v-model="search"
                icon="el-icon-plus"
                style="width:130px;height:10px"
                placeholder="输入班课名称"/>
        </div>
        <el-table :data="tableData1.filter(data => !search || data.classname.toLowerCase().includes(search.toLowerCase()))"
                  border style="width: 100%">
            <el-table-column  prop="classid" label="班课id" width="100">
            </el-table-column>
            <el-table-column prop="classname" label="课程名称" width="120">
            </el-table-column>
            <el-table-column prop="teachername" label="教师姓名" width="120">
            </el-table-column>
            <el-table-column prop="school" label="所在学校" width="170">
            </el-table-column>
            <el-table-column prop="college" label="所属学院" width="170">
            </el-table-column>
            <el-table-column prop="classtime" label="注册时间" width="200">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button  @click="dialogVisible1 = true" type="text" size="small"
                        >编辑</el-button
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
                <el-form-item label="任课老师">
                    <el-input v-model="dict.teachername"></el-input>
                </el-form-item>
                <el-form-item label="所属大学">
                    <el-input v-model="dict.school"></el-input>
                </el-form-item>
                <el-form-item label="所属学院">
                    <el-input v-model="dict.college"></el-input>
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
                <el-form-item label="所属大学">
                    <el-input v-model="dict1.school"></el-input>
                </el-form-item>
                <el-form-item label="所属学院">
                    <el-input v-model="dict1.college"></el-input>
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
            dict: {
                classid: '',
                classname: '',
                teachername: '',
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
            // 总条数
            totalCount: 1,
            totalCount1: null,
            PageSize: 1,
            search: '',
            searchData: {
                idnum: '190327105'
            },
			datalen:null,
            tableData1: []
        }
    },
    created: function() {
        console.log('1')
        this.$axios
            .get('http://localhost:8080/webclass/findAll', {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
            })
            .then(res => {
                console.log(res)
				this.tableData1 = res.data

				this.datalen = res.data.length
				console.log(this.datalen)
            })

    },
    methods: {
       onSearch() {

           },


            //console.log('success')

    editclass(){
        this.$axios
            .post(
                'http://localhost:8080/webclass/update',
                this.dict1,
                {
                    headers: {
                        Authorization: localStorage.getItem('token')
                    }
                }
            )
            .then(res => {
                this.$axios
            .get('http://localhost:8080/webclass/findAll', {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
            })
            .then(res => {
                console.log(res)
				this.tableData1 = res.data
            })
                this.dialogVisible1 = false
            })


    },
        addclass() {
            // let classget = {
            //     id: 2020622001,
            //     classname: '中国特色社会主义',
            //     teachername: '张三',
            //     school: '福州大学',
            //     college: '人文学院'
            // }
            this.$axios
                .post(
                    'http://localhost:8080/webclass/adminaddclass',
                    this.dict,
                    {
                        headers: {
                            Authorization: localStorage.getItem('token')
                        }
                    }
                )
                .then(res => {
                    if(res.flag != null){
                        console.log(res)
                        console.log(res.message)
                        this.$message({
                            type: 'success',
                            message: res.message
                        })
                        this.tableData1.push(this.dict)
                        this.dialogVisible = false
                    }else{
                        this.$message({
                            type: 'success',
                            message: res.message
                        })
                        this.dialogVisible = false
                    }

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
                    'http://localhost:8080/webclass/delete/' + delid,
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
