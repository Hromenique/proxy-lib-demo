package br.com.hrom;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static br.com.hrom.SneakThrow.sneakyThrow;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class JavassistDemo implements ProxyDemo {

    @Override
    public String demoName() {
        return "JavassistDemo";
    }

    @Override
    public Person getPersonProxyInstance() {
        try {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setSuperclass(Person.class);
            proxyFactory.setFilter(method -> !Modifier.isAbstract(method.getModifiers()));
            Person personProxy = (Person) proxyFactory.createClass().newInstance();
            ((Proxy) personProxy).setHandler(new JavassitDemoMethodHandler());
            return personProxy;
        } catch (InstantiationException | IllegalAccessException ex) {
            return sneakyThrow(ex);
        }

    }
}

class JavassitDemoMethodHandler implements MethodHandler {

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("method: " + thisMethod);
        System.out.println("proceedMethod: " + proceed);
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("--------------------------------------------------------------------");
        return proceed.invoke(self, args);
    }
}
