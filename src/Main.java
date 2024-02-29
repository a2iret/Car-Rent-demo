import models.Renter;
import services.RenterService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RenterService renterService = new RenterService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите сохранить себя как пользователя нажмите 1.\n Хотите арендовать машину нажмите 2");
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

        }else if(choice == 2){

        }

        ArrayList<Renter> allUsers = renterService.getAllUsers();
        for (int i = 1; i < allUsers.size(); i++){
            System.out.println("№" + i + "\n" + allUsers.get(i));
        }

    }
}
