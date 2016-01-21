# 자바 웹 개발 프레임워크 교육

# Spring MVC Framework

## 실습

### `git clone https://github.com/dongmyo/JavaWebFramework2.git`

## Spring MVC Components

* HandlerMapping
    * 서버로 들어온 요청을 어느 핸들러로 전달할 지 결정하는 역할
    * BeanNameUrlHandlerMapping, SimpleUrlHandlerMapping, RequestMappingHandlerMapping
* HandlerAdapter
    * DispatcherServlet과 실제 핸들러 구현체 사이를 이어주는 Object Adapter 역할
    * HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, AnnotationMethodHandlerAdapter, RequestMappingHandlerAdapter
* HandlerExceptionResolver
    * 요청 처리 과정에서 발생하는 예외를 제어하고자 할 때 사용
* RequestToViewNameTranslator
    * 핸들러가 아무것도 리턴하지 않았을 때 view 이름을 결정하는 역할

## Spring MVC Components (Cont.)

* ViewResolver
    * 문자열 기반의 view 이름을 토대로 실제 View 구현체를 결정하는 역할
    * InternalResourceViewResolver, VelocityViewResolver, FreemarkerViewResolver
* LocaleResolver / LocaleContextResolver
    * view 렌더링 시 국제화 지원을 위한 Locale과 Timezone을 결정하는 역할
    * AcceptHeaderLocaleResolver, CookieLocaleResolver, SessionLocaleResolver
* ThemeResolver
    * view 렌더링 시 어떤 테마를 사용할 지 결정하는 역할
    * CookieThemeResolver, FixedThemeResolver, SessionThemeResolver
* MultipartResolver
    * 멀티파트 요청에 대한 구현체를 결정하는 역할
    * CommonsMultipartResolver, StandardServletMultipartResolver
* FlashMapManager
    * redirect와 같이 하나의 요청에서 다른 요청으로 속성 값을 전달하는데 FlashMap을 사용할 수 있는 메커니즘을 제공

## DispatcherServlet.properties

* default implementation classes for DispatcherServlet's strategy interfaces
* used as fallback when no matching beans are found in the DispatcherServlet context
* not meant to be customized by application developers.

### ex.)

* `LocaleResolver` - AcceptHeaderLocaleResolver
* `HandlerMapping` - BeanNameUrlHandlerMapping, _DefaultAnnotationHandlerMapping_
* `HandlerAdapter` - HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, _AnnotationMethodHandlerAdapter_
* ViewResolver - InternalResourceViewResolver

## `<mvc:annotation-driven />` 또는 `@EnableWebMvc`

* `HandlerMapping` - RequestMappingHandlerMapping
* `HandlerAdapter` - RequestMappingHandlerAdapter


## 실습: 완성본

### `git checkout feature/spring-mvc`
