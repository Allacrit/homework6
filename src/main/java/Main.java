import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("A5", 1236, "Xiaomi");
        notebook1.setColor("black");
        notebook1.setHdd(700);
        notebook1.setOs("Windows");
        notebook1.setRam(32);

        Notebook notebook2 = new Notebook("ABC30", 6467, "Acer");
        notebook2.setColor("white");
        notebook2.setHdd(1000);
        notebook2.setOs("Windows");
        notebook2.setRam(16);

        Notebook notebook3 = new Notebook("AB97", 67201, "Acer");
        notebook3.setColor("rose");
        notebook3.setHdd(900);
        notebook3.setOs("Windows");
        notebook3.setRam(16);

        Notebook notebook4 = new Notebook("OMAN11", 1111, "hp");
        notebook4.setColor("black");
        notebook4.setHdd(700);
        notebook4.setOs("Linux");
        notebook4.setRam(8);

        Notebook notebook5 = new Notebook("MAC101", 8438483, "Apple");
        notebook5.setColor("silver");
        notebook5.setHdd(1000);
        notebook5.setOs("macOS");
        notebook5.setRam(8);

        HashSet<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5));
        HashSet<Notebook> result = new HashSet<>();

        System.out.println("Здравствуйте!");

        Scanner scanner = new Scanner(System.in);
        int nextCommand = 0;

        HashMap<String, Object> filters = new HashMap<>();

        while (nextCommand != 5) {
            printCommand();
            nextCommand = scanner.nextInt();
            switch (nextCommand) {
                case 1:
                    System.out.println("Введите минимальную оперативную память");
                    int ram = scanner.nextInt();
                    filters.put("RAM", ram);
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД");
                    int hdd = scanner.nextInt();
                    filters.put("HDD", hdd);
                    break;
                case 3:
                    System.out.print("""
                               1. - Windows
                               2. - Linux
                               3. - macOS
                            Введите ОС:\s""");
                    int temp = scanner.nextInt();
                    switch (temp) {
                        case 1 -> filters.put("OS", "Windows");
                        case 2 -> filters.put("OS", "Linux");
                        case 3 -> filters.put("OS", "macOS");
                    }
                case 4:
                    System.out.print("Введите цвет: ");
                    scanner.nextLine();
                    String color = scanner.nextLine();
                    filters.put("color", color);
                    break;
            }
        }

        for (Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getKey().equals("RAM")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getRam() >= (int) entry.getValue()) {
                        result.add(notebook);
                    }
                }
            }
            if (entry.getKey().equals("HDD")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getHdd() >= (Integer) entry.getValue()) {
                        result.add(notebook);
                    }
                }
            }
            if (entry.getKey().equals("OS")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getOs().equals(entry.getValue())) {
                        result.add(notebook);
                    }
                }
            }
            if (entry.getKey().equals("color")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getColor().equals(entry.getValue())) {
                        result.add(notebook);
                    }
                }
            }
        }

        for (Notebook notebook : result) {
            System.out.println();
            System.out.println(notebook.toString());
        }
    }

    private static void printCommand() {
        System.out.print("""
                   1. - ОЗУ\s
                   2. - Объем ЖД\s
                   3. - Операционная система\s
                   4. - Цвет\s
                   5. - Чтобы осуществить поиск
                Введите цифру, соответствующую необходимому критерию:\s""");
    }
}
