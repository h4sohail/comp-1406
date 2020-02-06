public abstract class Computer extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean hasSSD;
    private int storage;

    public Computer(double price, int quantity ,double cpuSpeed, int ram, boolean ssd, int storage) {
        super(price, quantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.hasSSD = ssd;
        this.storage = storage;
    }

    public double getCpuSpeed() { return cpuSpeed; }
    public int getRam() { return ram; }
    public boolean isSsd() { return hasSSD; }
    public int getStorage() { return storage; }

    public String stringTemplate(boolean ssd) {
        if(ssd){
            return String.format(" CPU speed is %.2f gHz, RAM amount is %d GB, storage space is %d GB (SSD) " +
                    "(%.2f dollars each with %d in stock and %d sold)" +
                    "", getCpuSpeed(), getRam(), getStorage(), getPrice(), getStockQuantity(), getSoldQuantity());
        }
        else{
            return String.format(" CPU speed is %.2f gHz, RAM amount is %d GB, storage space is %d GB (HDD) " +
                    "(%.2f dollars each with %d in stock and %d sold)" +
                    "", getCpuSpeed(), getRam(), getStorage(), getPrice(), getStockQuantity(), getSoldQuantity());
        }
    }
}