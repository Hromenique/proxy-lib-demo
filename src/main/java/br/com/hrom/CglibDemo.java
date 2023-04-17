package br.com.hrom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class CglibDemo implements ProxyDemo {

    @Override
    public String demoName() {
        return "GglibDemo";
    }

    @Override
    public Person getPersonProxyInstance() {
        return (Person) Enhancer.create(Person.class, new Interceptor());
    }

    private class Interceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("method: " + method);
            System.out.println("args: " + Arrays.toString(args));
//            System.out.println("obj: " + obj);
            System.out.println("proxy: " + proxy);
            System.out.println("proxySuperName: " + proxy.getSuperName());
            System.out.println("proxySignature: " + proxy.getSignature());
            System.out.println("--------------------------------------------------------------------");
            return proxy.invokeSuper(obj, args);
        }
    }
}
