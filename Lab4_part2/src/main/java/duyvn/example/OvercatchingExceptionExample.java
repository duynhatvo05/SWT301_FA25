package duyvn.example;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    private static final Logger LOG =
            Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            int idx = 10; // cố ý lỗi để minh hoạ

            // thay System.out bằng logger (và dùng Supplier để tránh concat eager)
            LOG.info(() -> "Accessing arr[" + idx + "] with length=" + arr.length);

            // ném ArrayIndexOutOfBoundsException
            int value = arr[idx];
            LOG.info(() -> "Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) { // thu hẹp phạm vi catch
            // log chuẩn kèm stacktrace, tránh System.out
            LOG.log(Level.SEVERE, e, () -> "Array index out of bounds while accessing array");
        }
    }
}

