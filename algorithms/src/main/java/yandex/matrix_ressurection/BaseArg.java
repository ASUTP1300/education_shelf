package yandex.matrix_ressurection;

public class BaseArg {

    public static void main(String[] args) {
    }

    static class Cell{
        int row, col;

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
