public class Notebook {
    private String color;
    private Integer ram;
    private String os;
    private int hdd;
    private final int id;
    private final String brand;
    private final String model;

    public Notebook(String model, int id, String brand) {
        this.model = model;
        this.brand = brand;
        this.id = id;
        System.out.println("Ноутбук марки " + "'" + this.brand + "'" + " Модель "
                + this.model + " С id " + this.id);
    }

    public String getColor() {
        return this.color;
    }

    public int getRam() {
        return this.ram;
    }

    public String getOs() {
        return this.os;
    }

    public int getHdd() {
        return this.hdd;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return ("Ноутбук " +
                this.id +
                System.lineSeparator() +
                this.color +
                " " +
                this.brand +
                " " +
                this.model +
                System.lineSeparator() +
                "OS: " + this.os +
                System.lineSeparator() +
                "HDD: " + this.hdd +
                System.lineSeparator() +
                "RAM: " + this.ram);
    }
}
