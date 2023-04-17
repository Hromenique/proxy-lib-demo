package br.com.hrom;

/**
 * @author Hromenique Cezniowscki Leite Batista
 **/
public class Person {

    private String name;
    private String documentNumber;
    private int age;

    public Person() {
    }

    public Person(String name, String documentNumber, int age) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
