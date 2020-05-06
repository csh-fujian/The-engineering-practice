<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
        <el-button type="success" icon="el-icon-plus" @click="dialogVisible = true">新增用户</el-button>
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
      <el-dialog
          title="新增用户"
          :visible.sync="dialogVisible"
          width="60%"
          :before-close="handleClose">
          <el-form ref="ro" :model="addData" label-width="80px">
              <el-form-item label="学号">
                  <el-input v-model="addData.StudentId"></el-input>
              </el-form-item>
              <el-form-item label="姓名">
                  <el-input v-model="addData.name"></el-input>
              </el-form-item>
              <el-form-item label="性别">
                  <el-input v-model="addData.sex"></el-input>
              </el-form-item>
              <el-form-item label="身份">
                  <el-input v-model="addData.identity"></el-input>
              </el-form-item>
              <el-form-item label="电话号码">
                  <el-input v-model="addData.phoneNumber"></el-input>
              </el-form-item>
              <el-form-item label="学校">
                  <el-input v-model="addData.School"></el-input>
              </el-form-item>
              <el-form-item label="学院">
                  <el-input v-model="addData.College"></el-input>
              </el-form-item>
              <el-form-item label="创建时间">
                  <el-input v-model="addData.creatTime"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="onSubmit()">确定</el-button>
                  <el-button>取消</el-button>
              </el-form-item>
          </el-form>
      </el-dialog>
  </el-card>

</template>
<script>
export default {
    //完成：新增用户、搜索、删除
    //未完成：编辑、权限设置
    data() {
        return {
            dialogVisible: false,
            dialogVisible2: false,
            addData: {
                StudentId: '190327064',
                name: '王小虎',
                sex: '男',
                identity: '教师',
                phoneNumber: '1335855555',
                School: '福州大学',
                College: '数学与计算机科学',
                creatTime: '2020-04-20'
            },
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
            alert(this.tableData.StudentId)
            this.dialogVisible2 = true
            console.log(index, row)
        },
        handleDelete(index, row) {
            this.addData = row
            console.log(this.addData)
            this.$axios.post('http://localhost:8080/webrole/deleteuser',this.addData).then(function(resp) {
                console.log(resp)
            })
        },
        addDelete(index, row) {
            console.log(index, row)
        },
        doAdd(index,row) {
            this.dialogVisible = false
        },
        onSubmit(){
            console.log(this.addData)
            this.dialogVisible = false
             const _this = this
             this.$axios.post('http://localhost:8080/webrole/addrole',this.addData).then(function(resp) {
                 console.log(resp)
             })
        },
        handle(){

        }
    },
    created() {
        const _this = this
        this.$axios.get('http://localhost:8080/webrole/findrole').then(function(resp) {
            _this.tableData = resp.data
            // alert(321)
            //这个url要改下
        })
    }
}
</script>
