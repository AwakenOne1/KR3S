import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//основной функционал
public class ActivityInMain {


    ArrayList<ComputerPart> ListOfParts = new ArrayList<>();
    ArrayList<CoolingSystemPart> ListOfCoolingSystemPart = new ArrayList<>();
    ArrayList<CpuPart> ListOfCpuParts = new ArrayList<>();
    ArrayList<DisplayPart> ListOfDisplayParts = new ArrayList<>();

    ArrayList<GpuPart> ListOfGpuParts = new ArrayList<>();
    ArrayList<MemoryPart> ListOfMemoryParts = new ArrayList<>();
    ArrayList<MotherBoardPart> ListOfMotherBoardParts = new ArrayList<>();
    ArrayList<PsuPart> ListOfPsuParts = new ArrayList<>();
    ArrayList<RAMPart> ListOfRamParts = new ArrayList<>();
    ArrayList<SystemUnitPart> ListOfSystemUnitParts = new ArrayList<>();
    ArrayList<Computer> ListOfComputer = new ArrayList<>();

    public void menu() {
        while (true) {
            System.out.println("Выберите необходимое действие");
            System.out.println("1-Добавление необходимого компонента");
            System.out.println("2-Вывод списка компонентов определённого типа");
            System.out.println("3-Создание конфигурации");
            System.out.println("4-Удаление компонента");
            System.out.println("5-Выход");
            Scanner input = new Scanner(System.in);
            int k = input.nextInt();
            switch (k) {
                case 1:
                    this.ChoosingAddAction();
                    break;
                case 2:
                    this.ChoosingOutputAction();
                    break;
                case 3:
                    this.CreatingConfiguration();
                    break;
                case 4:
                    this.ChoosingDeletingComponent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Вами не было выбрано ни один вариант");

            }

        }
    }

    private void ChoosingAddAction() {
        System.out.println("Выберите необходимый компонент");
        System.out.println("1- Система охлаждения");
        System.out.println("2- Центральный процессор");
        System.out.println("3- Монитор");
        System.out.println("4- Графичекий процессор");
        System.out.println("5- Накопитель");
        System.out.println("6- Материнская плата");
        System.out.println("7- Блок питания");
        System.out.println("8- ОЗУ");
        System.out.println("9- Системный блок");

        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1 -> AddCoolingSystem();
            case 2 -> AddCpu();
            case 3 -> AddDisplay();
            case 4 -> AddGpu();
            case 5 -> AddMemory();
            case 6 -> AddMotherboard();
            case 7 -> AddPsu();
            case 8 -> AddRAM();
            case 9 -> AddSystemUnit();
            default -> System.out.println("Было введено некорректное значение");
        }

    }

    private void ChoosingOutputAction() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите необходимый компонент");
        System.out.println("1- Система охлаждения");
        System.out.println("2- Центральный процессор");
        System.out.println("3- Монитор");
        System.out.println("4- Графичекий процессор");
        System.out.println("5- Накопитель");
        System.out.println("6- Материнская плата");
        System.out.println("7- Блок питания");
        System.out.println("8- ОЗУ");
        System.out.println("9- Системный блок");

        switch (input.nextInt()) {
            case 1:
                PrintCoolingSystem();
                break;
            case 2:
                PrintCpu();
                break;
            case 3:
                PrintDisplay();
                break;
            case 4:
                PrintGpu();
                break;
            case 5:
                PrintMemory();
                break;
            case 6:
                PrintMotherBoard();
                break;
            case 7:
                PrintPsu();
                break;
            case 8:
                PrintRam();
                break;
            case 9:
                PrintSystemUnit();
                break;
            case 10:
                PrintComputer();
                break;
            default:
                System.out.println("Не был выбран корректный вариант");

        }

    }


    private void CreatingConfiguration() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите необходимый вариант создания конфигурации");
        System.out.println("1-На основе имеющихся компонентов");
        System.out.println("2-С добавлением новых");
        switch (input.nextInt()) {
            case 1:
                CreatingOnExisted();
                break;
            case 2:
                CreatingOnNew();
                break;
            default:
                System.out.println("Не был выбран корректный вариант");
        }
    }

    private void CreatingOnExisted() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название системы охлаждения");
        String name = input.nextLine();
        CoolingSystemPart NewCoolingSystemPart = AddCoolingSystemToComputer(name);
        System.out.println("Введите название центрального процессора");
        name = input.nextLine();
        CpuPart NewCpuPart = AddCpuToComputer(name);
        System.out.println("Введите название накопителя");
        name = input.nextLine();
        MemoryPart NewMemoryPart = AddMemoryToComputer(name);
        System.out.println("Введите название графического процессора");
        name = input.nextLine();
        GpuPart NewGpuPart = AddGpuToComputer(name);
        System.out.println("Введите название материнской платы");
        name = input.nextLine();
        MotherBoardPart NewMotherBoardPart = AddMotherBoardToComputer(name);
        System.out.println("Введите название блока питания");
        name = input.nextLine();
        PsuPart NewPsuPart = AddPsuToComputer(name);
        System.out.println("Введите название ОЗУ");
        name = input.nextLine();
        RAMPart NewRamPart = AddRamToComputer(name);
        System.out.println("Введите название корпуса");
        name = input.nextLine();
        SystemUnitPart NewSystemUnitPart = AddSystemUnitToComputer(name);
        ListOfComputer.add(new Computer(NewCpuPart, NewCoolingSystemPart, NewGpuPart, NewMemoryPart, NewMotherBoardPart, NewPsuPart, NewRamPart, NewSystemUnitPart));
        SerializeComputer();
    }

    private void CreatingOnNew() {

        System.out.println("Введите характеристики системы охлаждения");
        CoolingSystemPart NewCoolingSystem = CreateCoolingSystem();
        System.out.println("Введите характеристики центрального процессора");
        CpuPart NewCpuPart = CreateCpu();
        System.out.println("Введите характеристики графического процессора");
        GpuPart NewGpuPart = CreateGpu();
        System.out.println("Введите характеристики накопителя");
        MemoryPart NewMemoryPart = CreateMemory();
        System.out.println("Введите характеристики материнской платы");
        MotherBoardPart NewMotherBoardPart = CreateMotherboard();
        System.out.println("Введите характеристики блока питания");
        PsuPart NewPsuPart = CreatePsu();
        System.out.println("Введите характеристики оперативной памяти");
        RAMPart NewRamPart = CreateRam();
        System.out.println("Введите характеристики системного блока");
        SystemUnitPart NewSystemUnitPart = CreateSystemUnit();
        Computer NewComputer = new Computer(NewCpuPart, NewCoolingSystem, NewGpuPart, NewMemoryPart, NewMotherBoardPart, NewPsuPart, NewRamPart, NewSystemUnitPart);
        ListOfComputer.add(NewComputer);
        SerializeComputer();

    }

    private void ChoosingDeletingComponent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите необходимый компонент");
        System.out.println("1- Система охлаждения");
        System.out.println("2- Центральный процессор");
        System.out.println("3- Монитор");
        System.out.println("4- Графичекий процессор");
        System.out.println("5- Накопитель");
        System.out.println("6- Материнская плата");
        System.out.println("7- Блок питания");
        System.out.println("8- ОЗУ");
        System.out.println("9- Системный блок");

        switch (input.nextInt()) {
            case 1:
                DeleteCoolingSystem();
                break;
            case 2:
                DeleteCpu();
                break;
            case 3:
                DeleteDisplay();
                break;
            case 4:
                DeleteGpu();
                break;
            case 5:
                DeleteMemory();
                break;
            case 6:
                DeleteMotherBoard();
                break;
            case 7:
                DeletePsu();
                break;
            case 8:
                DeleteRam();
                break;
            case 9:
                DeleteSystemUnit();
                break;
            default:
                System.out.println("Не был выбран корректный вариант");
                break;

        }


    }

    private void AddCoolingSystem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите уровень шума");
        double noiseLevel = input.nextDouble();
        System.out.println("Введите уровень рассеивания");
        int dispersionLevel = input.nextInt();
        System.out.println("Введите тип системы охлаждения");
        String type = input.nextLine();
        type = input.nextLine();
        ListOfCoolingSystemPart.add(new CoolingSystemPart(name, price, manufacturer, type, dispersionLevel, noiseLevel));
        ListOfParts.add(new CoolingSystemPart(name, price, manufacturer, type, dispersionLevel, noiseLevel));
        this.SerializeComputerParts();
        this.SerialiseCoolingSystemParts();
    }

    private void AddCpu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите количество ядер");
        int coreNumber = input.nextInt();
        System.out.println("Введите количество потоков");
        int threadNumber = input.nextInt();

        ListOfCpuParts.add(new CpuPart(name, price, manufacturer, coreNumber, threadNumber));
        ListOfParts.add(new CpuPart(name, price, manufacturer, coreNumber, threadNumber));
        this.SerializeComputerParts();
        this.SerializeCpuParts();
    }

    private void AddDisplay() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите частоту развёртки");
        int frequency = input.nextInt();
        System.out.println("Введите диагональ");
        int size = input.nextInt();
        System.out.println("Введите разрешение");
        String resolution = input.nextLine();
        resolution = input.nextLine();


        ListOfDisplayParts.add(new DisplayPart(name, price, manufacturer, frequency, resolution, size));
        ListOfParts.add(new DisplayPart(name, price, manufacturer, frequency, resolution, size));
        this.SerializeComputerParts();
        this.SerializeDisplayParts();
    }

    private void AddGpu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите количество памяти");
        int sizeOfMemory = input.nextInt();
        System.out.println("Введите частоту");
        int frequency = input.nextInt();

        ListOfGpuParts.add(new GpuPart(name, price, manufacturer, sizeOfMemory, frequency));
        ListOfParts.add(new GpuPart(name, price, manufacturer, sizeOfMemory, frequency));
        this.SerializeComputerParts();
        this.SerializeGpuParts();
    }

    private void AddMemory() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите объём памяти");
        int sizeOfMemory = input.nextInt();

        ListOfMemoryParts.add(new MemoryPart(name, price, manufacturer, sizeOfMemory));
        ListOfParts.add(new MemoryPart(name, price, manufacturer, sizeOfMemory));
        this.SerializeComputerParts();
        this.SerializeMemoryParts();
    }

    private void AddRAM() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите объём памяти");
        int sizeOfMemory = input.nextInt();
        System.out.println("Введите частоту");
        int frequency = input.nextInt();

        ListOfRamParts.add(new RAMPart(name, price, manufacturer, sizeOfMemory, frequency));
        ListOfParts.add(new RAMPart(name, price, manufacturer, sizeOfMemory, frequency));
        this.SerializeComputerParts();
        this.SerializeRamParts();
    }

    private void AddMotherboard() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите тип чипсета");
        String typeOfChipset = input.nextLine();
        System.out.println("Введите формфактор");
        String formFactor = input.nextLine();

        ListOfMotherBoardParts.add(new MotherBoardPart(name, price, manufacturer, typeOfChipset, formFactor));
        ListOfParts.add(new MotherBoardPart(name, price, manufacturer, typeOfChipset, formFactor));
        this.SerializeComputerParts();
        this.SerializeMotherBoardParts();

    }

    private void AddPsu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите мощность");
        int power = input.nextInt();
        System.out.println("Введите КПД");
        int efficiency = input.nextInt();

        ListOfPsuParts.add(new PsuPart(name, price, manufacturer, power, efficiency));
        ListOfParts.add(new PsuPart(name, price, manufacturer, power, efficiency));
        this.SerializeComputerParts();
        this.SerializePsuParts();

    }

    private void AddSystemUnit() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите тип системного блока");
        String type = input.nextLine();

        ListOfSystemUnitParts.add(new SystemUnitPart(name, price, manufacturer, type));
        ListOfParts.add(new SystemUnitPart(name, price, manufacturer, type));
        this.SerializeComputerParts();
        this.SerializeSystemUnitParts();
    }

    private void PrintCoolingSystem() {
        DeserializeCoolingSystemParts();
        for (CoolingSystemPart obj : ListOfCoolingSystemPart) {
            obj.printInfo();
        }

    }

    private void PrintCpu() {
        DeserializeCpuParts();
        for (CpuPart obj : ListOfCpuParts) {
            obj.printInfo();
        }

    }

    private void PrintDisplay() {
        DeserializeDisplayParts();
        for (DisplayPart obj : ListOfDisplayParts) {
            obj.printInfo();
        }

    }

    private void PrintGpu() {
        DeserializeGpuParts();
        for (GpuPart obj : ListOfGpuParts) {
            obj.printInfo();
        }

    }

    private void PrintMemory() {
        DeserializeMemoryParts();
        for (MemoryPart obj : ListOfMemoryParts) {
            obj.printInfo();
        }

    }

    private void PrintMotherBoard() {
        DeserializeMotherBoardParts();
        for (MotherBoardPart obj : ListOfMotherBoardParts) {
            obj.printInfo();
        }

    }

    private void PrintPsu() {
        DeserializePsuParts();
        for (PsuPart obj : ListOfPsuParts) {
            obj.printInfo();
        }

    }

    private void PrintRam() {
        DeserializeRamParts();
        for (RAMPart obj : ListOfRamParts) {
            obj.printInfo();
        }

    }

    private void PrintSystemUnit() {
        DeserializeSystemUnitParts();
        for (SystemUnitPart obj : ListOfSystemUnitParts) {
            obj.printInfo();
        }

    }

    private void PrintComputer() {
        DeserializeComputer();
        for (Computer obj : ListOfComputer) {
            obj.PrintInfo();
        }
    }

    private void DeleteCoolingSystem() {
        Scanner input = new Scanner(System.in);
        DeserializeCoolingSystemParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfCoolingSystemPart.size(); i++) {
            if (DeletingName.equals(ListOfCoolingSystemPart.get(i).getNameOfPart())) {
                ListOfCoolingSystemPart.remove(i);
                break;
            }
        }
        SerialiseCoolingSystemParts();
    }

    private void DeleteCpu() {
        Scanner input = new Scanner(System.in);
        DeserializeCpuParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfCpuParts.size(); i++) {
            if (DeletingName.equals(ListOfCpuParts.get(i).getNameOfPart())) {
                ListOfCpuParts.remove(i);
                break;
            }
        }
        SerializeCpuParts();
    }

    private void DeleteDisplay() {
        Scanner input = new Scanner(System.in);
        DeserializeDisplayParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfDisplayParts.size(); i++) {
            if (DeletingName.equals(ListOfDisplayParts.get(i).getNameOfPart())) {
                ListOfDisplayParts.remove(i);
                break;
            }
        }
        SerializeDisplayParts();
    }

    private void DeleteGpu() {
        Scanner input = new Scanner(System.in);
        DeserializeGpuParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfGpuParts.size(); i++) {
            if (DeletingName.equals(ListOfGpuParts.get(i).getNameOfPart())) {
                ListOfGpuParts.remove(i);
                break;
            }
        }
        SerializeGpuParts();
    }

    private void DeleteMemory() {
        Scanner input = new Scanner(System.in);
        DeserializeMemoryParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfMemoryParts.size(); i++) {
            if (DeletingName.equals(ListOfMemoryParts.get(i).getNameOfPart())) {
                ListOfMemoryParts.remove(i);
                break;
            }
        }
        SerializeMemoryParts();
    }

    private void DeleteMotherBoard() {
        Scanner input = new Scanner(System.in);
        DeserializeMotherBoardParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfMotherBoardParts.size(); i++) {
            if (DeletingName.equals(ListOfMotherBoardParts.get(i).getNameOfPart())) {
                ListOfMotherBoardParts.remove(i);
                break;
            }
        }
        SerializeMotherBoardParts();
    }

    private void DeletePsu() {
        Scanner input = new Scanner(System.in);
        DeserializePsuParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfPsuParts.size(); i++) {
            if (DeletingName.equals(ListOfPsuParts.get(i).getNameOfPart())) {
                ListOfPsuParts.remove(i);
                break;
            }
        }
        SerializePsuParts();
    }

    private void DeleteRam() {
        Scanner input = new Scanner(System.in);
        DeserializeRamParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfRamParts.size(); i++) {
            if (DeletingName.equals(ListOfRamParts.get(i).getNameOfPart())) {
                ListOfRamParts.remove(i);
                break;
            }
        }
        SerializeRamParts();
    }

    private void DeleteSystemUnit() {
        Scanner input = new Scanner(System.in);
        DeserializeSystemUnitParts();
        System.out.println("Введите название удаляемого элемента");
        String DeletingName = input.nextLine();
        for (int i = 0; i < ListOfSystemUnitParts.size(); i++) {
            if (DeletingName.equals(ListOfSystemUnitParts.get(i).getNameOfPart())) {
                ListOfSystemUnitParts.remove(i);
                break;
            }
        }
        SerializeSystemUnitParts();
    }

    public void CreatingFiles() {
        File directory = new File("/Users/alexeydubovik/Desktop/KR3S");
        //ArrayList<ComputerPart> ListOfParts = new ArrayList<>();
        File ComputerParts = new File(directory, "Computer parts");

        try {
            boolean created = ComputerParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        File CoolingSystemParts = new File("/Users/alexeydubovik/Desktop/KR3S", "CoolingSystemParts");
        try {
            boolean created = CoolingSystemParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File CpuParts = new File("/Users/alexeydubovik/Desktop/KR3S", "CpuParts");
        try {
            boolean created = CpuParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File DisplayParts = new File("/Users/alexeydubovik/Desktop/KR3S", "DisplayParts");
        try {
            boolean created = DisplayParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File GpuParts = new File("/Users/alexeydubovik/Desktop/KR3S", "GpuParts");
        try {
            boolean created = GpuParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File MemoryParts = new File("/Users/alexeydubovik/Desktop/KR3S", "MemoryParts");
        try {
            boolean created = MemoryParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File MotherBoardParts = new File("/Users/alexeydubovik/Desktop/KR3S", "MotherBoardParts");
        try {
            boolean created = MotherBoardParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File PsuParts = new File("/Users/alexeydubovik/Desktop/KR3S", "PsuParts");
        try {
            boolean created = PsuParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File RamParts = new File("/Users/alexeydubovik/Desktop/KR3S", "RamParts");
        try {
            boolean created = RamParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        File SystemUnitParts = new File("/Users/alexeydubovik/Desktop/KR3S", "SystemUnitParts");
        try {
            boolean created = SystemUnitParts.createNewFile();
            if (created) System.out.print("");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }


    private void SerializeComputerParts() {
        try {
            FileOutputStream fos = new FileOutputStream("ComputerParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeComputerParts() {
        try {
            FileInputStream fis = new FileInputStream("ComputerParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerialiseCoolingSystemParts() {
        try {
            FileOutputStream fos = new FileOutputStream("CoolingSystemParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfCoolingSystemPart);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeCoolingSystemParts() {
        try {
            FileInputStream fis = new FileInputStream("CoolingSystemParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfCoolingSystemPart = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeCpuParts() {
        try {
            FileOutputStream fos = new FileOutputStream("CpuParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfCpuParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeCpuParts() {
        try {
            FileInputStream fis = new FileInputStream("CpuParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfCpuParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeDisplayParts() {
        try {
            FileOutputStream fos = new FileOutputStream("DisplayParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfDisplayParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeDisplayParts() {
        try {
            FileInputStream fis = new FileInputStream("DisplayParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfDisplayParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeGpuParts() {
        try {
            FileOutputStream fos = new FileOutputStream("GpuParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfGpuParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeGpuParts() {
        try {
            FileInputStream fis = new FileInputStream("GpuParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfGpuParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }


    }

    private void SerializeMemoryParts() {
        try {
            FileOutputStream fos = new FileOutputStream("MemoryParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfMemoryParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeMemoryParts() {
        try {
            FileInputStream fis = new FileInputStream("MemoryParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfMemoryParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeMotherBoardParts() {
        try {
            FileOutputStream fos = new FileOutputStream("MotherBoardParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfMotherBoardParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeMotherBoardParts() {
        try {
            FileInputStream fis = new FileInputStream("MotherboardParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfMotherBoardParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializePsuParts() {
        try {
            FileOutputStream fos = new FileOutputStream("PsuParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfPsuParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializePsuParts() {
        try {
            FileInputStream fis = new FileInputStream("PsuParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfPsuParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeRamParts() {
        try {
            FileOutputStream fos = new FileOutputStream("RamParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfRamParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeRamParts() {
        try {
            FileInputStream fis = new FileInputStream("RamParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfRamParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeSystemUnitParts() {
        try {
            FileOutputStream fos = new FileOutputStream("SystemUnitParts");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfSystemUnitParts);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeSystemUnitParts() {
        try {
            FileInputStream fis = new FileInputStream("SystemUnitParts");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfSystemUnitParts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void SerializeComputer() {
        try {
            FileOutputStream fos = new FileOutputStream("Computer");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListOfComputer);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void DeserializeComputer() {
        try {
            FileInputStream fis = new FileInputStream("Computer");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ListOfComputer = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private CoolingSystemPart CreateCoolingSystem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите уровень шума");
        double noiseLevel = input.nextDouble();
        System.out.println("Введите уровень рассеивания");
        int dispersionLevel = input.nextInt();
        System.out.println("Введите тип системы охлаждения");
        String type = input.nextLine();
        type = input.nextLine();
        CoolingSystemPart CreatedCoolingSystemPart = new CoolingSystemPart(name, price, manufacturer, type, dispersionLevel, noiseLevel);
        return CreatedCoolingSystemPart;
    }

    private CpuPart CreateCpu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите количество ядер");
        int coreNumber = input.nextInt();
        System.out.println("Введите количество потоков");
        int threadNumber = input.nextInt();

        CpuPart NewCpu = new CpuPart(name, price, manufacturer, coreNumber, threadNumber);
        return NewCpu;

    }

    private GpuPart CreateGpu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите количество памяти");
        int sizeOfMemory = input.nextInt();
        System.out.println("Введите частоту");
        int frequency = input.nextInt();

        GpuPart NewGpu = new GpuPart(name, price, manufacturer, sizeOfMemory, frequency);
        return NewGpu;
    }

    private MemoryPart CreateMemory() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите объём памяти");
        int sizeOfMemory = input.nextInt();

        MemoryPart NewMemoryPart = new MemoryPart(name, price, manufacturer, sizeOfMemory);
        return NewMemoryPart;
    }

    private RAMPart CreateRam() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите объём памяти");
        int sizeOfMemory = input.nextInt();
        System.out.println("Введите частоту");
        int frequency = input.nextInt();

        RAMPart NewRamPart = new RAMPart(name, price, manufacturer, sizeOfMemory, frequency);
        return NewRamPart;
    }

    private MotherBoardPart CreateMotherboard() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите тип чипсета");
        String typeOfChipset = input.nextLine();
        System.out.println("Введите формфактор");
        String formFactor = input.nextLine();

        MotherBoardPart NewMotherBoard = new MotherBoardPart(name, price, manufacturer, typeOfChipset, formFactor);
        return NewMotherBoard;

    }

    private PsuPart CreatePsu() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите мощность");
        int power = input.nextInt();
        System.out.println("Введите КПД");
        int efficiency = input.nextInt();

        PsuPart NewPsuPart = new PsuPart(name, price, manufacturer, power, efficiency);
        return NewPsuPart;

    }

    private SystemUnitPart CreateSystemUnit() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название");
        String name = input.nextLine();
        System.out.println("Введите стоимость");
        int price = input.nextInt();
        System.out.println("Введите производителя");
        String manufacturer = input.nextLine();
        manufacturer = input.nextLine();
        System.out.println("Введите тип системного блока");
        String type = input.nextLine();

        SystemUnitPart NewSystemUnitPart = new SystemUnitPart(name, price, manufacturer, type);
        return NewSystemUnitPart;
    }

    private CoolingSystemPart AddCoolingSystemToComputer(String name) {
        CoolingSystemPart obj = null;
        for (int i = 0; i < ListOfCoolingSystemPart.size(); i++) {
            if (name.equals(ListOfCoolingSystemPart.get(i).getNameOfPart())) {
                obj = ListOfCoolingSystemPart.get(i);
                ListOfCoolingSystemPart.remove(i);
                break;
            }
        }
        SerialiseCoolingSystemParts();
        return obj;
    }

    private CpuPart AddCpuToComputer(String name) {
        CpuPart obj = null;
        for (int i = 0; i < ListOfCpuParts.size(); i++) {
            if (name.equals(ListOfCpuParts.get(i).getNameOfPart())) {
                obj = ListOfCpuParts.get(i);
                ListOfCpuParts.remove(i);
                break;
            }
        }
        SerializeCpuParts();
        return obj;
    }


    private GpuPart AddGpuToComputer(String name) {
        GpuPart obj = null;
        for (int i = 0; i < ListOfGpuParts.size(); i++) {
            if (name.equals(ListOfGpuParts.get(i).getNameOfPart())) {
                obj = ListOfGpuParts.get(i);
                ListOfGpuParts.remove(i);
                break;
            }
        }
        SerializeGpuParts();
        return obj;
    }

    private MemoryPart AddMemoryToComputer(String name) {
        MemoryPart obj = null;
        for (int i = 0; i < ListOfMemoryParts.size(); i++) {
            if (name.equals(ListOfMemoryParts.get(i).getNameOfPart())) {
                obj = ListOfMemoryParts.get(i);
                ListOfMemoryParts.remove(i);
                break;
            }
        }
        SerializeMemoryParts();
        return obj;
    }

    private MotherBoardPart AddMotherBoardToComputer(String name) {
        MotherBoardPart obj = null;
        for (int i = 0; i < ListOfMotherBoardParts.size(); i++) {
            if (name.equals(ListOfMotherBoardParts.get(i).getNameOfPart())) {
                obj = ListOfMotherBoardParts.get(i);
                ListOfMotherBoardParts.remove(i);
                break;
            }
        }
        SerializeMotherBoardParts();
        return obj;
    }

    private PsuPart AddPsuToComputer(String name) {
        PsuPart obj = null;
        for (int i = 0; i < ListOfPsuParts.size(); i++) {
            if (name.equals(ListOfPsuParts.get(i).getNameOfPart())) {
                obj = ListOfPsuParts.get(i);
                ListOfPsuParts.remove(i);
                break;
            }
        }
        SerializePsuParts();
        return obj;
    }

    private RAMPart AddRamToComputer(String name) {
        RAMPart obj = null;
        for (int i = 0; i < ListOfRamParts.size(); i++) {
            if (name.equals(ListOfRamParts.get(i).getNameOfPart())) {
                obj = ListOfRamParts.get(i);
                ListOfRamParts.remove(i);
                break;
            }
        }
        SerializeRamParts();
        return obj;
    }

    private SystemUnitPart AddSystemUnitToComputer(String name) {
        SystemUnitPart obj = null;
        for (int i = 0; i < ListOfSystemUnitParts.size(); i++) {
            if (name.equals(ListOfSystemUnitParts.get(i).getNameOfPart())) {
                obj = ListOfSystemUnitParts.get(i);
                ListOfSystemUnitParts.remove(i);

                break;
            }
        }
        SerializeSystemUnitParts();
        return obj;
    }


}


