package view;

import controller.UserController;
import controller.controllers.UserControllerService;

import java.util.Scanner;

public class UserView implements View {

    private Scanner in = new Scanner(System.in);
    private UserController userController = new UserControllerService();
    private View startView = new StartView();

    @Override
    public void doChoise() {
        long idIn;
        String firstNameIn;
        String lastNameIn;
        long regionIdIn;
        String regionNameIn;
        System.out.println("1-Create user\n2-Get user by id\n3-Get all users\n" +
                "4-Change record\n5-Delete user\n6-Exit");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Create user");
                    System.out.println("Enter the firstname");
                    firstNameIn = in.next();
                    System.out.println("Enter the lasttname");
                    lastNameIn = in.next();
                    System.out.println("Enter the region name");
                    regionNameIn = in.next();
                    System.out.println(userController.checkSave(firstNameIn, lastNameIn, regionNameIn));
                    doChoise();

                case 2:
                    System.out.println("Get user by id\nEnter the id:");
                    idIn = in.nextLong();
                    if(userController.checkGetByld(idIn) == null){
                        System.out.println("User whith this <id> is not exist");
                    }else {
                        System.out.println(userController.checkGetByld(idIn));
                    }
                    doChoise();
                case 3:
                    System.out.println("Get all users");
                    userController.checkGetAll();
                    doChoise();
                case 4:
                    System.out.println("Change record");
                    System.out.println("Enter the id of user to change his");
                    idIn = in.nextLong();
                    System.out.println("Enter the new firstname");
                    firstNameIn = in.next();
                    System.out.println("Enter the new lastname");
                    lastNameIn = in.next();
                    System.out.println("Enter the new regionname");
                    regionNameIn = in.next();
                    System.out.println(userController.checkUpdate(idIn, firstNameIn, lastNameIn, regionNameIn));
                    doChoise();
                case 5:
                    System.out.println("Delete user\nEnter the id of user to delete his");
                    idIn = in.nextLong();
                    userController.checkDeleteByld(idIn);
                    doChoise();
                case 6:
                    System.out.println("Exit to main menu");
                    startView.doChoise();

            }
        }while (true);

    }
}
