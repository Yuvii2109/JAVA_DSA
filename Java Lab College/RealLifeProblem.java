import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealLifeProblem {
    // Product Class
    static class Product {
        private int id;
        private String name;
        private double price;
        private int quantityAvailable;

        public Product(int id, String name, double price, int quantityAvailable) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantityAvailable = quantityAvailable;
        }

        public double getPrice(){ 
            return price; 
        }
        public String getName(){ 
            return name; 
        }
        public int getId(){ 
            return id; 
        }
        public int getQuantityAvailable(){ 
            return quantityAvailable; 
        }
        public void reduceStock(int quantity){
            if (quantity <= quantityAvailable) {
                this.quantityAvailable -= quantity;
            } else {
                System.out.println("Not enough stock available for " + name);
            }
        }
    }

    // CartItem Class
    static class CartItem{
        public Product product;
        public int quantity;

        public CartItem(Product product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }

        public double getTotalPrice(){
            return product.getPrice() * quantity;
        }
    }

    // Cart Class
    static class Cart{
        private List<CartItem> items;

        public Cart(){
            this.items = new ArrayList<>();
        }

        public void addItem(Product product, int quantity){
            if (quantity > product.getQuantityAvailable()){
                System.out.println("Not enough stock for " + product.getName());
                return;
            }
            items.add(new CartItem(product, quantity));
            product.reduceStock(quantity);
        }

        public double calculateTotal(){
            double total = 0;
            for (CartItem item : items){
                total += item.getTotalPrice();
            }
            return total;
        }
    }

    // BalanceCalculator Class
    class BalanceCalculato
        public static double calculateBalance(double amountPaid, double totalCartAmount) {
            return amountPaid - totalCartAmount;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Product p1 = new Product(1, "Rice", 50, 100);
        Product p2 = new Product(2, "Sugar", 40, 100);
        Product p3 = new Product(3, "Wheat", 60, 50);

        List<Product> productList = List.of(p1, p2, p3);
        Cart cart = new Cart();

        System.out.println("Available Products - ");
        for (Product p : productList){
            System.out.println(p.getId() + ". " + p.getName() + " - Rs." + p.getPrice() + " (Stock - " + p.getQuantityAvailable() + ")");
        }

        while (true){
            System.out.print("Enter product ID to add to cart (or 0 to finish) - ");
            int id = sc.nextInt();
            if (id == 0) break;

            Product selectedProduct = null;
            for (Product p : productList){
                if (p.getId() == id) {
                    selectedProduct = p;
                    break;
                }
            }

            if (selectedProduct == null){
                System.out.print("Invalid product ID...");
                continue;
            }

            System.out.print("Enter quantity - ");
            int qty = sc.nextInt();
            cart.addItem(selectedProduct, qty);
        }

        double total = cart.calculateTotal();
        System.out.println("Total Cart Amount - Rs." + total);

        System.out.print("Enter amount paid by the buyer - ");
        double amountPaid = sc.nextDouble();

        double balance = BalanceCalculator.calculateBalance(amountPaid, total);

        if (balance < 0){
            System.out.println("Insufficient payment... Buyer needs to pay Rs." + (-balance) + " more.");
        } else{
            System.out.println("Balance to be returned - Rs." + balance);
        }
        sc.close();
    }
}