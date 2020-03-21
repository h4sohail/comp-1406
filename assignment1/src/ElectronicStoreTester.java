import java.util.Scanner;

public class ElectronicStoreTester {
    public static void main(String[] args) {
        ElectronicStore bestBuy = new ElectronicStore("Best Buy");
        bestBuy.printStock();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a term to search: ");
            String searchStr = sc.nextLine();
            searchStr = searchStr.toLowerCase();
            if (searchStr.equals("quit")) {
                break;
            } else {
                if (bestBuy.searchStock(searchStr)) {
                    System.out.println("A match was found in the inventory");
                } else {
                    System.out.println("A match was not found in the inventory");
                }
            }
        }
    }
}
