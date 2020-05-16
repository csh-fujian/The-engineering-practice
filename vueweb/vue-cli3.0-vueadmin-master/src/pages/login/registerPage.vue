<template>
    <div class="registerPage">
        <h3 class="title">用户注册</h3>
        <el-form
            ref="registerForm"
            class="registerForm"
            :model="registerForm"
            :rules="registerRules"
            label-width="80px"
        >
            <el-form-item label="姓名:" prop="name">
                <el-input v-model="registerForm.name"></el-input>
            </el-form-item>
            <el-form-item label="工号:" prop="idNumber">
                <el-input v-model="registerForm.idNumber"></el-input>
            </el-form-item>
            <el-form-item label="手机号:" prop="phoneNumber">
                <el-input v-model="registerForm.phoneNumber"></el-input>
            </el-form-item>
            <el-form-item label="验证码:">
                <el-input v-model="expe" style="width:58%;"></el-input
                ><el-button
                    @click.prevent="removeDomain(domain)"
                    style="width:40%;clolr:"
                    >获取验证码</el-button
                >
            </el-form-item>
            <el-form-item label="密码:" prop="pass">
                <el-input
                    name="pass"
                    v-model="registerForm.pass"
                    autocomplete="off"
                ></el-input>
            </el-form-item>
            <el-form-item label="确认密码:" prop="checkPass">
                <el-input
                    name="checkPass"
                    v-model="registerForm.checkPass"
                    
                    autocomplete="off"
                ></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="register" style="width:100%;"
                    >注册</el-button
                >
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
        const validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'))
            } else {
                if (this.registerForm.checkPass !== '') {
                    this.$refs.registerForm.validateField('checkPass')
                }
                callback()
            }
        }
        const validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'))
            } else if (value !== this.registerForm.pass) {
                callback(new Error('两次输入密码不一致!'))
            } else {
                callback()
            }
        }
        const validatePhone = (rule, value, callback) => {
            const reg = /^[1][3-9][0-9]{9}$/
            if (value == '' || value == undefined || value == null) {
                callback()
            } else {
                if (!reg.test(value) && value != '') {
                    callback(new Error('请输入正确的电话号码'))
                } else {
                    callback()
                }
            }
        }
        return {
            registerRules: {
                pass: [
                    { required: true, trigger: 'blur', validator: validatePass }
                ],
                checkPass: [
                    {
                        trigger: 'blur',
                        validator: validatePass2
                    }
                ],
                phoneNumber: [
                    {
                        required: true,
                        trigger: 'blur',
                        validator: validatePhone
                    }
                ],
                name: [{ required: true, trigger: 'blur' }],
                idNumber: [{ required: true, trigger: 'blur' }]
            },

            expe: '',
            registerForm: {
                name: '',
                idNumber: '',
                phoneNumber: '',
                pass: '',
                checkPass: ''
            }
        }
    },
    methods: {
        // submitForm() {
        //     this.$router.replace('/login')
        // },
        onSubmit() {
            console.log('submit!')
        },
        async register() {
            try {
                // let data = await register(this.registerForm)
                
                var registerData = { userInfo: {} }
                registerData.userInfo.name = this.registerForm.name
                registerData.userInfo.idNumber = this.registerForm.idNumber
                registerData.userInfo.phoneNumber = this.registerForm.phoneNumber
                registerData.userInfo.passWord = this.registerForm.pass
                this.$notify.info({
                    title: '消息',
                    message: '注册成功'
                })
                this.$router.replace('/login')
                console.log(registerData)
            } catch (e) {
                console.log(e)
            }
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
