<template>
    <div>
        <ul>
            <el-checkbox-group v-model="selected" >
                <ul>
                    <li  v-for="(item1,index1) in datatable">
                        <el-checkbox :label="item1.name" :key="item1"><strong >{{item1.name}}</strong></el-checkbox>
                        <ul>
                            <el-checkbox-group v-model="selected" >
                                <ul>
                                    <li  v-for="(item2,index2) in datatable[index1].sub">
                                        <el-checkbox  style="display:inline;margin: 0px 0px 10px 23px" :label="item2.name" :key="item2">{{item2.name}}</el-checkbox>
                                        <el-checkbox-group v-model="selected" >
                                            <el-checkbox style="display:inline;margin: 0px 0px 10px 43px" v-for="item3 in datatable[index1].sub[index2].sub" :label="item3.name" :key="item3">{{item3.name}}</el-checkbox>
                                        </el-checkbox-group>
                                    </li>
                                </ul>
                            </el-checkbox-group>
                        </ul>
                        <el-divider></el-divider>
                    </li>
                </ul>
            </el-checkbox-group>
        </ul>
        <el-button type="primary" @click="dialogVisible1 = true">添加菜单</el-button>
        <el-button type="primary" @click="dialogVisible2 = true">添加页面</el-button>
        <el-button type="primary" @click="addbutton3()">添加按钮</el-button>
        <el-button type="primary" @click="handdelete()">勾选删除</el-button>
        <el-dialog
            title="添加菜单"
            :visible.sync="dialogVisible1"
            width="60%"
            :before-close="handleClose1">
            <el-form  :model="menuname" label-width="80px">
                <el-form-item label="名称">
                    <el-input v-model="menuname"></el-input>
                </el-form-item>
                <el-form-item label="链接">
                    <el-input v-model="temp1"></el-input>
                </el-form-item>
                <el-form-item label="包含页面">
                    <el-tag
                        :key="tag"
                        v-for="tag in submenus"
                        closable
                        :disable-transitions="false"
                        @close="handleClose(tag)">
                        {{tag}}
                    </el-tag>
                    <el-input
                        class="input-new-tag"
                        v-if="inputVisible"
                        v-model="inputValue"
                        ref="saveTagInput"
                        size="small"
                        @keyup.enter.native="handleInputConfirm"
                        @blur="handleInputConfirm"
                    >
                    </el-input>
                    <el-button v-else  size="small" @click="showInput">添加新页面</el-button>
                </el-form-item>
            </el-form>
            <el-button @click="dialogVisible1 = false">取 消</el-button>
            <el-button type="primary" @click="addmenu()">确 定</el-button>

        </el-dialog>
        <el-dialog
            title="添加页面"
            :visible.sync="dialogVisible2"
            width="60%"
            :before-close="handleClose2">
            <el-form  :model="menuname" label-width="80px">
                <el-form-item label="名称">
                    <el-input v-model="menuname"></el-input>
                </el-form-item>
                <el-form-item label="链接">
                    <el-input v-model="temp1"></el-input>
                </el-form-item>
                <el-form-item label="上级菜单">
                    <el-input v-model="supermenu"></el-input>
                </el-form-item>
                <el-form-item label="包含按钮">
                    <el-tag
                        :key="tag"
                        v-for="tag in submenus"
                        closable
                        :disable-transitions="false"
                        @close="handleClose(tag)">
                        {{tag}}
                    </el-tag>
                    <el-input
                        class="input-new-tag"
                        v-if="inputVisible"
                        v-model="inputValue"
                        ref="saveTagInput"
                        size="small"
                        @keyup.enter.native="handleInputConfirm"
                        @blur="handleInputConfirm"
                    >
                    </el-input>
                    <el-button v-else  size="small" @click="showInput">添加新按钮</el-button>
                </el-form-item>
            </el-form>
            <el-button @click="dialogVisible2 = false">取 消</el-button>
            <el-button type="primary" @click="addpage()">确 定</el-button>
        </el-dialog>
        <el-dialog
            title="添加按钮"
            :visible.sync="dialogVisible3"
            width="50%"
            :before-close="handleClose3">
            <el-form :model="menuname" label-width="80px">
                <el-form-item label="名称">
                    <el-input v-model="button"></el-input>
                </el-form-item>
                <el-form-item label="上级页面">
                    <el-input v-model="supermenu"></el-input>
                </el-form-item>
            </el-form>
            <el-button @click="dialogVisible3 = false">取 消</el-button>
            <el-button type="primary" @click="addbutton()">确 定</el-button>
        </el-dialog>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                selected: [],
                temp1: '',
                temp2: 0,
                dialogVisible1: false,
                dialogVisible2: false,
                dialogVisible3: false,
                submenus: [],
                inputVisible: false,
                inputValue: '',
                menuname: '',
                supermenu: '',
                button: '',
                delSel:{
                    submenu:[]
                },
                button1: {
                    button:'',
                    supermenu:''
                },
                Menu: {
                    menuname: '',
                    submenus: []
                },
                Page:{
                    menuname: '',
                    supermenu:''
                },
                Page1:{
                    menuname: '',
                    supermenu:'',
                    buttons:[]
                },
                buttons: [],
                datatable: [{
                    name: '班课频道',
                    state: 'checked',
                    layer: 1,
                    sub: [
                        {
                            name: '班课管理',
                            state: 'checked',
                            layer: 2,
                            sub: [
                                {
                                    name: '创建班课',
                                    state: 'unchecked',
                                    layer: 3,
                                    sub: null
                                },
                                {
                                    name: '班课列表排序',
                                    state: 'checked',
                                    layer: 3,
                                    sub: null
                                },
                                {
                                    name: '查看班课',
                                    state: 'checked',
                                    layer: 3,
                                    sub: null
                                },
                                {
                                    name: '查看班课',
                                    state: 'checked',
                                    layer: 3,
                                    sub: null
                                }
                            ]
                        },
                        {
                            name: '加入班级',
                            state: 'unchecked',
                            layer: 2,
                            sub: null
                        }
                    ]
                },
                    {
                        name: '发现',
                        state: 'checked',
                        layer: 1,
                        sub: null
                    },
                    {
                        name: '我的频道',
                        state: 'checked',
                        layer: 1,
                        sub: [
                            {
                                name: '创建班课',
                                state: 'unchecked',
                                layer: 3,
                                sub: null
                            },
                            {
                                name: '333',
                                state: 'checked',
                                layer: 3,
                                sub: null
                            },
                            {
                                name: '222',
                                state: 'checked',
                                layer: 3,
                                sub: null

                            },
                            {
                                name: '111',
                                state: 'checked',
                                layer: 3,
                                sub: null
                            }
                        ]
                    }
                ]
            }
        },
        methods: {
            handdelete() {
                this.delSel.submenu = this.selected
                console.log(this.delSel)
                const _this = this
                this.$axios.post('http://localhost:8080/webmenu/deletemenu', this.delSel,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                    _this.$axios.get('http://localhost:8080/webmenu/findAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                        _this.datatable = res.data
                            this.$alert('删除成功', '删除', {
                                confirmButtonText: '确定',
                                callback: action => {
                                }
                            })
                    }
                    )
                })
            },
            addbutton3(){
                this.dialogVisible3 = true
                this.supermenu = ''
            },
            handleClose3(){
                this.dialogVisible3 = false
            },
            addmenu() {
                this.dialogVisible1 = false
                this.Menu.menuname = this.menuname
                this.Menu.submenus = this.submenus
                console.log(this.Menu)
                const _this = this
                this.$axios.post('http://localhost:8080/webmenu/addmenu1/' + this.menuname,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                    this.$axios.post('http://localhost:8080/webmenu/addmenu', _this.Menu,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                        _this.$axios.get('http://localhost:8080/webmenu/findAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                                _this.datatable = res.data
                            this.$alert('分配权限成功', '分配权限', {
                                confirmButtonText: '确定',
                                callback: action => {
                                }
                            })
                            }
                        )
                    })
                })

            },
            addpage() {
                this.dialogVisible2 = false
                this.buttons = this.submenus
                this.Page.menuname = this.menuname
                this.Page.supermenu = this.supermenu
                this.Page1.buttons = this.buttons
                this.Page1.menuname = this.menuname
                this.Page1.supermenu = this.supermenu
                const _this = this
                console.log(this.Page)
                console.log(this.Page1)
                this.$axios.post('http://localhost:8080/webmenu/addpage1', this.Page,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                    this.$axios.post('http://localhost:8080/webmenu/addpage', _this.Page1,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                        this.$axios.get('http://localhost:8080/webmenu/findAll').then(res => {
                                _this.datatable = res.data
                            this.$alert('新增页面成功', '新增页面', {
                                confirmButtonText: '确定',
                                callback: action => {
                                }
                            })
                            }
                        )
                    })
                })

            },
            addbutton() {
                this.dialogVisible3 = false
                this.button1.button = this.button
                this.button1.supermenu = this.supermenu
                const _this = this
                console.log(this.button1)
                this.$axios.post('http://localhost:8080/webmenu/addbutton', this.button1,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                    _this.$axios.get('http://localhost:8080/webmenu/findAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                            _this.datatable = res.data
                        this.$alert('新增按钮成功', '新增按钮', {
                            confirmButtonText: '确定',
                            callback: action => {
                            }
                        })
                        }
                    )
                })

            },
            handleClose2(tag) {
                this.dialogVisible2 = false
            },
            handleClose1() {
                this.dialogVisible1 = false
            },

            showInput() {
                this.inputVisible = true
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus()
                })
            },

            handleInputConfirm() {
                let inputValue = this.inputValue
                if (inputValue) {
                    this.submenus.push(inputValue)
                }
                this.inputVisible = false
                this.inputValue = ''
            }
        },
        created() {
            this.$axios.get('http://localhost:8080/webmenu/findAll',{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                    this.datatable = res.data
                    for (let i = 0; i < this.datatable.length; ++i) {
                        if (this.datatable[i].state == 'checked') {
                            this.selected.push(this.datatable[i].name)
                        }
                        if (this.datatable[i].sub == null) { continue }
                        for (let j = 0; j < this.datatable[i].sub.length; ++j) {
                            if (this.datatable[i].sub[j].state == 'checked') {
                                this.selected.push(this.datatable[i].sub[j].name)
                            }
                            if (this.datatable[i].sub[j].sub == null) { continue }
                            for (var k = 0; k < this.datatable[i].sub[j].sub.length; ++k) {
                                if (this.datatable[i].sub[j].sub[k].state == 'checked') {
                                    this.selected.push(this.datatable[i].sub[j].sub[k].name)
                                }
                                if (this.datatable[i].sub[j].sub[k].sub == null) { continue }
                            }
                        }
                    }
                }

            )
        }
    }
</script>
<style>
    .el-tag + .el-tag {
        margin-left: 10px;
    }
    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
    }
</style>
