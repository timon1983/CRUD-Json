package view;

import controller.PostController;
import controller.controllers.PostControllerService;

import java.util.Scanner;

public class PostView implements View {

    private Scanner in = new Scanner(System.in);
    private PostController postController = new PostControllerService();
    private View startView = new StartView();

    @Override
    public void doChoise() {

        long idIn;
        String contentIn;
        long createdIn;
        long updatedIn;

        System.out.println("1 - Create post\n2 - Get post by id\n3 - Get all posts\n" +
                "4 - Change post\n5 - Delete post\n6 - Exit");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Create post");
                    System.out.println("Enter the content");
                    contentIn = in.next();
                    System.out.println("Enter the created");
                    createdIn = in.nextLong();
                    System.out.println("Enter the updated");
                    updatedIn = in.nextLong();
                    System.out.println(postController.checkSave(contentIn, createdIn, updatedIn));
                    doChoise();
                case 2:
                    System.out.println("Get post by id\nEnter the id:");
                    idIn = in.nextLong();
                    if(postController.checkGetByld(idIn) == null){
                        System.out.println("The post whith this <id> is not exist");
                    }else {
                        System.out.println(postController.checkGetByld(idIn));
                    }
                    doChoise();
                case 3:
                    System.out.println("Get all posts");
                    postController.checkGetAll();
                    doChoise();
                case 4:
                    System.out.println("Change record");
                    System.out.println("Enter the id of post to change his");
                    idIn = in.nextLong();
                    System.out.println("Enter the new content");
                    contentIn = in.next();
                    System.out.println("Enter the new created");
                    createdIn = in.nextLong();
                    System.out.println("Enter the new updated");
                    updatedIn = in.nextLong();
                    System.out.println(postController.checkUpdate(idIn, contentIn, createdIn, updatedIn));
                    doChoise();
                case 5:
                    System.out.println("Delete post\nEnter the id of post to delete his");
                    idIn = in.nextLong();
                    postController.checkDeleteByld(idIn);
                    doChoise();
                case 6:
                    System.out.println("Exit to main menu");
                    startView.doChoise();
            }
        }while (true);
    }
}
