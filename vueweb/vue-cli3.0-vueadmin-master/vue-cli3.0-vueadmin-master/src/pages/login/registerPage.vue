<template>
    <div class="registerPage">
        <h3 class="title">用户注册</h3>
        <el-form
            ref="registerForm"
            class="registerForm"
            :model="registerForm"
            label-width="80px"
        >
            <el-form-item label="活动名称:">
                <el-input v-model="registerForm.name"></el-input>
            </el-form-item>
            <el-form-item label="学号/工号:">
                <el-input v-model="registerForm.name"></el-input>
            </el-form-item>
            <el-form-item label="手机号:">
                <el-input v-model="registerForm.name"></el-input>
            </el-form-item>
            <el-form-item label="验证码:">
                <el-input
                    v-model="registerForm.name"
                    style="width:58%;"
                ></el-input
                ><el-button
                    @click.prevent="removeDomain(domain)"
                    style="width:40%;clolr:"
                    >获取验证码</el-button
                >
            </el-form-item>
            <el-form-item label="密码:" prop="pass">
                <el-input
                    type="password"
                    v-model="ruleForm.pass"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <el-form-item label="确认密码:" prop="checkPass">
                <el-input
                    type="password"
                    v-model="ruleForm.checkPass"
                    autocomplete="off"
                ></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm"
                    style="width:100%;">注册</el-button
                >
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
        var checkAge = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('年龄不能为空'))
            }
            setTimeout(() => {
                if (!Number.isInteger(value)) {
                    callback(new Error('请输入数字值'))
                } else {
                    if (value < 18) {
                        callback(new Error('必须年满18岁'))
                    } else {
                        callback()
                    }
                }
            }, 1000)
        }
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'))
            } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkPass')
                }
                callback()
            }
        }
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'))
            } else if (value !== this.ruleForm.pass) {
                callback(new Error('两次输入密码不一致!'))
            } else {
                callback()
            }
        }
        return {
            ruleForm: {
                pass: '',
                checkPass: '',
                age: ''
            },
            rules: {
                pass: [{ validator: validatePass, trigger: 'blur' }],
                checkPass: [{ validator: validatePass2, trigger: 'blur' }],
                age: [{ validator: checkAge, trigger: 'blur' }]
            },

            registerForm: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            }
        }
    },
    methods: {
        submitForm(){
            this.$router.replace('/login')
        },
        onSubmit() {
            console.log('submit!')
        },
        // submitForm(formName) {
        //     this.$refs[formName].validate(valid => {
        //         if (valid) {
        //             alert('submit!')
        //         } else {
        //             console.log('error submit!!')
        //             return false
        //         }
        //     })
        // },
        resetForm(formName) {
            this.$refs[formName].resetFields()
        }
    }
}
</script>
<style lang="scss">
.registerForm {
    .el-form-item__label {
        color: #eee;
    }
    .el-button {
        color: #eee;
        background-color: #409eff;
        background: #409eff;
        border: 1px solid #409eff;
        margin-left: 5px;
    }
}
</style>
<style lang="scss" scoped>
$bg: #2d3a4b;
$light_gray: #eee;

$dark_gray: #889aa4;

.registerPage {
    position: fixed;
    height: 100%;
    width: 100%;
    background-color: $bg;
    text-align: center;
    .registerForm {
        position: absolute;
        left: 0;
        right: 0;
        width: 520px;
        padding: 35px 35px 15px 35px;
        margin: 0px auto;
    }

    .title {
        font-size: 30px;
        font-weight: 400;
        color: $light_gray;
        margin: 50px auto 0px auto;
        text-align: center;
        font-weight: bold;
    }
}
</style>
