import java.io.Serializable;
import java.util.Objects;

public class CpuPart extends ComputerPart implements Serializable,Printing {
    //цпу
    int numberOfCores;
    int numberOfThreads;

    public CpuPart( String nameOfPart, double costOfPart,String manufacturer,int numberOfCores, int numberOfThreads) {
        super(nameOfPart,costOfPart,manufacturer);
        this.numberOfCores = numberOfCores;
        this.numberOfThreads = numberOfThreads;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void printInfo(){
        System.out.println("Название-" + nameOfPart+'\n'+ "Стоимость-"+costOfPart+'\n'+"Производитель-"+
           manufacturer + '\n'+ "Количество ядер-"+numberOfCores+'\n'+"Количество потоков-"+ numberOfThreads+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CpuPart cpuPart)) return false;
        return numberOfCores == cpuPart.numberOfCores && numberOfThreads == cpuPart.numberOfThreads;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCores, numberOfThreads);
    }
}
