### 一、SpringBoot 简介

SpringBoot 是由 Pivotal 团队提供的全新框架，其设计目的是用来简化 Spring 应用的初始搭建以及开发过程。

我们在学习 Spring 的时候说过 Spring 框架是为了简化开发的，而 SpringBoot 是为了简化 Spring 开发的，由此可见，使用 SpringBoot 开发将会更加的方便简捷。

###### Spring Boot的主要特点

创建独立的Spring应用程序
直接嵌入Tomcat，Jetty或Undertow（无需部署WAR文件）
提供“初始”的POM文件内容，以简化Maven配置
尽可能时自动配置Spring
提供生产就绪的功能，如指标，健康检查和外部化配置
绝对无代码生成，也不需要XML配置
Spring Boot核心和限制
Spring Boot不是编写应用程序的框架，它可以帮助我们以最少的配置或零配置开发和构建，打包和部署应用程序。
它不是应用程序服务器。但是它是提供应用程序服务器功能的嵌入式servlet容器，而不是Spring Boot本身。类似地，Spring Boot不实现任何企业Java规范，例如JPA或JMS。 例如，Spring Boot不实现JPA，但它通过为JPA实现(例如Hibernate)自动配置适当的bean来支持JPA。最后，Spring Boot不使用任何形式的代码生成来完成它的功能。它是利用Spring 4的条件配置功能，以及Maven和Gradle提供的传递依赖关系解析，以在Spring应用程序上下文中自动配置bean。
简而言之，Spring Boot它的核心就是Spring。

###### Spring Boot优点和缺点

使用Java或Groovy开发基于Spring的应用程序非常容易。
它减少了大量的开发时间并提高了生产力。
它避免了编写大量的样板代码，注释和XML配置。
Spring Boot应用程序与其Spring生态系统(如Spring JDBC，Spring ORM，Spring Data，Spring Security等)集成非常容易。
它遵循“自用默认配置”方法，以减少开发工作量。
它提供嵌入式HTTP服务器，如Tomcat，Jetty等，以开发和测试Web应用程序非常容易。
它提供CLI(命令行界面)工具从命令提示符，非常容易和快速地开发和测试Spring Boot(Java或Groovy)应用程序。
它提供了许多插件来开发和测试Spring启动应用程序非常容易使用构建工具，如Maven和Gradle。
它提供了许多插件，以便与嵌入式和内存数据库工作非常容易。

###### Spring Boot的限制

将现有或传统的Spring Framework项目转换为Spring Boot应用程序是一个非常困难和耗时的过程。它仅适用于全新Spring项目。
未来的Spring项目不会有任何XML配置作为它的一部分，一切都将由项目Spring Boot处理。
[官方参考指南](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle)包括所有功能的详细说明，以及常见用法的详细说明。



### sprin-boot 学习过程

```java
├── 1.spring-boot-start
└── 2.spring-boot-config
```