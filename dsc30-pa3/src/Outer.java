public class Outer {
    private int number1 = 5;

    private class Inner {
        private int number2 = 10;

        public int add() {
            return number1+number2;
        }
    }
}
