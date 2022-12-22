import java.io.Serializable;
import java.util.Objects;

public class PsuPart extends ComputerPart implements Serializable,Printing {
    //блок питания
    int power;
    int efficiency;

    public PsuPart(String nameOfPart, double costOfPart, String manufacturer, int power, int efficiency) {
        super(nameOfPart, costOfPart, manufacturer);
        this.power = power;
        this.efficiency = efficiency;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+ "Мощность-"+power+'\n'+"КПД-"+ efficiency+"%"+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PsuPart psuPart)) return false;
        return power == psuPart.power && efficiency == psuPart.efficiency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, efficiency);
    }
}
