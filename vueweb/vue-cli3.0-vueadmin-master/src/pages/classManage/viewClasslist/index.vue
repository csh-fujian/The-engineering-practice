<template lang="html">
    <el-card class="box-card">
        <div class="search-bar">
            <el-form :inline="true" :model="searchData" class="fl">
                <el-input style="display: none;"></el-input>
                <el-form-item label="班课ID：">
                    <el-input
                        v-model="searchData.idnum"
                        placeholder="请输入班课ID"
                        @keyup.enter.native="onSearch"
                    ></el-input>
                </el-form-item>
            </el-form>
            <div class="fl">
                <el-button
                    type="primary"
                    icon="el-icon-search"
                    @click="onSearch"
                    >查询</el-button
                >
            </div>
            <el-button
                type="success"
                icon="el-icon-plus"
                style="margin:0px 0px 0px 30px"
                @click="addclass"
                >新增班课</el-button
            >
        </div>
        <el-table :data="tableData1" border style="width: 100%">
            <el-table-column fixed prop="id" label="班课id" width="150">
            </el-table-column>
            <el-table-column prop="name" label="课程名称" width="120">
            </el-table-column>
            <el-table-column prop="province" label="教师姓名" width="120">
            </el-table-column>
            <el-table-column prop="city" label="所在学校" width="170">
            </el-table-column>
            <el-table-column prop="address" label="所属学院" width="250">
            </el-table-column>
            <el-table-column prop="zip" label="注册时间" width="150">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="Click" type="text" size="small"
                        >查看</el-button
                    >
                    <el-button @click.native.prevent="deletedata(scope.$index, tableData1)" type="text" size="small"
                        >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
    </el-card>
</template>

<script>
// import { getRoleList, getAllPermissiion } from '@/api/permission'
export default {

    data() {
        return {
            currentPage: 1,
            // 总条数
            totalCount: 1,
            totalCount1: null,
            PageSize: 1,
            searchData: {
                idnum: '190327105'
            },
            tableData1: []
        }
    },
    created: function() {
        this.$axios
            .get(
                'http://localhost:8080/webclass/findAll',
                {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        Authorization: localStorage.getItem('token')
                    }
                }
            )
            .then(res => {
               console.log(res.classLesson)
            })
        this.tableData1 = [
            {
                id: '2016-05-02',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            },
            {
                id: '2016-05-04',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1517 弄',
                zip: 200333
            },
            {
                id: '2016-05-01',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1519 弄',
                zip: 200333
            },
            {
                id: '2016-05-03',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1516 弄',
                zip: 200333
            },
            {
                id: '2016',
                name: '王',
                province: '上',
                city: '普',
                address: '上',
                zip: 200333
            }
        ]
    },
    methods: {

        onSearch() {
            console.log('success')
        },
        addclass() {
            let class ={
                id: 2020622001,
                classname: '中国特色社会主义',
                teachername: '奥观海',
                school: '福州大学',
                college: '人文学院',
        }
            this.$axios
                .post(
                    'http://localhost:8080/webclass/adminaddclass',
                    class,
                    {
                        headers: {
                            'Content-Type':
                                'application/x-www-form-urlencoded',
                            Authorization: localStorage.getItem('token')
                        }
                    }
                )
                .then(res => {
                    console.log(res)
                    console.log(res.message)
                    this.$message({
                        type: 'success',
                        message: '修改成功'
                    })
                })



            console.log('success')
        },
        Click() {
            console.log('success')
        },
        deletedata(index, rows) {
            console.log(this.tableData1)
            console.log(rows[index].id)
            this.$axios
                .get(
                    'http://localhost:8080/webclass/delete/' + rows[index].id,
                    {},
                    {
                        headers: {
                            'Content-Type':
                                'application/x-www-form-urlencoded',
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
            rows.splice(index, 1);
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
