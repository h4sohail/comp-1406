public class ElectronicStore {
    String storeName;
    Object[] inventory = new Object[9];

    public ElectronicStore(String storeName){
        this.storeName = storeName;

        Desktop gamingDesktop = new Desktop(4.5,32,1000,true);
        inventory[0] = gamingDesktop;
        Desktop businessDesktop = new Desktop(3.9, 16,500, true);
        inventory[1] = businessDesktop;
        Desktop casualDesktop = new Desktop(3.0, 8,1000, false);
        inventory[2] = casualDesktop;
        Laptop gamingLaptop = new Laptop(4.5,32,1000,true, 17);
        inventory[3] = gamingLaptop;
        Laptop businessLaptop = new Laptop(3.9, 16,500, true, 15);
        inventory[4] = businessLaptop;
        Laptop casualLaptop = new Laptop(3.0, 8,1000, false, 14);
        inventory[5] = casualLaptop;
        Fridge gamingFridge = new Fridge(50, true, "Red");
        inventory[6] = gamingFridge;
        Fridge businessFridge = new Fridge(15, true, "White");
        inventory[7] = businessFridge;
        Fridge casualFridge = new Fridge(13, false,"Yellow");
        inventory[8] = casualFridge;
    }

    public void printStock(){
        for(Object item: inventory){
            System.out.println(item);
        }
    }

    public boolean searchStock(String searchStr){
        for(Object item: inventory){
            String itemStr = item.toString().toLowerCase();
            boolean hasMatch = itemStr.contains(searchStr);
            if(hasMatch){
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }
}
