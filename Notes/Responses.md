
# Day 02

## What's the difference between a Framework and a Library?
1. Libraries provide specific functionalities or tools that developers can use selectively in their applications.
   Frameworks provide a comprehensive structure and environment for building applications, often including libraries, and enforce a particular way of designing and developing applications.


## What's a Bean?
2. Beans are Java objects that are instantiated, assembled, and managed by the Spring IoC container. To define a bean in Spring Boot, you typically use annotations such as @Component,         @Service,  @Repository, or @Controller on a Java class. Once a class is marked as a bean, it can be injected or autowired into other beans or components, allowing for loose coupling and easy integration.

## What's a Component?
3. A component in Spring Boot is a class marked with one of the specialized stereotype annotations (@Component, @Service, @Repository, @Controller). These annotations help define the role and purpose of the class within the application and enable Spring Boot's IoC container to manage and wire the components together.

## What's Singleton?
4. In Spring Boot, a "singleton" is a design pattern and a scope for bean instances within the Spring IoC (Inversion of Control) container. A singleton bean is a bean that has a single instance per Spring IoC container. The container creates and caches the singleton bean, serving the same instance for all requests, by default or when explicitly configured with the @Scope("singleton") annotation.

## What's Singleton Scope and Prototype Scope? 
5. Singleton is the default scope in Spring Boot. When a bean is configured with the singleton scope, the container creates a single instance of the bean and shares it throughout the application. Any subsequent requests for the bean will be served from the cached instance. This means that all references to the singleton bean within the application point to the same object instance.
The prototype scope, as the name suggests, creates a new instance of the bean each time it is requested from the container. Unlike the singleton scope, each request for a prototype bean results in a new and independent instance being created. Subsequent requests for the bean will always generate a new instance.
In summary, the singleton scope in Spring Boot creates a single shared instance of a bean, while the prototype scope creates a new instance of the bean for each request. The choice between singleton and prototype scope depends on the specific requirements of the bean and how it should be managed in terms of state and instance sharing.

