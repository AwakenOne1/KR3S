import java.io.Serializable;
import java.util.Objects;

public class MemoryPart extends ComputerPart implements Serializable,Printing {
    //накопитель
    int sizeOFMemory;

    public int getSizeOFMemory() {
        return sizeOFMemory;
    }

    public void setSizeOFMemory(int sizeOFMemory) {
        this.sizeOFMemory = sizeOFMemory;
    }

    public MemoryPart(String nameOfPart, double costOfPart, String manufacturer, int sizeOFMemory) {
        super(nameOfPart,costOfPart,manufacturer);
        this.sizeOFMemory = sizeOFMemory;

    }
    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+ "Объём-"+sizeOFMemory+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoryPart that)) return false;
        return sizeOFMemory == that.sizeOFMemory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeOFMemory);
    }
}
