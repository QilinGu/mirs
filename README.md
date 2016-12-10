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

## Nginx配置
```
user  nginx;
worker_processes  1;

error_log  /var/log/nginx/error.log warn;
pid        /var/run/nginx.pid;


events {
    use epoll;
    worker_connections  1024;
}


http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    include /etc/nginx/conf.d/*.conf;

    upstream mirs {
        server 127.0.0.1:8080;
    }

    server {
        listen 80;
        server_name 91film.top;
        return 301 https://www.$host$request_uri;
    }

    server {
        listen 80;
        server_name www.91film.top;
        return 301 https://$host$request_uri;
    }

    limit_req_zone $binary_remote_addr zone=one:10m rate=1r/s;
    server {
        listen 443;
        server_name www.91film.top;
        access_log /var/log/nginx/mirs_access.log;
        ssl on;
        ssl_certificate /usr/local/sslkey/213936820630408.pem;
        ssl_certificate_key /usr/local/sslkey/213936820630408.key;
        ssl_session_timeout 5m;
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
        ssl_ciphers AESGCM:ALL:!DH:!EXPORT:!RC4:+HIGH:!MEDIUM:!LOW:!aNULL:!eNULL;
        ssl_prefer_server_ciphers on;

        location / {
            limit_req      zone=one burst=10 nodelay;
            root /home/mirs;
            try_files $uri $uri/ /index.html;
        }

        location /api {
            proxy_pass http://mirs;
            proxy_read_timeout 300;
            proxy_connect_timeout 300;
            proxy_redirect     off;

            proxy_set_header   X-Forwarded-Proto $scheme;
            proxy_set_header   Host              $http_host;
            proxy_set_header   X-Real-IP         $remote_addr;
        }
    }
}

```
