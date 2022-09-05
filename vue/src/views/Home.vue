<template>
  <div>
    <el-button type="primary" @click="handleAdd"><el-icon style="margin-right: 3px"><Plus /></el-icon>新增</el-button>
  </div>
  <el-table :data="state.tableData" stripe style="width: 100%">
    <el-table-column prop="id" label="ID" width="180" />
    <el-table-column prop="username" label="用户名" />
    <el-table-column prop="sex" label="性别" />
    <el-table-column prop="age" label="年龄" />
    <el-table-column prop="phone" label="手机" />
    <el-table-column prop="email" label="邮箱" />
    <el-table-column prop="address" label="地址" />
    <el-table-column prop="avatar" label="头像" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="primary" size="small" @click="handleEdit(scope.row)"><el-icon style="margin-right: 3px"><Edit /></el-icon> 编辑</el-button>
        <el-popconfirm title="确定删除吗?" @confirm="deleteRow(scope.row.id)"  confirm-button-text="确定" cancel-button-text="取消">
          <template #reference>
            <el-button link type="danger" size="small"><el-icon style="margin-right: 3px"><Delete /></el-icon> 删除</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="dialogFormVisible" title="用户信息" width="40%">
    <el-form :model="state.form" :rules="state.rules" ref="ruleFormRef" label-width="120px" style="width: 85%">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="state.form.username" autocomplete="off" placeholder="请输入用户名" />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="state.form.sex" class="ml-4">
          <el-radio label="男">男</el-radio>
          <el-radio label="女">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="state.form.age" autocomplete="off" placeholder="请输入年龄" />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="state.form.phone" autocomplete="off" placeholder="请输入手机号" />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="state.form.email" autocomplete="off" placeholder="请输入邮箱" />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input type="textarea" v-model="state.form.address" autocomplete="off" placeholder="请输入地址" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import {Edit, Delete, Plus} from '@element-plus/icons-vue'
import {getCurrentInstance, reactive, ref} from "vue";
import request from "../request";
import {ElMessage} from "element-plus";
const { proxy } = getCurrentInstance()

// getCurrentInstance用于获取当前组件的实例
// proxy是响应式的
// console.log(proxy);

const checkEmail = (rule, value, callback) => {
  if(!/^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/.test(value)) {
    return callback(new Error('邮箱格式错误'))
  }
  callback()
}
const state = reactive({
  tableDate: [],
  form: {},
  rules: {
    username: [
      { required: true, message: '请输入用户名', trigger: 'blur' },
      { min: 3, message: '最少输入3位', trigger: 'blur' }
    ],
    email: [
      { validator: checkEmail, trigger: 'blur' }
    ],
    address: [
      { required: true, message: '请输入地址', trigger: 'blur' },
      { max: 255, message: '最多输入255个字符', trigger: 'blur' }
    ]
  }
})

const load = () => {
  request.get("/user").then(res => {
    if (res.code === '200') {
      state.tableData = res.data
    }
  })
}
load()

const dialogFormVisible = ref(false)
const handleAdd = () => {
  dialogFormVisible.value = true
  state.form = {}  // 初始化数据
}

const handleEdit = (row) => {
  dialogFormVisible.value = true
  state.form = JSON.parse(JSON.stringify(row))
}

const save = () => {
  proxy.$refs.ruleFormRef.validate((valid) => {
    if (valid) {
      state.form.password = '123456'
      console.log(state.form)
      if (state.form.id) { // 如果id存在，那就是编辑
        // 请求后台接口
        request.put("/user", state.form).then(res => {
          if (res.code === '200') {
            ElMessage.success("保存成功")
            // 关闭弹窗
            dialogFormVisible.value = false
            // 刷新表格
            load()
          } else {
            ElMessage.error(res.msg)
          }
        })
      } else {
        // 请求后台接口
        request.post("/user", state.form).then(res => {
          if (res.code === '200') {
            ElMessage.success("保存成功")
            // 关闭弹窗
            dialogFormVisible.value = false
            // 刷新表格
            load()
          } else {
            ElMessage.error(res.msg)
          }
        })
      }
    }
  })
}

const deleteRow = (id) => {
  request.delete("/user/" + id).then(res => {  //  /user/1
    if (res.code === '200' && res.data === true) {
      ElMessage.success("删除成功")
    } else {
      ElMessage.success("删除失败")
    }
    // 刷新表格
    load()
  })
}
</script>
