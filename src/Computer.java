import java.io.Serializable;

public class Computer implements Serializable{
    CpuPart Cpu;
    CoolingSystemPart CoolingSystem;
    GpuPart Gpu;
    MemoryPart Memory;
    MotherBoardPart Motherboard;
    PsuPart Psu;
    RAMPart Ram;
    SystemUnitPart SystemUnit;

    public CpuPart getCpu() {
        return Cpu;
    }

    public void setCpu(CpuPart cpu) {
        Cpu = cpu;
    }

    public CoolingSystemPart getCoolingSystem() {
        return CoolingSystem;
    }

    public void setCoolingSystem(CoolingSystemPart coolingSystem) {
        CoolingSystem = coolingSystem;
    }

    public GpuPart getGpu() {
        return Gpu;
    }

    public void setGpu(GpuPart gpu) {
        Gpu = gpu;
    }

    public MemoryPart getMemory() {
        return Memory;
    }

    public void setMemory(MemoryPart memory) {
        Memory = memory;
    }

    public MotherBoardPart getMotherboard() {
        return Motherboard;
    }

    public void setMotherboard(MotherBoardPart motherboard) {
        Motherboard = motherboard;
    }

    public PsuPart getPsu() {
        return Psu;
    }

    public void setPsu(PsuPart psu) {
        Psu = psu;
    }

    public RAMPart getRam() {
        return Ram;
    }

    public void setRam(RAMPart ram) {
        Ram = ram;
    }

    public SystemUnitPart getSystemUnit() {
        return SystemUnit;
    }

    public void setSystemUnit(SystemUnitPart systemUnit) {
        SystemUnit = systemUnit;
    }

    public Computer(CpuPart cpu, CoolingSystemPart coolingSystem, GpuPart gpu, MemoryPart memory,
                    MotherBoardPart motherboard, PsuPart psu, RAMPart ram, SystemUnitPart systemUnit) {
        Cpu = cpu;
        CoolingSystem = coolingSystem;
        Gpu = gpu;
        Memory = memory;
        Motherboard = motherboard;
        Psu = psu;
        Ram = ram;
        SystemUnit = systemUnit;
    }

    void PrintInfo() {

        System.out.println("Система охлаждения- ");
        CoolingSystem.printInfo();
        System.out.println('\n');
        System.out.println("Центральный процессор- ");
        Cpu.printInfo();
        System.out.println('\n');
        System.out.println("4- Графичекий процессор- ");
        Gpu.printInfo();
        System.out.println('\n');
        System.out.println("Накопитель- ");
        Memory.printInfo();
        System.out.println('\n');
        System.out.println("Материнская плата- ");
        Motherboard.printInfo();
        System.out.println('\n');
        System.out.println("Блок питания- ");
        Psu.printInfo();
        System.out.println('\n');
        System.out.println("ОЗУ- ");
        Memory.printInfo();
        System.out.println('\n');
        System.out.println("Системный блок- ");
        SystemUnit.printInfo();
        System.out.println('\n');
    }
    }