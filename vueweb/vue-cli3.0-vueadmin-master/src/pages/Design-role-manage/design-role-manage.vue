<template  lang="html">
  <el-card class="box-card">
    <div class="fl">
      <el-button type="success" icon="el-icon-plus" @click="addUser">新增角色</el-button>
    </div>
    <el-table
            :data="tableData"
            style="width: 100%">
      <el-table-column
              label="序号"
              width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column
              label="角色"
              width="180">
        <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.name }}</el-tag>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">

        <template slot-scope="scope">
          <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">授予权限</el-button>
          <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column >
    </el-table>
  </el-card>
</template>

<script>
    export default {
        data() {
            return {
                tableData: [{
                    date: '01',
                    name: '王小虎',
                }, {
                    date: '02',
                    name: '王小虎',
                }, {
                    date: '03',
                    name: '王小虎',
                }, {
                    date: '04',
                    name: '王小虎',
                }]
            }
        },
        methods: {
            handleEdit(index, row) {
                console.log(index, row);
            },
            addDelete(index, row) {
                console.log(index, row);
            },
            addUser(index, row) {
                console.log(index, row);
            },
        }
    }
</script>