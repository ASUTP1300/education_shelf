package exception_;

public class TryCatch {

    public static void main(String[] args) {
        int i = 0;

        for (i = 0; i < 10; i++) {
            try {

                    throw new RuntimeException();


            } catch (Exception e) {
                if (i < 4) {
                    System.out.println("Еще рано.. " + i);
                    continue;
                } else {
                    throw new RuntimeException("Бабах");
                }
            }
        }
    }

    static void throwWhen(boolean isThrow) throws RuntimeException {
        if (isThrow) {
            throw new RuntimeException("Throwing...");
        }
    }
}
