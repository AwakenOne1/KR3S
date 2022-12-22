import java.io.Serializable;
import java.util.Objects;

public class MotherBoardPart extends ComputerPart implements Serializable,Printing {
    //материнская плата
    String typeOfChipset;
    String formFactor;

    public MotherBoardPart(String nameOfPart, double costOfPart,String manufacturer,String typeOfChipset, String formFactor) {
        super(nameOfPart,costOfPart,manufacturer);
        this.typeOfChipset = typeOfChipset;
        this.formFactor = formFactor;
    }

    public String getTypeOfChipset() {
        return typeOfChipset;
    }

    public void setTypeOfChipset(String typeOfChipset) {
        this.typeOfChipset = typeOfChipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+ "Чипсет-"+ typeOfChipset+'\n'+"Форм-фактор-"+ formFactor+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotherBoardPart that)) return false;
        return Objects.equals(typeOfChipset, that.typeOfChipset) && Objects.equals(formFactor, that.formFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfChipset, formFactor);
    }
}
