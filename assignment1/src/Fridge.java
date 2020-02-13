public class Fridge {
    double fridgeSize;
    boolean hasFreezer;
    String fridgeColor;

    public Fridge(double fridgeSize, boolean hasFreezer, String fridgeColor){
        this.fridgeSize = fridgeSize;
        this.hasFreezer = hasFreezer;
        this.fridgeColor = fridgeColor;
    }

    @Override
    public String toString() {
        if (hasFreezer){
            return fridgeSize + " cubic foot " + "Fridge, " +
                "with freezer" +
                ", Color is " + fridgeColor;
        }
        else{
            return fridgeSize + " cubic foot " + "Fridge, " +
                "without freezer" +
                ", Color is " + fridgeColor;
        }
    }
}