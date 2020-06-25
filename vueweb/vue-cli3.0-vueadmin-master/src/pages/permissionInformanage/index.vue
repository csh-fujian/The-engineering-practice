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
                                            <ul>
                                                <li  v-for="(item3,index3) in datatable[index1].sub[index2].sub">
                                                    <el-checkbox  style="display:inline;margin: 0px 0px 10px 43px" :label="item3.name" :key="item3">{{item3.name}}</el-checkbox>
                                                    <el-checkbox-group v-model="selected" >
                                                        <ul>
                                                            <li  v-for="(item4,index4) in datatable[index1].sub[index2].sub[index3].sub">
                                                                <el-checkbox  style="display:inline;margin: 0px 0px 10px 63px" :label="item4.name" :key="item4" disabled>
                                                                    {{item4.name}}
                                                                </el-checkbox>
                                                            </li>
                                                        </ul>
                                                    </el-checkbox-group>
                                                </li>
                                            </ul>
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
        <el-button type="primary" @click="consent()">确定</el-button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            selected: [],
            rolename: '',
            Permission: {
                role: '',
                menus: []
            },
            test: [],
            datatable: [{
                name: '班课频道',
                state: 'unchecked',
                layer: 1,
                sub: [
                    {
                        name: '班课管理',
                        state: 'unchecked',
                        layer: 2,
                        sub: [
                            {
                                name: '创建班课',
                                state: 'unchecked',
                                layer: 3,
                                sub: [
                                    {
                                        name: '确定按钮',
                                        state: 'unchecked',
                                        layer: 4,
                                        sub: null
                                    }
                                ]
                            },
                            {
                                name: '班课列表排序',
                                state: 'unchecked',
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
                        sub: [
                            {
                                name: '添加班级',
                                state: 'unchecked',
                                layer: 3,
                                sub: null
                            }
                        ]
                    }
                ]
            },
            {
                name: '发现',
                state: 'unchecked',
                layer: 1,
                sub: [
                    {
                        name: '发现内容',
                        state: 'checked',
                        layer: 2,
                        sub: null
                    }
                ]
            },
            {
                name: '我的频道',
                state: 'checked',
                layer: 1,
                sub: [
                    {
                        name: '创建班课',
                        state: 'unchecked',
                        layer: 2,
                        sub: null
                    },
                    {
                        name: '333',
                        state: 'unchecked',
                        layer: 2,
                        sub: null
                    },
                    {
                        name: '222',
                        state: 'unchecked',
                        layer: 2,
                        sub: null
                    },
                    {
                        name: '111',
                        state: 'unchecked',
                        layer: 2,
                        sub: null
                    }
                ]
            }
            ]
        }
    },
    methods: {
        consent() {
            this.Permission.role = this.rolename
            this.Permission.menus = this.selected
		
			console.log(this.Permission)
            this.$axios.post('http://localhost:8080/webpermission/addpermission',this.Permission,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
                this.$alert('分配权限成功', '分配权限', { 
                    confirmButtonText: '确定',
                    callback: action => {
                    }  
                })
            })
        } 
    },
    created() {
        // alert(this.$route.query.rolename)
        this.rolename = this.$route.query.rolename
        const _this = this
        this.$axios.get('http://localhost:8080/webpermission/findAll/' + this.rolename,{
                                headers: {
                                    Authorization: localStorage.getItem('token')
                                }
                            }).then(res => {
            _this.datatable = res.data
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
