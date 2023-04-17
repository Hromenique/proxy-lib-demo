package br.com.hrom;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.This;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static br.com.hrom.SneakThrow.sneakyThrow;
import static net.bytebuddy.matcher.ElementMatchers.isAbstract;
import static net.bytebuddy.matcher.ElementMatchers.not;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class ByteBuddyDemo implements ProxyDemo {

    @Override
    public String demoName() {
        return "ByteBuddy Demo";
    }

    @Override
    public Person getPersonProxyInstance() {
        try {
            return new ByteBuddy()
                    .subclass(Person.class)
                    .method(not(isAbstract()))
                    .intercept(MethodDelegation.to(ByteBuddyDemoInterceptor.class))
                    .make()
                    .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            return sneakyThrow(ex);
        }
    }
}

