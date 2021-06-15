

# 关于QuickProject

&ensp;&ensp;&ensp;&ensp;其基本思想是，对系统操作的各种权限不是直接授予具体的用户，而是在用户集合与权限集合之间建立一个角色集合。每一种角色对应一组相应的权限。一旦用户被分配了适当的角色后，该用户就拥有此角色的所有操作权限。这样做的好处是，不必在每次创建用户时都进行分配权限的操作，只要分配用户相应的角色即可，而且角色的权限变更比用户的权限变更要少得多，这样将简化用户的权限管理，减少系统的开销。



![UML](https://user-images.githubusercontent.com/28785691/117293954-a6b9dc00-aea4-11eb-8ec3-a51c7ffd1776.png)

## 表设计
![table](https://user-images.githubusercontent.com/28785691/117275552-baf3de00-ae90-11eb-88ef-bb73b1c2f231.png)

## 初始化
 首先安装redis,跑起来，application-dev.yml配置redis连接方式，用户名，密码。
 <br/>配置mysql或者其他数据库用户名密码，src/main/resources/sql/sys_admin.sql导入数据库。
 <br/>然后把QuickProject项目跑起来，
 <br/>最后访问http://localhost:11010/doc.html#/ 即可看到接口页面。
![1](https://user-images.githubusercontent.com/28785691/117138090-254b4680-addd-11eb-98d6-019557445b26.png)

其次是vue-admin-template，按照下面步骤部署，输入http://localhost:11020 即可看到项目
 <br/>默认登录用户名：admin，密码：123456
 

```bash
# 克隆项目
git clone https://github.com/Jimmey-Jiang/QuickProject_UI.git

# 进入项目目录
cd vue-admin-template

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装以来，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

## 项目相关截图

![9](https://user-images.githubusercontent.com/28785691/117138067-22505600-addd-11eb-879e-dab02ac5c214.png)
![10](https://user-images.githubusercontent.com/28785691/117138073-22e8ec80-addd-11eb-8053-44a5899bffe2.png)
![11](https://user-images.githubusercontent.com/28785691/117138077-23818300-addd-11eb-91ac-93e6b376f1d5.png)
![12](https://user-images.githubusercontent.com/28785691/117138080-241a1980-addd-11eb-91e2-199bc63d8b17.png)
![13](https://user-images.githubusercontent.com/28785691/117138084-24b2b000-addd-11eb-867f-66af54373634.png)
![2](https://user-images.githubusercontent.com/28785691/117138094-267c7380-addd-11eb-8525-2af3f7d8c76a.png)
![3](https://user-images.githubusercontent.com/28785691/117138099-27150a00-addd-11eb-9f2b-4f5b865c6fca.png)
![4](https://user-images.githubusercontent.com/28785691/117138103-27ada080-addd-11eb-8cd5-4f910a6714ee.png)
![5](https://user-images.githubusercontent.com/28785691/117138109-28decd80-addd-11eb-8e33-3a251c0ee5a5.png)
![6](https://user-images.githubusercontent.com/28785691/117138114-29776400-addd-11eb-92f2-119c6fe4a165.png)
![7](https://user-images.githubusercontent.com/28785691/117138049-1f556580-addd-11eb-9ff2-d45e2c893b4a.png)
![8](https://user-images.githubusercontent.com/28785691/117138063-211f2900-addd-11eb-8ff0-5d471b397915.png)
# 关于vue-admin-template
这是一个极简的 vue admin 管理后台。它只包含了 Element UI & axios & iconfont & permission control & lint，这些搭建后台必要的东西。


## Build Setup

```bash
# 克隆项目
git clone https://github.com/Jimmey-Jiang/QuickProject_UI.git

# 进入项目目录
cd vue-admin-template

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装以来，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

浏览器访问 [http://localhost:1120](http://localhost:1120)

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



