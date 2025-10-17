package duyvn.example;
import java.util.logging.Logger;

public class TightCouplingExample {

    // Abstraction for printing behavior
    interface Printer {
        void print(String message);
    }

    // Concrete implementation using a logger (no System.out)
    static final class ConsolePrinter implements Printer {
        private static final Logger LOG = Logger.getLogger(ConsolePrinter.class.getName());

        @Override
        public void print(String message) {
            // Use a Supplier to avoid eager concatenation (S3457)
            LOG.info(() -> message);
        }
    }

    // Depend on abstraction; inject dependency via constructor
    static final class Report {
        private final Printer printer;

        Report(Printer printer) {
            this.printer = printer;
        }

        void generate() {
            printer.print("Generating report...");
        }
    }

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Report report = new Report(printer);
        report.generate();
    }
}
