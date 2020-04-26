<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
      <el-button
              type="success" icon="el-icon-plus"
              @click="addEdit(scope.$index, scope.row)">添加类型</el-button>
      <el-input
              v-model="search"
              icon="el-icon-plus"
              style="width:130px;height:10px"
              placeholder="输入类型搜索"/>
    </div>
    <el-table
            :data="tableData.filter(data => !search || data.parameterNname.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
      <el-table-column
              label="参数名称"
              prop="parameterNname">
      </el-table-column>
      <el-table-column
              label="编码"
              prop="code">
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

  </el-card>
</template>
<script>
    export default {
        data() {
            return {
                tableData: [{
                    parameterNname:'性别',
                    code:'sexy',
                    description:'Testsexy'
                }, {
                    parameterNname:'身份',
                    code:'identity',
                    description:'Testsexy'
                }, {
                    parameterNname:'学历',
                    code:'degree',
                    description:'Testsexy'
                }],
                search: '',

            }
        },
        methods: {
            handleEdit(index, row) {
                this.$router.replace('/Datadictionary/Typemanage')
            },
            handleDelete(index, row) {
                console.log(index, row);
            },
            addDelete(index, row) {
                console.log(index, row);
            }
        },
    }
</script>