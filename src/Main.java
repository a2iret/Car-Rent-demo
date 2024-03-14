import models.Car;
import models.RentInfo;
import models.Renter;
import models.enums.RentStatus;
import services.RenterService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        RenterService renterService = new RenterService();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (true){
            System.out.print("Хотите сохранить себя как пользователя нажмите 1.\nХотите арендовать машину нажмите 2.\n: ");
            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.print("Введите имя: ");
                String first_name = scanner.next();

                System.out.print("Введите фамилию: ");
                String last_name = scanner.next();

                System.out.print("Введите инн: ");
                String inn = scanner.next();

                System.out.print("Введите номер телефона: ");
                String phoneNum = scanner.next();

                System.out.print("Введите категорию вождения автомобиля: ");
                String driveCategory = scanner.next();

                Renter renter = new Renter(first_name, last_name, inn, phoneNum,
                        renterService.getDriveCategory(driveCategory));
                renterService.saveRenter(renter);

            }else if(choice == 2) {
                ArrayList<Car> cars = renterService.showCars();
                System.out.println("Список машин: ");

                for (int i = 0; i < cars.size(); i++) {
                    System.out.println(cars.get(i));
                }

                try {
                    System.out.print("Введите номер машины которую хотите арендавать: ");
                    int carNumber = scanner.nextInt();

                    System.out.print("Введите свой иденфикатор: ");
                    int renterId = scanner.nextInt();

                    System.out.println("Введите дату начала аренды (ГГГГ-ММ-ДД): ");
                    String startDateString = scanner.next();
                    Date startDate = new Date(dateFormat.parse(startDateString).getTime());

                    System.out.println("Введите дату окончания аренды (ГГГГ-ММ-ДД): ");
                    String endDateString = scanner.next();
                    Date endDate = new Date(dateFormat.parse(endDateString).getTime());

                    RentInfo rentInfo = new RentInfo(startDate, endDate, carNumber, renterId, RentStatus.IN_PROGRESS);
                    renterService.createRentInfo(rentInfo);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else System.out.println("Введите правильное значение!");
        }
    }
}
