public class Laptop {
    double cpuSpeed;
    int ramAmount;
    int storageSpace;
    boolean hasSSD;
    int screenSize;

    public Laptop(double cpuSpeed, int ramAmount, int storageSpace, boolean hasSSD, int screenSize){
        this.cpuSpeed = cpuSpeed;
        this.ramAmount = ramAmount;
        this.storageSpace = storageSpace;
        this.hasSSD = hasSSD;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        if (hasSSD){
            return screenSize + "\"" + " Laptop: " +
                "CPU Speed is " + cpuSpeed + "gHz" +
                ", RAM Amount is " + ramAmount + "GB" +
                ", Storage Space is " + storageSpace + "GB" +
                ", Has SSD" + "";
        }
        else{
         return screenSize + "\"" + " Laptop: " +
                "CPU Speed is" + cpuSpeed + "gHz" +
                ", RAM Amount is" + ramAmount + "GB" +
                ", Storage Space is" + storageSpace + "GB" +
                ", Has HDD";
        }
    }
}