import java.io.Serializable;

public  class ComputerPart implements Serializable,Printing {
    //базовый класс для комплетуюших
    String nameOfPart;
    double costOfPart;
    String manufacturer;

    public ComputerPart(String nameOfPart, double costOfPart, String manufacturer) {
        this.nameOfPart = nameOfPart;
        this.costOfPart = costOfPart;
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNameOfPart() {
        return nameOfPart;
    }

    public double getCostOfPart() {
        return costOfPart;
    }

    public void setNameOfPart(String nameOfPart) {
        this.nameOfPart = nameOfPart;
    }

    public void setCostOfPart(double costOfPart) {
        this.costOfPart = costOfPart;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public  void printInfo(){

    };
}
