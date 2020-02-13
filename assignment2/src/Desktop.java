public class Desktop extends Computer {
    private String profile;

    public Desktop(double price, int quantity, double cpuSpeed, int ram, boolean hasSSD, int storage, String profile) {
        super(price, quantity, cpuSpeed, ram, hasSSD, storage);
        this.profile = profile;
    }

    @Override
    public String toString() {
            return profile + " Desktop" + stringTemplate();
    }
}
