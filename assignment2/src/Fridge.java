public class Fridge extends Appliance{
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int quantity, int wattage, String color, String brand, double cubicFeet, boolean hasFreezer) {
        super(price, quantity, wattage, color, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;
    }

    @Override
    public String toString() {
        if (hasFreezer) {
            return cubicFeet + " cubic foot " + getBrand() + " Fridge with freezer, " + stringTemplate();
        }
        else{
            return cubicFeet + " cubic foot " + getBrand() + " Fridge without freezer, " + stringTemplate();
        }
    }
}
