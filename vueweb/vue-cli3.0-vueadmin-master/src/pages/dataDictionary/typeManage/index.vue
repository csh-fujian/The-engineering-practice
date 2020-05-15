<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
      <el-button
              type="success" icon="el-icon-plus"
              @click="dialogVisible = true">添加类型</el-button>
      <el-input
              v-model="search"
              icon="el-icon-plus"
              style="width:130px;height:10px"
              placeholder="输入关键字搜索"/>
    </div>
    <el-table
            :data="tableData.filter(data => !search || data.type.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
      <el-table-column
              label="序号"
              prop="id">
      </el-table-column>
      <el-table-column
              label="参数名称"
              prop="type">
      </el-table-column>
      <el-table-column
              label="编码"
              prop="typed">
      </el-table-column>
      <el-table-column
              label="描述"
              prop="description">
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
          title="添加类型"
          :visible.sync="dialogVisible"
          width="60%"
          :before-close="handleClose">
          <el-form ref="ro" :model="dict" label-width="80px">
              <el-form-item label="序号">
                  <el-input v-model="dict.id"></el-input>
              </el-form-item>
              <el-form-item label="参数名称">
                  <el-input v-model="dict.type"></el-input>
              </el-form-item>
              <el-form-item label="编码">
                  <el-input v-model="dict.typed"></el-input>
              </el-form-item>
              <el-form-item label="描述">
                  <el-input v-model="dict.description"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button>取消</el-button>
                  <el-button type="primary" @click="onSubmit()">确定</el-button>
              </el-form-item>
          </el-form>
      </el-dialog>
  </el-card>
</template>
<script>
export default {
    // 完成：搜搜、添加类型、删除、
    // 未完成：跳转要带对象
    data() {
        return {
            dialogVisible: false,
            deleteDict: {
                typed: ''
            },
            dict: {
                id: 1,
                typed: '',
                type: '',
                description: ''
            },
            diction: {
                typed: '',
                type: '',
                description: ''
            },
            tableData: [{
                id: 1,
                typed: '性别',
                type: 'sexy',
                description: ''
            }, {
                id: 2,
                typed: '身份1',
                type: 'identity',
                description: ''
            } ],
            search: ''
        }
    },
    methods: {
        handleEdit(index, row) {
            this.$router.replace({
                path: '/Datadictionary/Datamanage',
                query: {
                    dicd: row.typed
                }
            })
        },
        handleDelete(index, row) {
            this.dict = row
            console.log(this.dict)
            this.deleteDict.typed = this.dict.typed
            this.$axios.post('http://localhost:8080/webdictionary/deletetype', this.deleteDict).then(function(resp) {
                console.log(resp)
                alert(1)
            })
        },
        onSubmit() {
            console.log(this.dict)
            this.dialogVisible = false
            this.diction.description = this.dict.description
            this.diction.type = this.dict.type
            this.diction.typed = this.dict.typed
            this.$axios.post('http://localhost:8080/webdictionary/addtype', this.diction).then(function(resp) {
                alert(111)
            })
        }
    },
    created() {
        const _this = this

        this.$axios.get('http://localhost:8080/webdictionary/findtype').then(function(resp) {
            _this.tableData = resp.data
        })
    }
}
</script>
