<template>
    <div class="login-container">
        <el-form
            class="login-form"
            autoComplete="on"
            label-position="left"
            v-if="!isassert"
        >
            <h3 class="title">忘记密码</h3>

            <el-form-item prop="phoneNum">
                <span class="svg-container svg-container_login">
                    <i class="el-icon-phone"></i>
                </span>
                <el-input
                    name=""
                    type="text"
                    v-model="phoneNum"
                    autoComplete="on"
                    placeholder="请输入手机号"
                />
            </el-form-item>

            <el-form-item>
                <span class="svg-container svg-container_login">
                    <i class="el-icon-edit"></i>
                </span>
                <el-input
                    v-model="expe"
                    style="width:60%;"
                    @keyup.enter.native="getExpe"
                    autoComplete="on"
                    placeholder="请输入验证码 "
                ></el-input>
                <el-button type="primary" style="width:30%;" :loading="loading">
                    获取验证码
                </el-button>
            </el-form-item>

            <el-form-item>
                <el-button
                    type="primary"
                    style="width:100%;"
                    :loading="loading"
                    @click.native.prevent="nextstep"
                >
                    下一步
                </el-button>
            </el-form-item>
        </el-form>
        <el-form
            ref="passwordForm"
            class="passwordForm"
            autoComplete="on"
            :model="passwordForm"
            :rules="passRules"
            label-position="left"
            v-else
        >
            <h3 class="title">忘记密码</h3>

            <el-form-item prop="password">
                <span class="svg-container svg-container_login">
                    <i class="el-icon-edit"></i>
                </span>
                <el-input
                    name="password"
                    v-model="passwordForm.password"
                    autoComplete="on"
                    placeholder="请输入新密码"
                />
            </el-form-item>

            <el-form-item prop="checkpass">
                <span class="svg-container svg-container_login">
                    <i class="el-icon-edit"></i>
                </span>
                <el-input
                    name="checkpass"
                    v-model="passwordForm.checkpass"
                    style="width:60%;"
                    autoComplete="on"
                    placeholder="请确认密码 "
                ></el-input>
            </el-form-item>

            <el-form-item>
                <el-button
                    type="primary"
                    style="width:100%;"
                    :loading="loading"
                    @click.native.prevent="resetPassword"
                >
                    重置密码
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { login } from '@/api/permission'
export default {
    data() {
        const validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'))
            } else {
                if (this.passwordForm.checkpass !== '') {
                    this.$refs.passwordForm.validateField('checkpass')
                }
                callback()
            }
        }
        const validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'))
            } else if (value !== this.passwordForm.password) {
                callback(new Error('两次输入密码不一致!'))
            } else {
                callback()
            }
        }
        return {
            passRules: {
                password: [
                    { required: true, validator: validatePass, trigger: 'blur' }
                ],
                checkpass: [{ validator: validatePass2, trigger: 'blur' }]
            },

            expe: '',
            phoneNum: '',
            isassert: false,
            passwordForm: {
                password: '',
                checkpass: ''
            },

            loading: false
        }
    },
    methods: {
        nextstep() {
            this.isassert = true
        },
        resetPassword() {
            console.log(this.phoneNum)
            console.log(this.passwordForm.password)
            console.log(this.passwordForm.checkpass)
            this.$router.replace('/login')
        },
        async forgetPassword() {
            try {
                let data = await login(this.loginForm)
                let token = data.token
                this.$store.commit('LOGIN_IN', token)
                this.$router.replace('/forgetPassword')
            } catch (e) {
                console.log(e)
            }
        }
    }
}
</script>

<style rel="stylesheet/scss" lang="scss">
$bg: #2d3a4b;
$light_gray: #eee;

/* reset element-ui css */
.login-container {
    .el-input {
        display: inline-block;
        height: 47px;
        width: 90%;
        input {
            background: transparent;
            border: 0px;
            -webkit-appearance: none;
            border-radius: 0px;
            padding: 12px 5px 12px 15px;
            color: $light_gray;
            height: 47px;
            &:-webkit-autofill {
                -webkit-box-shadow: 0 0 0px 1000px $bg inset !important;
                -webkit-text-fill-color: #fff !important;
            }
        }
    }
    .el-form-item {
        border: 1px solid rgba(255, 255, 255, 0.1);
        background: rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        color: #454545;
    }
}
</style>

<style rel="stylesheet/scss" lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;
.login-container {
    position: fixed;
    height: 100%;
    width: 100%;
    background-color: $bg;
    .passwordForm {
        position: absolute;
        left: 0;
        right: 0;
        width: 520px;
        padding: 35px 35px 15px 35px;
        margin: 120px auto;
    }
    .login-form {
        position: absolute;
        left: 0;
        right: 0;
        width: 520px;
        padding: 35px 35px 15px 35px;
        margin: 120px auto;
    }
    .tips {
        font-size: 14px;
        color: #fff;
        margin-bottom: 10px;
        span {
            &:first-of-type {
                margin-right: 16px;
            }
        }
    }
    .svg-container {
        padding: 6px 5px 6px 15px;
        color: $dark_gray;
        vertical-align: middle;
        width: 30px;
        display: inline-block;
        &_login {
            font-size: 20px;
        }
    }
    .title {
        font-size: 26px;
        font-weight: 400;
        color: $light_gray;
        margin: 0px auto 40px auto;
        text-align: center;
        font-weight: bold;
    }
    .show-pwd {
        position: absolute;
        right: 0px;
        top: 0px;
        height: 60px;
        font-size: 100px;
        color: $dark_gray;
        cursor: pointer;
        user-select: none;
    }
    .fontcontainer {
        color: #889aa4;
        padding-left: 10px;
    }
}
</style>
