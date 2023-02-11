public class CountingLoopWeek2 {
    public static void main(String[] args) {
        String numberType = "";
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                numberType = "even";
            } else {
                numberType = "odd";
            }
            System.out.println(i + "\t" + numberType);
        }
    }
}
