## Vue 3 + Vite

This template should help get you started developing with Vue 3 in Vite. The template uses Vue 3 `<script setup>` SFCs, check out the [script setup docs](https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup) to learn more.

### Recommended IDE Setup

- [VS Code](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar)

### 项目搭建

```shell
PS E:\Web\lighting> npm init vite@latest
Need to install the following packages:
  create-vite@latest
Ok to proceed? (y) y
√ Project name: ... vue
√ Select a framework: » vue
√ Select a variant: » vue

Scaffolding project in E:\Web\lighting\vue...

Done. Now run:

  cd vue
  npm install
  npm run dev

PS E:\Web\lighting\vue> npm install vue-router -S
added 2 packages in 2s

PS E:\Web\lighting\vue> npm i axios -S
added 8 packages in 2s
```

### Element plus

```shell
> npm install element-plus --save
> npm install @element-plus/icons-vue
```

### 数据库

数据库名称 lighting

基字符集 utf8mb4

数据库排序规则 utf8mb4_unicode_ci

```sql
-- 数据库备份
>mysqldump -hlocalhost -uroot -p123456 lighting > lighting.sql
-- 数据库恢复
>source lighting.sql
```

 