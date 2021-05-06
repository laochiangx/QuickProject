

# 关于QuickProject

这个是一个RBAC权限管理框架，基于角色的访问控制（RBAC）是实施面向企业安全策略的一种有效的访问控制方式。
其基本思想是，对系统操作的各种权限不是直接授予具体的用户，而是在用户集合与权限集合之间建立一个角色集合。每一种角色对应一组相应的权限。一旦用户被分配了适当的角色后，该用户就拥有此角色的所有操作权限。这样做的好处是，不必在每次创建用户时都进行分配权限的操作，只要分配用户相应的角色即可，而且角色的权限变更比用户的权限变更要少得多，这样将简化用户的权限管理，减少系统的开销。

![UML](https://user-images.githubusercontent.com/28785691/117293954-a6b9dc00-aea4-11eb-8ec3-a51c7ffd1776.png)

## 表设计
![table](https://user-images.githubusercontent.com/28785691/117275552-baf3de00-ae90-11eb-88ef-bb73b1c2f231.png)

## 项目相关截图

![9](https://user-images.githubusercontent.com/28785691/117138067-22505600-addd-11eb-879e-dab02ac5c214.png)
![10](https://user-images.githubusercontent.com/28785691/117138073-22e8ec80-addd-11eb-8053-44a5899bffe2.png)
![11](https://user-images.githubusercontent.com/28785691/117138077-23818300-addd-11eb-91ac-93e6b376f1d5.png)
![12](https://user-images.githubusercontent.com/28785691/117138080-241a1980-addd-11eb-91e2-199bc63d8b17.png)
![13](https://user-images.githubusercontent.com/28785691/117138084-24b2b000-addd-11eb-867f-66af54373634.png)
![1](https://user-images.githubusercontent.com/28785691/117138090-254b4680-addd-11eb-98d6-019557445b26.png)
![2](https://user-images.githubusercontent.com/28785691/117138094-267c7380-addd-11eb-8525-2af3f7d8c76a.png)
![3](https://user-images.githubusercontent.com/28785691/117138099-27150a00-addd-11eb-9f2b-4f5b865c6fca.png)
![4](https://user-images.githubusercontent.com/28785691/117138103-27ada080-addd-11eb-8cd5-4f910a6714ee.png)
![5](https://user-images.githubusercontent.com/28785691/117138109-28decd80-addd-11eb-8e33-3a251c0ee5a5.png)
![6](https://user-images.githubusercontent.com/28785691/117138114-29776400-addd-11eb-92f2-119c6fe4a165.png)
![7](https://user-images.githubusercontent.com/28785691/117138049-1f556580-addd-11eb-9ff2-d45e2c893b4a.png)
![8](https://user-images.githubusercontent.com/28785691/117138063-211f2900-addd-11eb-8ff0-5d471b397915.png)
# 关于vue-admin-template
这是一个极简的 vue admin 管理后台。它只包含了 Element UI & axios & iconfont & permission control & lint，这些搭建后台必要的东西。

[线上地址](http://panjiachen.github.io/vue-admin-template)

[国内访问](https://panjiachen.gitee.io/vue-admin-template)

目前版本为 `v4.0+` 基于 `vue-cli` 进行构建，若你想使用旧版本，可以切换分支到[tag/3.11.0](https://github.com/PanJiaChen/vue-admin-template/tree/tag/3.11.0)，它不依赖 `vue-cli`。

## Extra

如果你想要根据用户角色来动态生成侧边栏和 router，你可以使用该分支[permission-control](https://github.com/PanJiaChen/vue-admin-template/tree/permission-control)

## 相关项目

- [vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)

- [electron-vue-admin](https://github.com/PanJiaChen/electron-vue-admin)

- [vue-typescript-admin-template](https://github.com/Armour/vue-typescript-admin-template)

- [awesome-project](https://github.com/PanJiaChen/vue-element-admin/issues/2312)



## Build Setup

```bash
# 克隆项目
git clone https://github.com/PanJiaChen/vue-admin-template.git

# 进入项目目录
cd vue-admin-template

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装以来，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

浏览器访问 [http://localhost:9528](http://localhost:1120)

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```

## 其它

```bash
# 预览发布环境效果
npm run preview

# 预览发布环境效果 + 静态资源分析
npm run preview -- --report

# 代码格式检查
npm run lint

# 代码格式检查并自动修复
npm run lint -- --fix
```

更多信息请参考 [使用文档](https://panjiachen.github.io/vue-element-admin-site/zh/)


## Browsers support

Modern browsers and Internet Explorer 10+.

| [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/edge/edge_48x48.png" alt="IE / Edge" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)</br>IE / Edge | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png" alt="Firefox" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)</br>Firefox | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png" alt="Chrome" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)</br>Chrome | [<img src="https://raw.githubusercontent.com/alrra/browser-logos/master/src/safari/safari_48x48.png" alt="Safari" width="24px" height="24px" />](http://godban.github.io/browsers-support-badges/)</br>Safari |
| --------- | --------- | --------- | --------- |
| IE10, IE11, Edge| last 2 versions| last 2 versions| last 2 versions

## License

[MIT](https://github.com/PanJiaChen/vue-admin-template/blob/master/LICENSE) license.

Copyright (c) 2017-present PanJiaChen
