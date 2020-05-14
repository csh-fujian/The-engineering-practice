<template  lang="html">
    <el-card class="box-card">
        <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
                label="序号"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="变量"
                width="180">
                <template slot-scope="scope">
                    <div slot="reference" class="name-wrapper">
                        <el-tag size="medium">{{ scope.row.name }}</el-tag>
                    </div>
                </template>
            </el-table-column>
            <el-table-column
                label="值"
                width="180">
                <template slot-scope="scope">
                    <div slot="reference" class="name-wrapper">
                        <el-tag size="medium">{{ scope.row.value }}</el-tag>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                </template>
            </el-table-column >
        </el-table>
        <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
            <el-form ref="ro" :model="tableData" label-width="80px">
                <el-form-item label="变量">
                    <el-input v-model="ro.name"></el-input>
                </el-form-item>
                <el-form-item label="值">
                    <el-input v-model="ro.value"></el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" @click="edit()">确 定</el-button>
            <el-button @click="dialogVisible = false">取 消</el-button>
        </el-dialog>
    </el-card>
</template>

<script >
export default {
    data() {
        return {
            dialogVisible: false,
            ro: {
                id: 1,
                name: '',
                value:''
            },
            tableData: [{
                id: 1,
                name: '距离',
                value:'20米'
            }, {
                id: 2,
                name: '经验值',
                value:'30'
            }, {
                id: 3,
                name: '人数',
                value:'100'
            }]
        }
    },
    methods: {
        handleEdit(index, row) {
            this.dialogVisible = true
            this.ro = row
        },
        edit() {
            this.dialogVisible = false
        }
    },
    created() {
        const _this = this
        this.$axios.get('http://localhost:8080/webrole/findrole').then(function(resp) {
            _this.tableData = resp.data
        })
    }
}
</script>
