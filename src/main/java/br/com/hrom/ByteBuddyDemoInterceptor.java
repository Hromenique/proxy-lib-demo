package br.com.hrom;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.This;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class ByteBuddyDemoInterceptor {

    @RuntimeType
    public static Object intercept(@This Object self,
                                   @Origin Method method,
                                   @AllArguments Object[] args,
                                   @SuperMethod Method superMethod) throws InvocationTargetException, IllegalAccessException {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("self: " + self.getClass());
        System.out.println("method: " + method);
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("superMethod: " + superMethod);
        System.out.println("--------------------------------------------------------------------");


        return superMethod.invoke(self, args);

    }
}
