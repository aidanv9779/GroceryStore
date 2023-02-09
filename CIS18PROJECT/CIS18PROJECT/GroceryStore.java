package CIS18PROJECT;
import java.util.Scanner;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

public class GroceryStore {
    public static void main(String[] args) throws Exception {
        CIS18PROJECT.GroceryStoreFrame Swing = new GroceryStoreFrame();
        Swing.GroceryFrame();
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Store items and prices in an array
        String[] items = {"Apple", "Banana", "Orange", "Grapes"};
        double[] prices = {0.5, 0.25, 0.75, 1.5};

        // Display available items
        System.out.println("Available items and prices:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + " @ $" + prices[i]);
        }

        // Place an order
        System.out.println("Please select items and quantities to order:");
        Map<String, Integer> order = new HashMap<>();
        double total = 0;
        while (true) {
            System.out.print("Item (or 'done' to finish): ");
            String item = input.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            } 
            else {
                double price = 0;
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
                price = prices[index];
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                input.nextLine(); // consume newline character
                order.put(item, quantity);
                total += price * quantity;
            }
        }


        // Set delivery appointment
        System.out.print("Please enter a delivery date and time (dd/MM/yyyy HH:mm): ");
        Date deliveryTime = dateFormat.parse(input.nextLine());
        
        // check if the selected delivery time is valid
        if (order.isEmpty()) {
            System.out.println("No items were ordered.");
            return;
        }

        // Print order summary
        System.out.println("Order summary:");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            System.out.println(entry.getValue() + " x " + entry.getKey() + " @ $" + items.length);
        }
        System.out.println("Total: $" + total);
        System.out.println("Delivery time: " + dateFormat.format(deliveryTime));

        // Write order to file
        FileWriter writer = new FileWriter("order.txt");
        writer.write("Order placed on " + dateFormat.format(new Date()) + "\n");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            int index;
            writer.write(entry.getValue() + " x " + entry.getKey() + " @ $" + items.length + "\n");
        }
        writer.write("Total: $" + total + "\n");
        writer.write("Delivery time: " + dateFormat.format(deliveryTime) + "\n");
        writer.close();

        System.out.println("Thank you for your order!");
        input.close();
    }
}