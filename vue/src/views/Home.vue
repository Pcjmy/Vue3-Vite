<template>
  <div>
    主页
    <br/>
    <el-button type="primary">
      Hello
      <el-icon><Edit /></el-icon>

      <Edit style="width: 1em; height: 1em; margin-right: 8px" />
      <Position style="width: 1em; height: 1em; margin-right: 8px" />
    </el-button>
  </div>
</template>

<script setup>
import {Edit, Position} from '@element-plus/icons-vue'
</script>
