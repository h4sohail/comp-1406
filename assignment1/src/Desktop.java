public class Desktop {
    double cpuSpeed;
    int ramAmount;
    int storageSpace;
    boolean hasSSD;
    public Desktop(double cpuSpeed, int ramAmount, int storageSpace, boolean hasSSD){
        this.cpuSpeed = cpuSpeed;
        this.ramAmount = ramAmount;
        this.storageSpace = storageSpace;
        this.hasSSD = hasSSD;
    }

    @Override
    public String toString() {
        if (hasSSD){
            return "Desktop: " +
                "CPU Speed is " + cpuSpeed + "gHz" +
                ", RAM Amount is " + ramAmount + "GB" +
                ", Storage Space is " + storageSpace + "GB" +
                ", Has SSD";
        }
        else{
         return "Desktop: " +
                "CPU Speed is" + cpuSpeed + "gHz" +
                ", RAM Amount is" + ramAmount + "GB" +
                ", Storage Space is " + storageSpace + "GB" +
                ", Has HDD";
        }
    }
}