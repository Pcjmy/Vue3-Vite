<template>
  <el-table :data="state.tableData" stripe style="width: 360px">
    <el-table-column prop="id" align="center" label="ID" width="180"/>
    <el-table-column prop="username" align="center" label="用户名" />
  </el-table>
</template>

<script setup>
import {Edit, Position} from '@element-plus/icons-vue'
import {reactive} from "vue";
import request from "../request";

const state = reactive({
  tableDate: []
})
request.get("/user").then(res => {
  state.tableData = res
})
</script>
