import java.io.Serializable;
import java.util.Objects;

public class GpuPart extends ComputerPart implements Serializable,Printing {
    //гпу
    int memorySize;
    int frequency;

    public GpuPart(String nameOfPart, double costOfPart,String manufacturer,int memorySize, int frequency) {
        super(nameOfPart,costOfPart,manufacturer);
        this.memorySize = memorySize;
        this.frequency = frequency;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
                manufacturer + '\n'+ "Объём памяти-"+memorySize+'\n'+"Частота-"+ frequency+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GpuPart gpuPart)) return false;
        return memorySize == gpuPart.memorySize && frequency == gpuPart.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memorySize, frequency);
    }
}
