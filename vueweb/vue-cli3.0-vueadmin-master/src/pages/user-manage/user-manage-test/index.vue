<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
      <el-button
              type="success" icon="el-icon-plus"
              @click="addEdit(scope.$index, scope.row)">添加成员</el-button>
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
              prop="StudentId">
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
              prop="identity">
      </el-table-column>
      <el-table-column
              label="电话"
              prop="phoneNumber">
      </el-table-column>
      <el-table-column
              label="所在学校"
              prop="School">
      </el-table-column>
      <el-table-column
              label="所在学院"
              prop="College">
      </el-table-column>
      <el-table-column
              label="创建时间"
              prop="creatTime">
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
                  @click="handleDelete(scope.$index, scope.row)">权限设置</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>
<script>
export default {
    data() {
        return {
            tableData: [{
                StudentId: '190327064',
                name: '王小虎',
                sex: '男',
                identity: '教师',
                phoneNumber: '1335855555',
                School: '福州大学',
                College: '数学与计算机科学',
                creatTime: '2020-04-20'
            }, {
                StudentId: '190327064',
                name: '王小虎',
                sex: '男',
                identity: '教师',
                phoneNumber: '1335855555',
                School: '福州大学',
                College: '数学与计算机科学',
                creatTime: '2020-04-20'
            }, {
                StudentId: '190327064',
                name: '王小虎',
                sex: '男',
                identity: '教师',
                phoneNumber: '1335855555',
                School: '福州大学',
                College: '数学与计算机科学',
                creatTime: '2020-04-20'
            }, {
                StudentId: '190327064',
                name: '王小虎',
                sex: '男',
                identity: '教师',
                phoneNumber: '1335855555',
                School: '福州大学',
                College: '数学与计算机科学',
                creatTime: '2020-04-20'
            }],
            search: ''
        }
    },
    methods: {
        handleEdit(index, row) {
            console.log(index, row)
        },
        handleDelete(index, row) {
            console.log(index, row)
        },
        addDelete(index, row) {
            console.log(index, row)
        }
    },
    created() {

    }
}
</script>
