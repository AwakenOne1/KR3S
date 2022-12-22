import java.io.Serializable;
import java.util.Objects;

public class CoolingSystemPart extends ComputerPart implements Serializable,Printing {
    //охлаждение
    String typeOfCoolingSystem;
    int dispersionPower;
    double noiseLevel;

    public CoolingSystemPart(String nameOfPart, double costOfPart, String manufacturer, String typeOfCoolingSystem,
                             int dispersionPower, double noiseLevel) {
        super(nameOfPart, costOfPart, manufacturer);
        this.typeOfCoolingSystem = typeOfCoolingSystem;
        this.dispersionPower = dispersionPower;
        this.noiseLevel = noiseLevel;
    }

    public String getTypeOfCoolingSystem() {
        return typeOfCoolingSystem;
    }

    public void setTypeOfCoolingSystem(String typeOfCoolingSystem) {
        this.typeOfCoolingSystem = typeOfCoolingSystem;
    }

    public int getDispersionPower() {
        return dispersionPower;
    }

    public void setDispersionPower(int dispersionPower) {
        dispersionPower = dispersionPower;
    }

    public double getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(double noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+ manufacturer
                + '\n'+"Тип системы охлаждения-"+typeOfCoolingSystem+'\n'+"Развеиваемая мощность-"+ dispersionPower
                +'\n'+"Уровень шума-"+ noiseLevel+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoolingSystemPart that)) return false;
        return dispersionPower == that.dispersionPower && Double.compare(that.noiseLevel, noiseLevel) == 0 &&
                typeOfCoolingSystem.equals(that.typeOfCoolingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfCoolingSystem, dispersionPower, noiseLevel);
    }
}
