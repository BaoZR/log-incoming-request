## Spring Boot Runtime

This module contains articles about administering a Spring Boot runtime

### Relevant Articles:									
 - [Shutdown a Spring Boot Application](https://www.baeldung.com/spring-boot-shutdown)
 - [Programmatically Restarting a Spring Boot Application](https://www.baeldung.com/java-restart-spring-boot-app)
 - [Logging HTTP Requests with Spring Boot Actuator HTTP Tracing](https://www.baeldung.com/spring-boot-actuator-http)
 - [Spring Boot Embedded Tomcat Logs](https://www.baeldung.com/spring-boot-embedded-tomcat-logs) 
 - [Project Configuration with Spring](https://www.baeldung.com/project-configuration-with-spring)
 - [Spring – Log Incoming Requests](https://www.baeldung.com/spring-http-logging)
 - [How to Configure Spring Boot Tomcat](https://www.baeldung.com/spring-boot-configure-tomcat)


感想：

1. 要实现在请求中记录时间的需求,可以通过HandlerInterceptorAdapter继承的办法，
在preHandle记录开始时间，在afterCompletion记录结束的时间，前后两个时间相减得到运行时间。另一种设置记录时间的方法是用threadlocal往request里设置字段的办法。

2. 原文中先使用Interceptor,然后使用filter,
这样做的原因是对于非x-www-form-urlencoded的post请求体，
只能用getInputStream()获取流的具体内容。这里有个问题，而getInputStream()输入请求的流只能读取一次。
如果想实现流的多次读取，
就要把流写回去，就只能用到filter了，在这里用的是springboot提供的CommonsRequestLoggingFilter
（通用请求日志过滤器）。

