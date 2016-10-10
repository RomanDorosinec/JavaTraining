/**
 * brief
 * @author Dorosinec on 03.10.2016.
 */
public class HelloName {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check - entered the Name
        if (args.length != 0) {
            System.out.println("Hello, " + args[0]);
            // If a lot of names entered only the first
        } else {
            System.out.println("Your don't enter Name.");
        }
    }

    /**
     *
     */
}
