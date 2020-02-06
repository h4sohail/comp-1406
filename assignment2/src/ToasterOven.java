public class ToasterOven extends Appliance{
    private int width;
    private boolean hasConvection;

    public ToasterOven(double price, int quantity, int wattage, String color, String brand, int width, boolean hasConvection){
        super(price, quantity, wattage, color, brand);
        this.width = width;
        this.hasConvection = hasConvection;
    }

    @Override
    public String toString() {
        if (hasConvection) {
            return width + " inch " + getBrand() + " Toaster with convection " + stringTemplate();
        }
        else {
            return width + " inch " + getBrand() + " Toaster without convection " + stringTemplate();
        }
    }
}
