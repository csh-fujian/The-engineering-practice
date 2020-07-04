<template lang="html">
    <el-card class="box-card">
        <div style="display: block;font-size:10px;">
            <el-tag>当前班课id:{{classid}}</el-tag>
            <el-input
                v-model="search"
				@input = "change($event)"
                icon="el-icon-plus"
                style="width:130px;height:10px"
                placeholder="输入学生姓名"
            />
        </div>
        <el-table
            :data="
                tableData.filter(
                    data =>
                        !search ||
                        data.studentname
                            .toLowerCase()
                            .includes(search.toLowerCase())
                )
            "
            border
            style="width: 100%"
        >
            <el-table-column prop="studentid" label="学生id" width="100">
            </el-table-column>
            <el-table-column prop="studentname" label="学生姓名" width="120">
            </el-table-column>
            <el-table-column prop="classname" label="课程名" width="120">
            </el-table-column>
            <el-table-column prop="teachername" label="教师姓名" width="120">
            </el-table-column>
            <el-table-column prop="experience" label="经验值" width="170">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button
                        @click.native.prevent="
                            deletedata(scope.$index, tableData)
                        "
                        type="text"
                        size="small"
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
            classid: null,
            classid1: null,
            teacherid1: null,
            tableData: []
        }
    },
    created: function() {
		console.log("2")
        this.classid = this.$route.query.classid
		console.log(this.classid)
		if(this.classid == null){
		this.$message({
                        type: 'warning',
                        message: '未获取班课id,请从班课管理页面点击“查看详情”获取班课成员信息。'
                    })
		this.$router.replace({
                path: '/Classtmanage/Viewclasslist',
            })
		
		}
        this.$axios
            .get('http://47.112.239.108:8080/webcourse/find/'+this.classid, {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
            })
            .then(res => {
                console.log(res)
                this.tableData = res.data
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
        deletedata(index, rows) {
            //console.log(this.tableData1)

            console.log(rows[index].classid)
            let delid = rows[index].classid

            let coursemember = {
                classid:rows[index].classid,
                studentid:rows[index].studentid
            }

            this.$axios
                .post(
                    'http://47.112.239.108:8080/webcourse/delete',
                    coursemember,
                    {
                        headers: {
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
