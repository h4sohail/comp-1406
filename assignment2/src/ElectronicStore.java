import java.util.Scanner;

public class ElectronicStore{
    final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue = 0;
    private Product[] products = new Product[MAX_PRODUCTS];

    public ElectronicStore(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public double getRevenue(){ return revenue; }

    public boolean addProduct(Product p) {
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            if(products[i] == null){
                products[i] = p;
                return true;
            }
        }
        return false;
    }

    public void printStock(){
        for(int i = 0; i < MAX_PRODUCTS; i++) {
            if(products[i] != null){
                System.out.println(i + ") " + products[i]);
            }
        }
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < 10 && products[index] != null;
    }

    public boolean isValidQuantity(int quantity, Product p) {
        return quantity > 0 && quantity <= p.getStockQuantity();
    }

    public void sellProducts(int item, int amount) {
        if(isValidIndex(item)){
            Product p = products[item];
            if(isValidQuantity(amount, p)){
                revenue += p.sellUnits(amount);
                p.setSoldQuantity(amount);
            }
        }
        else{
            System.out.println("Invalid input!");
        }
    }

   public void sellProducts() {
        printStock();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the item index: ");
        int item = sc.nextInt();
        System.out.print("Input the quantity: ");
        int amount = sc.nextInt();

        sellProducts(item, amount);
    }
}
