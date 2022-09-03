## README

### Vite+Vue

+ `setup`语法糖
+ 内置函数`ref`和`reactive`的使用
+ 引用表单验证，实现表单校验
+ 封装`request.js`
+ 使用`request`对象请求后台

### 前端请求
404：请求的接口不存在
405 错误：表示资源请求的方式不对，比如后台接口是POST，而前端使用了 GET请求，这时候就出现了405 的Http错误
400 错误：表示你的请求参数不符合后台接口的要求

### 组件

[Table 表格](https://element-plus.gitee.io/zh-CN/component/table.html)

[Button 按钮](https://element-plus.gitee.io/zh-CN/component/button.html)

[Icon 图标](https://element-plus.gitee.io/zh-CN/component/icon.html)

[Dialog 对话框](https://element-plus.gitee.io/zh-CN/component/dialog.html)

### dialog表单

- 完成前端 dialog表单数据的校验
- 完成前端新增数据接口的调用
- 完成数据的刷新
-  state.form = JSON.parse(JSON.stringify(row)) 实现了数据的转让
- 新增的时候注意初始化数据
- 保存的时候如何区分编辑还是新增？
- request.delete()  这个你改了吗？ 接口的请求方式要注意
- 使用`el-popconfirm` 来保护删除按钮