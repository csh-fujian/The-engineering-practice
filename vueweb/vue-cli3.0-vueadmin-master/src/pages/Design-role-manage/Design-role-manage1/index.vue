<template  lang="html">
  <el-card class="box-card">
    <div class="fl">
      <el-button type="success" icon="el-icon-plus" @click="dialogVisible = true">新增角色</el-button>
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
    <el-pagination
            small
            layout="prev, pager, next"
            :page-size="pageSize"
            :total="total"
            @current-change="page"
    >
    </el-pagination>
    <el-dialog
            title="新增角色"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
      <el-form :model="tableData" >
        <el-form-item label="序号" label-width="120px">
          <el-input v-model="tableData.date" ></el-input>
        </el-form-item>
        <el-form-item label="角色" label-width="120px">
          <el-input v-model="tableData.name" ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="doAdd()">确 定</el-button>
   </span>
    </el-dialog>
  </el-card>
</template>

<script>
    export default {
        data() {
            return {
                pageSize:'3',
                total:'100',
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
                }],
                dialogVisible: false
            }
        },
        methods: {
            doAdd() {
                this.dialogVisible = false
            },
            handleEdit(index, row) {
                console.log(index, row);
            },
            addDelete(index, row) {
                console.log(index, row);
            },
            addUser(index, row) {
            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            },
            page(currentPage){
                switch(currentPage){
                    case 1:
                        this.tableData = [
                            {
                                date:'1',
                                name:'解忧杂货店'
                            },{
                                date:'2',
                                name:'追风筝的人'
                            },{
                                date:'3',
                                name:'人间失格'
                            }
                            ];
                        break;
                    case 2:
                        this.tableData = [
                            {
                                date:'4',
                                name:'白夜行'
                            },{
                                date:'5',
                                name:'三国演义'
                            },{
                                date:'6',
                                name:'罗贯中'
                            }
                            ];
                        break;
                }
            }
        },
        created() {

        }
    }
</script>