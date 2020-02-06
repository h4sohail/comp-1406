public class Laptop extends Computer {
    private double screenSize;

    Laptop(double price, int quantity, double cpuSpeed, int ram, boolean hasSSD, int storage, double screenSize) {
        super(price, quantity, cpuSpeed, ram, hasSSD, storage);
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return screenSize + stringTemplate(isSsd());
    }
}
