<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
      <el-button
              type="success" icon="el-icon-plus"
              @click="dialogVisible = true">添加数据</el-button>
      <el-input
              v-model="search"
              icon="el-icon-plus"
              style="width:130px;height:10px"
              placeholder="输入数据搜索"/>
    </div>
    <el-table
            :data="tableData.filter(data => !search || data.parameterNname.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
      <el-table-column
              label="序号"
              prop="id">
      </el-table-column>
      <el-table-column
              label="类型"
              prop="typed">
      </el-table-column>
      <el-table-column
              label="关键字"
              prop="keyd">
      </el-table-column>
        <el-table-column
              label="值"
              prop="valued">
      </el-table-column>
        <el-table-column
              label="是否为默认值"
              prop="defaultvalued">
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
          title="添加数据"
          :visible.sync="dialogVisible"
          width="60%"
          :before-close="handleClose">
          <el-form ref="ro" :model="tableData" label-width="80px">
              <el-form-item label="序号">
                  <el-input v-model="tableData.id"></el-input>
              </el-form-item>
              <el-form-item label="类型">
                  <el-input v-model="tableData.typed"></el-input>
              </el-form-item>
              <el-form-item label="关键字">
                  <el-input v-model="tableData.keyd"></el-input>
              </el-form-item>
              <el-form-item label="值">
                  <el-input v-model="tableData.valued"></el-input>
              </el-form-item>
              <el-form-item label="是否为默认值">
                  <el-input v-model="tableData.defaultvalued"></el-input>
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
        data() {
            return {
                dialogVisible:false,
                tableData: [{
                    id:1,
                    typed:'性别',
                    keyd:'male',
                    valued:'男',
                    defaultvalued:'true',
                }, {
                    id:2,
                    typed:'性别',
                    keyd:'female',
                    valued:'女',
                    defaultvalued:'false',
                } ],
                search: '',
            }
        },
        methods: {
            handleEdit(index, row) {

            },
            handleDelete(index, row) {
                console.log(index, row);
            },
            addDelete(index, row) {
                console.log(index, row);
            },
            onSubmit() {
                this.dialogVisible = false
                const _this = this
                // this.$axios.post('http://localhost:8080/webrole/addrole',this.ro).then(function(resp) {
                //     console.log(resp)
                // })
                // this.addform.Id = ''
                // this.addform.name = ''
            },
        },
        created() {
            const _this = this
            this.$axios.get('http://localhost:8080/webdictionary/finddata ').then(function(resp) {
                _this.tableData = resp.data
                // alert(321)
            })
        }
    }
</script>
