## 项目说明
> 电影智能推荐系统采用典型的MVC架构。项目使用Java 语言作为后端编程语言，使用MYSQL作为数据库；智能推荐算法采用协同过滤算法，提供的推荐功能包括：视频推荐、好友推荐、圈子推荐等。此项目践行了前后端完全分离的原则，项目后端只提供RESTFUL接口，项目的前端使用Vue2开发，前端项目地址为：[https://github.com/firery/mirs-web-vue](https://github.com/firery/mirs-web-vue) 。项目前后端仅仅通过接口进行交互，后端接口地址为：[https://www.91film.top/api/swagger/index.html](https://www.91film.top/api/swagger/index.html)

## 项目配置

```
1. 定位到src/main/resources/properties/文件夹下
2. jdbc-example.properties --> jdbc-prod.properties 根据提示配置
3. mail-example.properties --> mail-prod.properties 根据提示配置
```

## 开发环境
| 软/硬件 | 版本 |
| :------: | :------: |
| Window | 10 |
| IntelliJ IDEA | 2016.2.2 |
| Tomcat | 9.0.0.M3|
| Oracle JDK| 1.8.0_72-b15 |
| Maven | 3.3.9 |
| MySQL | 8.0.0 |
| Redis | 3.2.100 |

## 部署环境
| 软/硬件 | 版本 |
| :------: | :------: |
| Centos(1核1g) | 7.2 |
| Tomcat | 9.0.0.M13|
| Nginx | 1.10.2 |
| Oracle JDK| 1.8.0_91-b14 |
| Maven | 3.3.9 |
| MySQL | 8.0.0 |
| Redis | 2.8.19-2 |
| Docker-engine | 1.12.3-1|
