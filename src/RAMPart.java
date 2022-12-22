import java.io.Serializable;
import java.util.Objects;

public class RAMPart extends MemoryPart implements Serializable,Printing {
    //озу, производный от накопителя
    int frequency;

    public RAMPart(String nameOfPart, double costOfPart, String manufacturer, int sizeOFMemory, int frequency) {
        super(nameOfPart, costOfPart, manufacturer, sizeOFMemory);
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(String nameOfPart, double costOfPart,String manufacturer,int sizeOFMemory, int frequency) {
        this.frequency = frequency;
        this.nameOfPart=nameOfPart;
        this.costOfPart=costOfPart;
        this.manufacturer=manufacturer;
        this.sizeOFMemory=sizeOFMemory;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+"Объём-"+sizeOFMemory+'\n'+"Частота-"+ frequency+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RAMPart ramPart)) return false;
        return frequency == ramPart.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency);
    }
}
