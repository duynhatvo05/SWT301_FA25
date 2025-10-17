package duyvn.example;
import java.util.logging.Logger;

class User {
    private static final Logger LOG = Logger.getLogger(User.class.getName());

    private final String name;
    private final int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() { return name; }
    int getAge() { return age; }

    void display() {
        LOG.info(() -> "Name: " + name + ", Age: " + age);
    }
}

public class ViolationOfEncapsulationExample {
    public static void main(String[] args) {
        User u = new User("Alice", 21);
        u.display();
    }
}

