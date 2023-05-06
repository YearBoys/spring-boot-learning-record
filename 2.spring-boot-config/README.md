# SpringBoot多环境配置

> 多配置文件 包含开发,测试，生产 环境的配置文件  既读取配置文件中自定义信息

#### **目录结构**

```
.
├── 2.spring-boot-config.iml
├── README.md
├── http
│   └── generated-requests.http
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── yc
│   │   │           ├── SpringBootConfig.java
│   │   │           ├── bean
│   │   │           │   └── ConfigBean.java
│   │   │           └── controller
│   │   │               └── IndexController.java
│   │   └── resources
│   │       ├── application-dev.yml
│   │       ├── application-prod.yml
│   │       ├── application-test.yml
│   │       └── application.yml
