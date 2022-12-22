import java.io.Serializable;
import java.util.Objects;

public class SystemUnitPart extends ComputerPart implements Serializable,Printing {
    //системный блок
    String typeOfSystemUnitPart;

    public SystemUnitPart(String nameOfPart, double costOfPart, String manufacturer, String typeOfSystemUnitPart) {
        super(nameOfPart, costOfPart, manufacturer);
        this.typeOfSystemUnitPart = typeOfSystemUnitPart;
    }

    public String getTypeOfSystemUnitPart() {
        return typeOfSystemUnitPart;
    }

    public void setTypeOfSystemUnitPart(String typeOfSystemUnitPart) {
        this.typeOfSystemUnitPart = typeOfSystemUnitPart;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+"Тип системного блока-"+ typeOfSystemUnitPart+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemUnitPart that)) return false;
        return typeOfSystemUnitPart == that.typeOfSystemUnitPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfSystemUnitPart);
    }
}
