# spring-boot 相关功能汇总学习

## web开发

### servlet相关

#### 通过API方式实现注册Servlet,Filter,Linster

1. 实现Servlet组件相关接口
```java
public class ApiServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    }
}
```

2. 通过ServletRegistrationBean加载Servlet组件
```java
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setName("ApiServlet");
        servletRegistrationBean.setServlet(new ApiServlet());
        servletRegistrationBean.addUrlMappings("/api/servlet/*");
        servletRegistrationBean.addInitParameter("initParam1","initValue1");
        servletRegistrationBean.setAsyncSupported(true);
        return  servletRegistrationBean;
    }
```


#### 通过Servlet3.0注解方式实现注册Servlet,Filter,Linster

1. 增加ServletComponentScan扫描入口  
```java
@ServletComponentScan(basePackages = "com.github.evan.springboot.web.servlet.annotation")
```

2. 实现Servlet组件相关接口

添加相关注解
- @WebServlet
- @WebFilter
- @WebListener
- @WebInitParam

```java
@WebServlet(name = "AnnoServlet", urlPatterns = "/annotaion/servlet/*",
        initParams = {
             @WebInitParam(name = "initParam1", value = "initValue1"),
             @WebInitParam(name = "initParam2", value = "initValue2")
            }
)
public class AnnoServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    }
}
```

### Spring MVC相关

#### 请求参数获取

#### 响应结果处理

#### 重定向

#### 异常处理

#### ???

- ContentNegotiatingViewResolver 
- BeanNameViewResolver
- ConfigurableWebBindingInitializer
- WebMvcRegistrations
- HttpMessageConverters
- MessageCodesResolver
- Welcome Page 静态和模板页面(index.html)
- Custom Favicon
- 内容协商
- WebBindingInitializer 


注解

```properties
spring.mvc.static-path-pattern=/resources/**
spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss
```


## 数据库

### 数据库连接

- 多数据源
- druid数据库连接池
- 内置数据HikariCp tomacat dbcp2
- JNDI

### 嵌入式数据库

- H2
- HSQL
- Derby

###  Spring Framework JdbcTemplate 

spring.data.template.*

### Spring Data JPA

### Mybatis 

通用MyBatis 框架