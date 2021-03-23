package view;

import controller.RegionController;
import controller.controllers.RegionControllerService;

import java.util.Scanner;

public class RegionView implements View{

    private Scanner in = new Scanner(System.in);
    private RegionController regionController = new RegionControllerService();
    private View startView = new StartView();

    @Override
    public void doChoise() {

        long idIn;
        String nameIn;
        System.out.println("1 - Create region\n2 - Get region by id\n3 - Get all regions\n" +
                "4 - Change region\n5 - Delete region\n6 - Exit");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Create region");
                    System.out.println("Enter the name of region");
                    nameIn = in.next();
                    System.out.println(regionController.checkSave(nameIn));
                    doChoise();
                case 2:
                    System.out.println("Get region by id\nEnter the id:");
                    idIn = in.nextLong();
                    if(regionController.checkGetByld(idIn) == null){
                        System.out.println("The region whith this <id> is not exist");
                    }else {
                        System.out.println(regionController.checkGetByld(idIn));
                    }
                    doChoise();
                case 3:
                    System.out.println("Get all regions");
                    regionController.checkGetAll();
                    doChoise();
                case 4:
                    System.out.println("Change region");
                    System.out.println("Enter the id of region to change his");
                    idIn = in.nextLong();
                    System.out.println("Enter the new nema of region");
                    nameIn = in.next();
                    System.out.println(regionController.checkUpdate(idIn, nameIn));
                    doChoise();
                case 5:
                    System.out.println("Delete region\nEnter the id of region to delete his");
                    idIn = in.nextLong();
                    regionController.checkDeleteByld(idIn);
                    doChoise();
                case 6:
                    System.out.println("Exit to main menu");
                    startView.doChoise();
            }
        }while (true);
    }
}
