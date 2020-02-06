public class ElectronicStoreStockTester{
  public static void main(String[] args){
    ElectronicStore store1 = createStore1();
    ElectronicStore store2 = createStore2();
    ElectronicStore store3 = createStore3();
    
    System.out.println(store1.getName() + "'s Stock Is:");
    store1.printStock();
    System.out.println();
    System.out.println(store2.getName() + "'s Stock Is:");
    store2.printStock();
    System.out.println();
    System.out.println(store3.getName() + "'s Stock Is:");
    store3.printStock();    
  }
  
  public static ElectronicStore createStore1(){
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
  
  public static ElectronicStore createStore2(){
    ElectronicStore store1 = new ElectronicStore("Buy-nary Computing");
    Desktop d1 = new Desktop(150, 5, 3.0, 16, true, 250, "Compact");
    Desktop d2 = new Desktop(250, 5, 3.5, 32, true, 500, "Server");
    Laptop l1 = new Laptop(100, 15, 2.5, 16, false, 250, 15);
    Laptop l2 = new Laptop(175, 15, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(350, 10, 250, "Black", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(600, 10, 125, "White", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Graphite", "Danby", 6, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Red", "Toasty", 10, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
  
  public static ElectronicStore createStore3(){
    ElectronicStore store1 = new ElectronicStore("Ohm-y Goodness Electronics");
    Desktop d1 = new Desktop(175, 10, 3.0, 16, true, 250, "Low-Profile");
    Desktop d2 = new Desktop(150, 15, 3.5, 32, false, 1000, "Standard");
    Laptop l1 = new Laptop(350, 5, 3.5, 16, true, 500, 16);
    Laptop l2 = new Laptop(500, 5, 2.5, 8, true, 125, 13);
    Fridge f1 = new Fridge(250, 5, 250, "Black", "Sub Zero", 12, false);
    Fridge f2 = new Fridge(275, 5, 125, "White", "Sub Zero", 15, false);
    ToasterOven t1 = new ToasterOven(30, 10, 50, "Graphite", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(80, 10, 50, "Red", "Toasty", 12, true);
    Desktop d3 = new Desktop(175, 10, 3.0, 16, true, 250, "Low-Profile");
    Desktop d4 = new Desktop(150, 15, 3.5, 32, false, 1000, "Standard");
    Laptop l3 = new Laptop(350, 5, 3.5, 16, true, 500, 16);
    Laptop l4 = new Laptop(500, 5, 2.5, 8, true, 125, 13);
    Fridge f3 = new Fridge(250, 5, 250, "Black", "Sub Zero", 12, false);
    Fridge f4 = new Fridge(275, 5, 125, "White", "Sub Zero", 15, false);
    ToasterOven t3 = new ToasterOven(30, 10, 50, "Graphite", "Danby", 8, false);
    ToasterOven t4 = new ToasterOven(80, 10, 50, "Red", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    store1.addProduct(d3);
    store1.addProduct(d4);
    store1.addProduct(l3);
    store1.addProduct(l4);
    store1.addProduct(f3);
    store1.addProduct(f4);
    store1.addProduct(t3);
    store1.addProduct(t4);
    return store1;
  }
}