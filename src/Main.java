import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String GOS_NUM_SYMBOLS = "аукенхвросмт";
    private static final String GOS_NUM_NUMBERS = "0123456789";

    public static void main(String[] args) {
        System.out.println("Хомяков Даниил Васильевич\nРИБО-05-22\nВариант №1");
        ArrayList<Car> CarList = new ArrayList<>();
        CarList.add(new Car("Haval H6", 2020, "т121ре"));
        CarList.add(new Car("Lada Vesta", 2016, "у670ор"));
        CarList.add(new Car("Nissan GTR", 2018, "о007ер"));
        CarList.add(new Car("Porshe 911", 2022, "с670то"));
        CarList.add(new Car("Volvo s90", 2013, "е335ту"));

        Scanner scan = new Scanner(System.in);
        int deystvie = 0;
        int year = 0;
        int flag = 0;
        int prov1 = 0;
        while (deystvie != 5) {
            System.out.println("\nВыберите действие: \n" +
                    "1 - Показать список автомобилей\n" +
                    "2 - Добавить новый автомобиль в список\n" +
                    "3 - Удалить автомобиль по госномеру\n" +
                    "4 - Очистить список\n" +
                    "5 - Выход");
            if (scan.hasNextInt()) {
                deystvie = scan.nextInt();
                scan.nextLine(); // Transit on next line
            } else {
                System.out.println("Ошибка! Введите число:");
                deystvie = 0;
                scan.nextLine();
            }
            if (deystvie == 1) {
                for (Car c : CarList) {
                    System.out.println(c.getMarka() + " " + c.getYear() + " " + c.getGosnomer());
                }
                if (CarList.isEmpty()) {
                    System.out.println("Список пуст");
                }
            }
            if (deystvie == 2) {
                System.out.println("Введите марку автомобиля: ");
                String marka = scan.nextLine();
                while (marka.isEmpty()) {
                    System.out.println("Не введена марка автомобиля, попробуйте еще раз:");
                    marka = scan.nextLine();
                }
                System.out.println("Введите год выпуска автомобиля: ");
                while (flag != 1) {
                    if (scan.hasNextInt()) {
                        year = scan.nextInt();
                        scan.nextLine(); // Transit on next line
                        if (year > 1800 && year < 2025) {
                            flag = 1;
                        } else {
                            System.out.println("Ошибка! Введен неправильный год\n Попробуйте еще раз:");
                            flag = 0;

                        }
                    } else {
                        System.out.println("Ошибка! Введите число:");
                        flag = 0;
                        scan.nextLine();// Transit on next line
                    }
                }

                System.out.println("Введите ГосНомер автомобиля в данном формате - х000хх : ");
                String gosnomer = scan.nextLine();
                while (prov1 != 1) {
                    String[] chars = gosnomer.split("");
                    if (gosnomer.length() == 6) {
                        if (GOS_NUM_SYMBOLS.contains(chars[0]) &&
                                GOS_NUM_NUMBERS.contains(chars[1]) &&
                                GOS_NUM_NUMBERS.contains(chars[2]) &&
                                GOS_NUM_NUMBERS.contains(chars[3]) &&
                                GOS_NUM_SYMBOLS.contains(chars[4]) &&
                                GOS_NUM_SYMBOLS.contains(chars[5])) {
                            prov1 = 1;
                        } else {
                            System.out.println("ГосНомер имеет следующий формат: x000xx и содержит только буквы :аукенхвросмт, пожалуйста введите верный вариант:");
                            gosnomer = scan.nextLine();
                        }
                    } else {
                        System.out.println("ГосНомер имеет следующий формат: x000xx, пожалуйста введите верный вариант:");
                        gosnomer = scan.nextLine();
                    }

                    for (Car c : CarList) {
                        if (c.getGosnomer().equals(gosnomer)) {
                            System.out.println("Автомобиль с данным госномером уже существует. Попробуйте еще раз:");
                            gosnomer = scan.nextLine();
                            prov1 = 0;

                        }
                    }
                }
                CarList.add(new Car(marka, year, gosnomer));
                System.out.println("Автомобиль успешно добавлен!");
                for (Car c : CarList) {
                    System.out.println(c.getMarka() + " " + c.getYear() + " " + c.getGosnomer());
                }
                year = 0;
                flag = 0;
                prov1 = 0;

            }
            if (deystvie == 3) {
                System.out.println("Введите ГосНомер автомобиля, который хотите удалить:");
                for (Car c : CarList) {
                    System.out.println(c.getMarka() + " " + c.getYear() + " " + c.getGosnomer());
                }
                String gosnomer = scan.next();
                for (Car c : CarList) {
                    if (c.getGosnomer().equals(gosnomer)) {
                        CarList.remove(c);
                        System.out.println("Автомобиль удален из списка!");
                        break;
                    }
                }
                for (Car c : CarList) {
                    System.out.println(c.getMarka() + " " + c.getYear() + " " + c.getGosnomer());
                }
            }
            if (deystvie == 4) {
                CarList.clear();
                System.out.println("Список очищен!");
            }
        }
    }
}