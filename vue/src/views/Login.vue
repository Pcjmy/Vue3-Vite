<template>
  <div>
    <div style="width: 400px; margin: 200px auto;">
      <h1 style="text-align: center; margin-bottom: 30px">登 录</h1>
      <el-form :model="user" size="large">
        <el-form-item>
          <el-input v-model="user.name" :prefix-icon="User" />
        </el-form-item>
        <el-form-item>
          <el-input v-model="user.password" :prefix-icon="Lock" show-password  />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { User, Lock } from '@element-plus/icons-vue'

const user = reactive({
  name: 'Pcjmy'
})
const changeUser = (name) => {
  user.name = name   // 通过这种方式来赋值
}
</script>