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

# 升级啦

哎呀~~~

技术更新换代真快~~~

一不小心，低版本用不了很多新东西啦（例如，springboot admin、springcloud gateway。。。）

哎呀。。升级需谨慎，各种冲突(exclusion)，方法不支持，数据库配置不支持等等搞了两天:joy:

最坑爹的就是bootstrap.yml识别不了的问题，折腾了一天:sob:

- ```xml
  <!--需要引入该jar才能使bootstrap配置文件生效-->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-context</artifactId>
      </dependency>
  //或者用到springcloud的任何一个组件都包含了这个依赖
  //因为SpringBoot本身并不支持bootstrap.yml文件，（这和我学习springboot知识的时候颠覆了呀）需要和Spring Cloud 的组件结合——只有加上Spring Cloud Context依赖才能生效
  ```

- 升级springboot版本，springcloud版本

  - ```java
    springboot : 2.2.1.RELEASE
    springcloud : Hoxton.RELEASE
    swagger2
        
    ```

- 升级网关，用springcloud gateway代替zuul
- 用spring security 代替shiro
- 用auth2代替jwt