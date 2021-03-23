package controller.controllers;

import Model.Post;
import Model.User;
import controller.PostController;
import repository.GenericReposiroty;
import repository.json.JsonPostRepositoryImpl;

import java.util.List;

public class PostControllerService implements PostController {

    private GenericReposiroty postRepository = new JsonPostRepositoryImpl();

    @Override
    public Post checkSave(String content, Long created, Long updated) {
        Post post = new Post(0L, content, created, updated );
        return (Post) postRepository.save(post);
    }

    @Override
    public Post checkGetByld(Long id) {

        return (Post) postRepository.getByld(id);
    }

    @Override
    public void checkGetAll() {
        List<Post> allPosts = postRepository.getAll();
        if (allPosts == null) {
            System.out.println("The list of posts is empty");
        } else {
            allPosts.stream().forEach(x -> System.out.println(x));
        }
    }



    @Override
    public Post checkUpdate(Long id, String content, Long created, Long updated) {
        Post post = new Post(id, content, created, updated );
        return (Post) postRepository.update(post);
    }

    @Override
    public void checkDeleteByld(Long id) {
        postRepository.deleteByld(id);
    }
}
