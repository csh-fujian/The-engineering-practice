<template>
    <div class="login-container">
        <h3 class="title">到课云用户登录</h3>
        <el-button type="text" class="choseButton" @click="changeToM"
            >账号登录</el-button
        >
        <el-button type="text" class="choseButton" @click="changeToZ"
            >手机登录</el-button
        >

        <!-- <template> -->
        <el-form
            class="login-form"
            autoComplete="on"
            :model="loginForm"
            :rules="loginRules"
            ref="loginForm"
            label-position="left"
            v-if="loginType"
        >
            <el-form-item prop="username">
                <span class="svg-container svg-container_login">
                    <svg-icon icon-class="user" />
                </span>
                <el-input
                    name="username"
                    type="text"
                    v-model="loginForm.username"
                    autoComplete="on"
                    placeholder="请输入用户名"
                />
            </el-form-item>
            <el-form-item prop="password">
                <span class="svg-container">
                    <svg-icon icon-class="password"></svg-icon>
                </span>
                <el-input
                    name="password"
                    :type="pwdType"
                    @keyup.enter.native="login1"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入密码"
                ></el-input>
                <span class="show-pwd" @click="showPwd"
                    ><svg-icon icon-class="eye"
                /></span>
            </el-form-item>
            <el-form-item>
                <el-button
                    type="primary"
                    style="width:100%;"
                    :loading="loading"
                    @click.native.prevent="login1"
                >
                    登 录
                </el-button>
            </el-form-item>
            <el-button type="text" class="pageButton" @click="registerPage"
                >立即注册</el-button
            >
            <el-button type="text" class="pageButton" @click="forgetPassword"
                >忘记密码</el-button
            >
        </el-form>

        <el-form
            class="login-form"
            autoComplete="on"
            :model="loginForm"
            :rules="loginRules"
            ref="loginForm"
            label-position="left"
            v-else
        >
            <el-form-item prop="Mobile Number">
                <span class="svg-container svg-container_login">
                    <svg-icon icon-class="user" />
                </span>
                <el-input
                    name="username"
                    type="text"
                    v-model="loginForm.username"
                    autoComplete="on"
                    placeholder="请输入手机号"
                />
            </el-form-item>

            <el-form-item prop="password">
                <span class="svg-container">
                    <svg-icon icon-class="password"></svg-icon>
                </span>
                <el-input
                    name="password"
                    :type="pwdType"
                    @keyup.enter.native="login"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入验证码"
                    style="width:60%;"
                ></el-input>

                <el-button
                    type="primary"
                    style="width:30%;"
                    :loading="loading"
                    @click.native.prevent="login"
                >
                    获取验证码
                </el-button>
            </el-form-item>

            <el-form-item>
                <el-button
                    type="primary"
                    style="width:100%;"
                    :loading="loading"
                    @click.native.prevent="login"
                >
                    登 录
                </el-button>
            </el-form-item>

            <el-button type="text" class="pageButton" @click="registerPage"
                >立即注册</el-button
            >
            <el-button type="text" class="pageButton" @click="forgetPassword"
                >忘记密码</el-button
            >
        </el-form>

        <!-- </template> -->
    </div>
</template>

<script>
import { login } from '@/api/permission'
import { fetchPermission } from '@/api/permission'
export default {
    data() {
        const validateUsername = (rule, value, callback) => {
            if (value.length < 1) {
                callback(new Error('请输入正确的用户名'))
            } else {
                callback()
            }
        }
        const validatePass = (rule, value, callback) => {
            if (value.length < 5) {
                callback(new Error('密码不能小于5位'))
            } else {
                callback()
            }
        }

        return {
            date: 0,
            token: '',
            loginType: true,
            loginForm: {
                username: '',
                password: ''
            },
            user: {
                nickname: '',
                password: ''
            },
            loginRules: {
                username: [
                    {
                        required: true,
                        trigger: 'blur',
                        validator: validateUsername
                    }
                ],
                password: [
                    { required: true, trigger: 'blur', validator: validatePass }
                ]
            },
            loading: false,
            pwdType: 'password'
        }
    },
    created: function() {

        this.$notify({
          title: '提示',
          message: '管理员初始化密码：88888888',
          duration: 0
        });

    //    let token = localStorage.getItem('token');
    //    if(token == null){
    //        this.$message({
    //            message: '用户信息错误',
    //            type: 'warning'
    //        })
    //        return null;
    //    }else{

    //        this.$axios.get('http://localhost:3000/token', token).then(res => {

    //        })
    //    }
    //     // `this` 指向 vm 实例
    //     let date = new Date().getTime()
    //     console.log(this.date)
    //     let data = JSON.parse(localStorage.getItem('data'))
    //     let dateLocal = data.date
    //     let tokenLocal = data.token
    //     if(data.token == nill){
    //         return null
    //     }
    //     if (dateLocal != null || date-dateLocal>10000 * 60 * 60 * 24 * 7) {
    //         localStorage.removeItem('data')
    //         return null
    //     } else {
    //         await.this.$axios
    //             .get('http://47.112.239.108:8080/webinitialization/parsejwt', {
    //                 params: {
    //                     token: data.token
    //                 }
    //             })
    //             .then(res => {
    //                 if (res == null) {
    //                     this.$message({
    //                         message: '用户信息错误',
    //                         type: 'warning'
    //                     })
    //                     return null
    //                 } else {
    //                     this.$router.replace('/')
    //                 }
    //             })
    //     }
    },
    methods: {
        changeToM() {
            // 第一种方式
            //this.loginType = (this.loginType === "email") ? 'phone' : 'email';
            this.loginType = true
        },
        changeToZ() {
            // 第一种方式
            //this.loginType = (this.loginType === "email") ? 'phone' : 'email';
            this.loginType = false
        },
        forgetPassword() {
            this.$router.push('/forgetPassword')
        },
        registerPage() {
            this.$router.push('/registerPage')
        },
        showPwd() {
            if (this.pwdType === 'password') {
                this.pwdType = ''
            } else {
                this.pwdType = 'password'
            }
        },
        async login1() {
            try {
                this.user.nickname = this.loginForm.username
                this.user.password = this.loginForm.password
                this.$axios
                    .post(
                        'http://47.112.239.108:8080/webinitialization/login',
                        this.user
                    )
                    .then(res => {
                        
                        console.log(res.data)
                        if (res.data.token == null) {
                            this.$message({
                                title: '消息',
                                message: res.data.message
                            })
                        } else {
                            let token = res.data.token
                            console.log(typeof token)
                            this.$store.commit('LOGIN_IN', token)
							console.log('1')
                            this.$router.replace('/')
                        }
                    })
                //let token = resp.data.token
                // let data = await login(this.loginForm)
                // let token = data.token
                // console.log(typeof token)
                // this.$store.commit('LOGIN_IN', token)
                // this.$router.replace('/')
            } catch (e) {
                // console.log(e)
            }
        },
        async login() {
            try {
                let data = await login(this.loginForm)
                let token = data.token
                this.$store.commit('LOGIN_IN', token)
                this.$router.replace('/')
            } catch (e) {
                console.log(e)
            }
        }
        // async login() {
        //     try {
        //             this.user.nickname = this.loginForm.username
        //             this.user.password = this.loginForm.password
        //             this.$axios
        //                 .post(
        //                     'http://47.112.239.108:8080/webinitialization/login',
        //                     this.user
        //                 )
        //                 .then(res => {
        //                     if (res.token != nill) {
        //                         token = res.roken
        //                         this.$store.commit('LOGIN_IN', token)
        //
        //                         let date = new Date().getTime()
        //                         var data = { token: token, data: new Date().getTime()};
        //                         localStorage.setItem(data, JSON.stringify(data));
        //                         this.$router.replace('/')
        //                     } else {
        //                         this.$message({
        //                             message: '用户信息错误',
        //                             type: 'warning'
        //                         })
        //                     }
        //                 })
        //         }
        //
        //         //this.$router.replace('/')
        //     catch (e) {
        //         console.log(e)
        //     }
        // }
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
    text-align: center;
    .login-form {
        position: absolute;
        left: 0;
        right: 0;
        width: 520px;
        padding: 35px 35px 15px 35px;
        margin: 0px auto;
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
        font-size: 30px;
        font-weight: 400;
        color: $light_gray;
        margin: 100px auto 45px auto;
        text-align: center;
        font-weight: bold;
    }
    .show-pwd {
        position: absolute;
        right: 10px;
        top: 7px;
        font-size: 16px;
        color: $dark_gray;
        cursor: pointer;
        user-select: none;
    }
    .fontcontainer {
        color: #889aa4;
        padding-left: 10px;
    }
    .choseButton {
        color: #fff;
        text-align: center;
        display: inline-block;
        font-size: 18px;
        font-weight: bold;
    }
    .pageButton {
        // top: 150px;
        color: #fff;
        padding-left: 20px;
        float: right;
    }
}
</style>
