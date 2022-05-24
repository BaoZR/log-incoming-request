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

如果要实现在请求中记录时间,可以通过对HandlerInterceptorAdapter的继承，
在preHandle记录开始时间，在afterCompletion记录结束的时间，两个时间相减得到运行的时间。设置记录时间的方法可以用threadlocal也可以使用往request里设置字段的方法。

文中先是使用了Interceptor,然后使用了filter,
这样做的原因是对于非x-www-form-urlencoded的post请求体，
只能用getInputStream()获取流的具体内容，而getInputStream()输入请求的流只能读取一次，
如果想实现流的多次读取，
就要把流写回，就只能用到filter了，在这里用的是springboot提供的CommonsRequestLoggingFilter
（通用请求日志过滤器）。

