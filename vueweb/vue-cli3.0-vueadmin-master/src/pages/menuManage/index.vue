<template>
<div class="block">
    <span class="demonstration">选择院校</span>
    <el-cascader
        v-model="value"
        :options="options"
        @change="handleChange"></el-cascader>
</div>
</template>
<script>
    export default {
        data() {
            return {
                value: [],
                options: [{
                    value: '福州大学',
                    label: '福州大学',
                    children: [{
                        value: '数学与计算机科学学院',
                        label: '数学与计算机科学学院'
                    }, {
                        value: '经济与管理学院',
                        label: '经济与管理学院',
                    }]
                }, {
                    value: '福建师范大学',
                    label: '福建师范大学',
                    children: [{
                        value: '软件学院',
                        label: '软件学院',
                    }, {
                        value: '音乐学院',
                        label: '音乐学院',
                    }]
                }, {
                    value: '厦门大学',
                    label: '厦门大学',
                    children: [{
                        value: '国际关系学院',
                        label: '国际关系学院',
                    }, {
                        value: '管理学院',
                        label: '管理学院',
                    }]
                }]
            };
        },
        methods: {
            handleChange(value) {
                console.log(value);
                alert(value[1])
            }
        }
    };
</script>
