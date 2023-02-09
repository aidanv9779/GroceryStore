import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

public class GroceryStore {
    private static final String[] ITEMS = {"Apple", "Banana", "Orange", "Grapes"};
    private static final double[] PRICES = {0.5, 0.25, 0.75, 1.5};
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Available items and prices:");
        for (int i = 0; i < ITEMS.length; i++) {
            System.out.println(ITEMS[i] + " @ $" + PRICES[i]);
        }

        System.out.println("Please select items and quantities to order:");
        Map<String, Integer> order = new HashMap<>();
        double total = 0;
        while (true) {
            System.out.print("Item (or 'done' to finish): ");
            String item = input.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            }
            int index = -1;
            switch (item) {
                case "Apple":
                    index = 0;
                    break;
                case "Banana":
                    index = 1;
                    break;
                case "Orange":
                    index = 2;
                    break;
                case "Grapes":
                    index = 3;
                    break;
                default:
                    System.out.println("Invalid item. Please try again.");
                    continue;
            }
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            input.nextLine();
            order.put(item, quantity);
            total += PRICES[index] * quantity;
        }

        if (order.isEmpty()) {
            System.out.println("No items were ordered.");
            return;
        }

        System.out.print("Please enter a delivery date and time (dd/MM/yyyy HH:mm): ");
        Date deliveryTime = DATE_FORMAT.parse(input.nextLine());
        System.out.println("Order summary:");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            System.out.println(entry.getValue() + " x " + entry.getKey() + " @ $" + PRICES[index]);
        }
        System.out.println("Total: $" + total);
        System.out.println("Delivery time: " + DATE_FORMAT.format(deliveryTime));

        FileWriter writer = new FileWriter("order.txt");
        writer.write("Order placed on " + DATE_FORMAT.format(new Date()) + "\n");
        for (Map.Entry<String, Integer> entry : order.entrySet
        System.out.println("Order written to file 'order.txt'");
    }
    
    private static int getIndex(String item) {
        for (int i = 0; i < ITEMS.length; i++) {
            if (ITEMS[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    