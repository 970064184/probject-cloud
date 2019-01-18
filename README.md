## 前后端分离总体架构：

前端：springboot+th+bookstrap、（WebJars：springboot提供给前端的各种jar包）

后端：springcloud：eureka+ribbon+feign+zuul

springboot 1.5.16 、swagger2 2.5.5、springcloud Edgware.SR3

lombok、  mysql 、jpa

# 服务

- probject-cloud
  - 父项目
- probject-cloud-gateway-zuul
  - 网关


- probject-cloud-shiro 

  - 认证、鉴权


  - JWT
    - token生成和解析
    - token中包括userId 、过期时间
  - shiro
  - 必须要实现UserRoleAuthorityRepository接口

- probject-cloud-user

  - 登录