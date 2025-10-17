package duyvn.example;

import java.util.logging.Logger;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    private static final Logger LOG = Logger.getLogger(Circle.class.getName());
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        // Minh hoạ bằng logger thay vì System.out
        LOG.info(() -> "Drawing circle with radius = " + radius);
    }
}

public class UnimplementedInterfaceExample {
    public static void main(String[] args) {
        Drawable d = new Circle(5.0);
        d.draw();
    }
}
