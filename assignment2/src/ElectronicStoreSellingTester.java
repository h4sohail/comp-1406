public class ElectronicStoreSellingTester extends ElectronicStoreStockTester{
  public static void main(String[] args){
    ElectronicStore store1 = createStore1();
    ElectronicStore store2 = createStore2();
    ElectronicStore store3 = createStore3();
    
    System.out.println(store1.getName() + "'s Starting Stock Is:");
    store1.printStock();
    System.out.println();
    System.out.println(store2.getName() + "'s Starting Stock Is:");
    store2.printStock();
    System.out.println();
    System.out.println(store3.getName() + "'s Starting Stock Is:");
    store3.printStock(); 
    System.out.println();
    
    store1.sellProducts(0, 5); //0500 dollars
    store1.sellProducts(0, 4); //0400 dollars
    store1.sellProducts(0, 2); //0000 dollars (not enough stock)
    store1.sellProducts(3, 5); //1250 dollars
    store1.sellProducts(3, 5); //1250 dollars
    store1.sellProducts(7, 10);//0750 dollars
    store1.sellProducts(0, 1); //0100 dollars
    store1.sellProducts(0, 1); //0000 dollars
    //Total revenue:             4250 dollars
        
    store2.sellProducts(0, 5); //0750 dollars
    store2.sellProducts(0, 1); //0000 dollars
    store2.sellProducts(1, 0); //0000 dollars
    store2.sellProducts(1, 1); //0250 dollars
    store2.sellProducts(2, 5); //0500 dollars
    store2.sellProducts(2, 10);//1000 dollars
    store2.sellProducts(8, 1); //0000 dollars
    store2.sellProducts(37, 1);//0000 dollars
    store2.sellProducts(0, -4);//0000 dollars
    //Total revenue:             2500 dollars
    
    store3.sellProducts(1, 15); //2250 dollars
    store3.sellProducts(2, 5);  //1750 dollars
    store3.sellProducts(4, 4);  //1000 dollars
    store3.sellProducts(1, 1);  //0000 dollars
    store3.sellProducts(5, 5);  //1375 dollars
    store3.sellProducts(9, 3);  //0450 dollars
    store3.sellProducts(9, 4);  //0600 dollars
    store3.sellProducts(11, 1); //0000 dollars
    //Total revenue:              7425 dollars

    System.out.println(store1.getName() + "'s Ending Stock Is:");
    store1.printStock();
    System.out.println();
    System.out.println(store2.getName() + "'s Ending Stock Is:");
    store2.printStock();
    System.out.println();
    System.out.println(store3.getName() + "'s Ending Stock Is:");
    store3.printStock(); 
    System.out.println();
        
    System.out.println(store1.getName() + "'s total revenue was: " + store1.getRevenue());
    System.out.println(store2.getName() + "'s total revenue was: " + store2.getRevenue());
    System.out.println(store3.getName() + "'s total revenue was: " + store3.getRevenue());
  }
}