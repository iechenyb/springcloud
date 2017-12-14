1 注册 
 http://localhost:8080/users/signup
 请求数据  raw
 {
    "username": "admin",
    "password": "password"
}

2 默认登录login 自定义登录 users/login
 http://localhost:8080/login
  请求参赛  raw
 {
    "username": "admin",
    "password": "password"
}

3 访问url 
http://localhost:8080/home  admin和user都能访问
http://localhost:8080/admin 只有admin能够访问
http://localhost:8080/user 只有user能够访问
4 http://localhost:8080/exit 退出系统
1.1集成hibernate，security、druid、swagger,anjularjs,事务等等
1.1简洁版  无xml引入。
1.2 引入xml文件
1.3 集成quartz，redis
1.4 新：集成zookeeper+dubbo

