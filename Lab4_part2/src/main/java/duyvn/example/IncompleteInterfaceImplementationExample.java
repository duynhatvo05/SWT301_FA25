package duyvn.example;
import java.util.logging.Logger;

interface Shape {
    void draw();
    void resize();
}

class Square implements Shape {
    private static final Logger LOG = Logger.getLogger(Square.class.getName());
    private int side;

    Square(int side) {
        this.side = side;
    }

    @Override
    public void draw() {
        LOG.info(() -> "Drawing square, side = " + side);
    }

    @Override
    public void resize() {
        side = side * 2; // example behavior
        LOG.info(() -> "Resized square, new side = " + side);
    }
}

public class IncompleteInterfaceImplementationExample {
    public static void main(String[] args) {
        Square sq = new Square(5);
        sq.draw();
        sq.resize();
    }
}

