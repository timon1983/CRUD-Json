package controller;

import Model.Region;

public interface RegionController{
    Region checkSave(String name);

    Region checkGetByld(Long id);

    void checkGetAll();

    Region checkUpdate(Long id, String name);

    void checkDeleteByld(Long id);
}
