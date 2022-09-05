<template>
  <div>
    <div style="width: 400px; margin: 200px auto;">
      <h1 style="text-align: center; margin-bottom: 30px">登 录</h1>
      <el-form :model="user" :rules="rules" ref="ruleFormRef" size="large">
        <el-form-item prop="username">
          <el-input v-model="user.username" :prefix-icon="User" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="user.password" :prefix-icon="Lock" show-password  />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%" @click="login">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import {ref, reactive, getCurrentInstance} from 'vue'
import {User, Lock} from '@element-plus/icons-vue'
import {ElMessage, ElNotification } from "element-plus";
import request from "../request";
import router from "../router";
const { proxy } = getCurrentInstance()

const rules = reactive({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' }
  ],
})

const user = reactive({})

const login = () => {
  proxy.$refs.ruleFormRef.validate((valid) => {
    if(valid) {
      // Promise
      // 往后台发请求 http://localhost:9090    /user/login
      // 后台数据格式：{"code": "200", "msg": "", "data": null}
      request.post('/user/login', user).then(res => {
        console.log(res);
        if (res.code === '200') { // 请求成功
          ElNotification({
            type: 'success',
            message: '登录成功'
          })
          router.push('/')
        } else {  // 请求失败
          ElNotification({
            type: 'error',
            message: res.msg
          })
        }
      })
    } else {
      ElNotification({
        type: 'error',
        message: '用户名或密码错误'
      })
    }
  })
}
</script>