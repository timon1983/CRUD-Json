package controller;

import Model.Post;


public interface PostController{
    Post checkSave(String name, Long created, Long updated );

    Post checkGetByld(Long id);

    void checkGetAll();

    Post checkUpdate(Long id, String content, Long created, Long updated);

    void checkDeleteByld(Long id);
}
