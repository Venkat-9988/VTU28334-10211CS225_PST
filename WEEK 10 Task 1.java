import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

class Order {
    int orderId;
    int productId;
    int priority;

    Order(int orderId, int productId, int priority) {
        this.orderId = orderId;
        this.productId = productId;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Linear collection
        ArrayList<Product> products = new ArrayList<>();

        // Non-linear collection for fast product search
        HashMap<Integer, Product> productMap = new HashMap<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();

            Product p = new Product(id, name, price);
            products.add(p);
            productMap.put(id, p);
        }

        // Search product
        System.out.print("Enter product ID to search: ");
        int searchId = sc.nextInt();

        if (productMap.containsKey(searchId)) {
            System.out.println("Product Found: " + productMap.get(searchId));
        } else {
            System.out.println("Product Not Found");
        }

        // Priority Queue: higher priority first
        PriorityQueue<Order> orders =
            new PriorityQueue<>((a, b) -> b.priority - a.priority);

        System.out.print("Enter number of orders: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int orderId = sc.nextInt();
            int productId = sc.nextInt();
            int priority = sc.nextInt();

            orders.add(new Order(orderId, productId, priority));
        }

        System.out.println("Orders processed by priority:");

        while (!orders.isEmpty()) {
            Order o = orders.poll();

            System.out.println(
                "Order " + o.orderId +
                " Product " + o.productId +
                " Priority " + o.priority
            );
        }

        sc.close();
    }
}
