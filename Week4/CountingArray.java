package Week4;
public class CountingArray {
    public static void main(String[] args) {
        // Create an array of length 100 and fill it with the numbers 1-100
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // For each number in the array of numbers, check whether a number is
        // even or odd, and then print out the number and it's evenness
        String numberType = "";
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                numberType = "even";
            } else {
                numberType = "odd";
            }
            System.out.println(numbers[i] + "\t" + numberType);
        }
    }
}
