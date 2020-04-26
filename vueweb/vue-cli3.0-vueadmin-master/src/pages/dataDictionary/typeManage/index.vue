<template>
  <el-card class="box-card">
    <div style="display: block;font-size:10px;">
      <el-button
              type="success" icon="el-icon-plus"
              @click="addEdit(scope.$index, scope.row)">添加数据</el-button>
      <el-input
              v-model="search"
              icon="el-icon-plus"
              style="width:130px;height:10px"
              placeholder="输入关键字搜索"/>
    </div>
    <el-table
            :data="tableData.filter(data => !search || data.keyWord.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
      <el-table-column
              label="序号"
              prop="num">
      </el-table-column>
      <el-table-column
              label="类型"
              prop="type">
      </el-table-column>
      <el-table-column
              label="关键词"
              prop="keyWord">
      </el-table-column>
      <el-table-column
              label="值"
              prop="value">
      </el-table-column>
      <el-table-column
              label="是否为默认值"
              prop="Default">
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
                    num:'1',
                    type:'性别',
                    keyWord:'male',
                    value:'男',
                    Default:'null'
                }, {
                    num:'2',
                    type:'性别',
                    keyWord:'female',
                    value:'女',
                    Default:'null'
                }, ],
                search: '',

            }
        },
        methods: {
            handleEdit(index, row) {

            },
            handleDelete(index, row) {
                console.log(index, row);
            },

        },
    }
</script>