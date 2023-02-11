public class HelloWorldWeek1 {
    public static void main(String[] args) {
        // My information
        String name = "Jackson";
        String age = "15";

        // Store my family's information in arrays to make printing it less repetitive
        String[] parents = { "Jennifer", "Jason" };
        String[] siblings = { "Ava", "Graeson", "Elise" };

        // Print my information
        System.out.println("Hello World!");
        System.out.println("My name is " + name + ", and I am " + age + " years old.");

        // Print my family's info
        System.out.println("My parents' names are " + parents[0] + " and " + parents[1] + ".");

        // Print my siblings information
        System.out.println("My siblings' names are " + siblings[0] + ", " + siblings[1] + ", and "
                + siblings[2] + ".");
    }
}