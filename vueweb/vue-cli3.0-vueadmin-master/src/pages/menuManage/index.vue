<template>
    <div>
        <ul>
            <el-checkbox-group v-model="checkdfirstLevelPage" >
                <ul>
                    <li  v-for="item1 in firstLevelPage">
                        <el-checkbox :label="item1" :key="item1"><strong >{{item1}}</strong></el-checkbox>
                            <ul>
                                <el-checkbox-group v-model="checkedCourseDetails" >
                                    <ul>
                                        <li  v-for="item2 in courseDetails">
                                            <el-checkbox   :label="item2" :key="item2">{{item2}}</el-checkbox>
                                                <el-checkbox-group v-model="checkedCourseManage" >
                                                    <el-checkbox v-for="item3 in courseManagers" :label="item3" :key="item3">{{item3}}</el-checkbox>
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
                checkedCourseManage: ['教师创建课程', '申请加入'],
                checkedCourseDetails: ['课程管理1', '课程详情'],
                courseManagers: ['课程管理','教师创建课程', '申请加入', '批准加入', '删除课程'],
                courseDetails: ['课程管理1','课程详情', '资源', '活动'],
                firstLevelPage:['内容发现','我的课程'],
                checkdfirstLevelPage:['内容发现']
            };
        },
        methods: {
            courseManage(value) {
            },
            courseDetail(value){
            }
        },
        created() {
            this.$http.get('http://localhost:3003/api')
                .then((data) => {
                    alert(123)
                    alert(data.body)
                }, () => {
                    console.log('这里是用了vue-source,后端没有接口')
                })
        }
    };
</script>
