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
                                        <el-checkbox   :label="item2.name" :key="item2">{{item2.name}}</el-checkbox>
                                        <el-checkbox-group v-model="selected" >

                                              <el-checkbox style="display:inline;margin: 0px 0px 10px 23px" v-for="item3 in datatable[index1].sub[index2].sub" :label="item3.name" :key="item3">{{item3.name}}</el-checkbox>
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
        <el-button type="primary" @click="">立即创建</el-button>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                selected:[],
                rolename:"教师",
                datatable:[{
                    name: "班课频道",
                    state: "checked",
                    layer: 1,
                    sub:[
                        {
                            name:"班课管理",
                            state:"checked",
                            layer:2,
                            sub:[
                                {
                                    name:"创建班课",
                                    state:"unchecked",
                                    layer:3,
                                    sub:null
                                },
                                {
                                    name:"班课列表排序",
                                    state:"checked",
                                    layer:3,
                                    sub:null
                                },
                                {
                                    name:"查看班课",
                                    state:"checked",
                                    layer:3,
                                    sub:null
                                },
                            ]
                        },
                        {
                            name:"加入班级",
                            state:"unchecked",
                            layer:2,
                            sub:null
                        }
                    ]
                },
                    {
                        name:"发现",
                        state:"checked",
                        layer:1,
                        sub:null
                    },
                    {
                        name:"我的频道",
                        state:"unchecked",
                        layer:1,
                        sub:null
                    }
                ]
            };
        },
        methods: {
            courseManage(value) {
            },
            courseDetail(value){
            }
        },
        created() {
            const _this = this
            this.$axios.post('http://localhost:8080/webpermission/findAll',this.rolename).then(function(resp) {
                _this.datatable = resp
            })
            for(var i=0;i<this.datatable.length;i++){
                if(this.datatable[i].state=="checked"){
                    this.selected.push(this.datatable[i].name)
                }
                 for(var j=0;j<this.datatable[i].sub.length;++j)
                 {
                     if(this.datatable[i].sub[j].state=="checked") {
                         this.selected.push(this.datatable[i].sub[j].name)
                     }
                     for(var k=0;k<this.datatable[i].sub[j].sub.length;++k)
                     {
                         if(this.datatable[i].sub[j].sub[k].state=="checked") {
                             this.selected.push(this.datatable[i].sub[j].sub[k].name)
                         }
                     }
                 }
            }
        }
    };
</script>
