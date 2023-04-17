# Proxy Libs Demo

A simple demonstration of libraries of code generation that can be used to creation of proxies 
and interception of call to the method of some object.
This demonstration uses 3 libraries:
- Cglib
- Java Assist
- Byte Buddy

To each library was created an implementation of `ProxyDemo`. This interface represents the demonstration 
of creation of a proxy to `Person` that intercepts call to its methods.

The class Main is just a startup to call all the demos. 
To each instance of `ProxyDemo`, it's created an instance (proxy)
of `Person` and it's called all getters and setters. In console, we can see the interceptions.

``` java
Person personProxy = proxyDemo.getPersonProxyInstance();
personProxy.setName("Fulano");
personProxy.setDocumentNumber("123456");
personProxy.setAge(39);

System.out.println("person name: " + personProxy.getName());
System.out.println("person document number: " + personProxy.getDocumentNumber());
System.out.println("person age: " + personProxy.getAge());
```