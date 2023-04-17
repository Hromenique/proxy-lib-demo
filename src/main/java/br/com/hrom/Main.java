package br.com.hrom;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class Main {
    public static void main(String[] args) {

        List<ProxyDemo> proxyDemos = Arrays.asList(
                new CglibDemo(),
                new ByteBuddyDemo(),
                new JavassistDemo()
        );

        proxyDemos.forEach(proxyDemo -> {
            System.out.printf("start of %s %n", proxyDemo.demoName());

            Person personProxy = proxyDemo.getPersonProxyInstance();
            personProxy.setName("Fulano");
            personProxy.setDocumentNumber("123456");
            personProxy.setAge(39);

            System.out.println("person name: " + personProxy.getName());
            System.out.println("person document number: " + personProxy.getDocumentNumber());
            System.out.println("person age: " + personProxy.getAge());

            System.out.printf("end of %s %n", proxyDemo.demoName());
            System.out.println("======================================================================================\n");
        });
    }
}


