package controller;

import Model.Region;
import Model.User;

public interface UserController {
    User checkSave(String name1, String name2, String name3 );

    User checkGetByld(Long id);

    void checkGetAll();

    User checkUpdate(Long id , String name1, String name2, String name3);

    void checkDeleteByld(Long id);
}
