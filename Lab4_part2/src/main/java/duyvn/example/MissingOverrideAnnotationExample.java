package duyvn.example;

import java.util.logging.Logger;

class Animal {
    private static final Logger LOG = Logger.getLogger(Animal.class.getName());

    void speak() {
        LOG.info("Animal speaks");
    }
}

class Dog extends Animal {
    private static final Logger LOG = Logger.getLogger(Dog.class.getName());

    @Override
    void speak() {
        LOG.info("Dog barks");
    }
}

public class MissingOverrideAnnotationExample {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.speak();

        Animal d = new Dog();
        d.speak();
    }
}

