package GenericsComparing;

public class Person implements Comparable{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person entry = (Person) o;

        int result = name.compareTo(entry.name);

        if(result != 0) {
            return result;
        }

        result = age - entry.age;
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        return 0;
    }
}
