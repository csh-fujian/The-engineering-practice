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
          <el-form ref="ro" :model="adddata" label-width="80px">
              <el-form-item label="序号">
                  <el-input v-model="adddata.id"></el-input>
              </el-form-item>
              <el-form-item label="类型">
                  <el-input v-model="adddata.typed"></el-input>
              </el-form-item>
              <el-form-item label="关键字">
                  <el-input v-model="adddata.keyd"></el-input>
              </el-form-item>
              <el-form-item label="值">
                  <el-input v-model="adddata.valued"></el-input>
              </el-form-item>
              <el-form-item label="是否为默认值">
                  <el-input v-model="adddata.defaultvalued"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="onSubmit()">确定</el-button>
                  <el-button>取消</el-button>
              </el-form-item>
          </el-form>
      </el-dialog>
      <el-dialog
          title="编辑数据"
          :visible.sync="dialogVisible1"
          width="60%"
          :before-close="handleClose">
          <el-form ref="ro" :model="adddata" label-width="80px">
              <el-form-item label="序号">
                  <el-input v-model="adddata.id"></el-input>
              </el-form-item>
              <el-form-item label="类型">
                  <el-input v-model="adddata.typed"></el-input>
              </el-form-item>
              <el-form-item label="关键字">
                  <el-input v-model="adddata.keyd"></el-input>
              </el-form-item>
              <el-form-item label="值">
                  <el-input v-model="adddata.valued"></el-input>
              </el-form-item>
              <el-form-item label="是否为默认值">
                  <el-input v-model="adddata.defaultvalued"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="edit()">确定</el-button>
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
            dialogVisible: false,
            dialogVisible1: false,
            typed: '',
            record: {
                valued: ''
            },
            dicd: {
                typed: '性别',
                keyd: 'male',
                valued: '男',
                defaultvalued: 0
            },
            adddata: {
                typed: '性别',
                keyd: 'male',
                valued: '男',
                defaultvalued: 0
            },
            tableData: [{
                id: 1,
                typed: '性别',
                keyd: 'male',
                valued: '男',
                defaultvalued: 0
            }, {
                id: 2,
                typed: '性别',
                keyd: 'female',
                valued: '女',
                defaultvalued: 0
            } ],
            search: ''
        }
    },
    methods: {
        handleEdit(index, row) {
            this.record.valued = row.valued
            this.adddata = row
            console.log(this.adddata)
            this.dialogVisible1 = true
        },
        edit() {
            // this.dicd = this.adddata
            console.log(this.adddata)
            this.dicd.valued = this.adddata.valued
            this.dicd.keyd = this.adddata.keyd
            this.dicd.defaultvalued = this.adddata.defaultvalued
            this.dicd.typed = this.adddata.typed
            console.log(this.dicd)
            this.$axios.put('http://localhost:8080/webdictionary/updatedata', this.dicd, this.record).then(function(resp) {
                alert(99)
            })
            this.dialogVisible1 = false
        },
        handleDelete(index, row) {
            this.dicd = row
            this.$axios.post('http://localhost:8080/webdictionary/deletedata', this.dicd).then(function(resp) {
                console.log(resp)
            })
        },
        addDelete(index, row) {
            console.log(index, row)
        },
        onSubmit() {
            this.dialogVisible = false
            // eslint-disable-next-line no-unused-vars
            this.dicd.typed = this.adddata.typed
            this.dicd.defaultvalued = this.adddata.defaultvalued
            this.dicd.keyd = this.adddata.keyd
            this.dicd.valued = this.adddata.valued
            console.log(this.dicd)
            this.$axios.post('http://localhost:8080/webdictionary/adddata', this.dicd).then(function(resp) {
                console.log(resp)
                alert(123)
            })
        }
    },
    created() {
        this.dicd.typed = this.$route.query.dicd
        const _this = this
        this.typed = this.dicd.typed

        this.$axios.get('http://localhost:8080/webdictionary/finddata/' + this.typed).then(function(resp) {
            _this.tableData = resp.data
        })
    }
}
</script>
