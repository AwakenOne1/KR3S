import java.io.Serializable;
import java.util.Objects;

public class DisplayPart extends ComputerPart implements Serializable,Printing {
    //монитор
    int frequency;
    String resolution;
    int size;

    public DisplayPart(String nameOfPart, double costOfPart, String manufacturer, int frequency, String resolution, int size) {
        super(nameOfPart, costOfPart, manufacturer);
        this.frequency = frequency;
        this.resolution = resolution;
        this.size = size;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+ manufacturer
                + '\n'+"Частота развёртки-"+frequency+'\n'+"Разрешение-"+ resolution+'\n'+"Диагональ-"+ size+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisplayPart that)) return false;
        return frequency == that.frequency && resolution == that.resolution && size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, resolution, size);
    }
}
