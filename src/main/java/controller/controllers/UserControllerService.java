package controller.controllers;

import Model.Post;
import Model.Region;
import Model.User;
import controller.PostController;
import controller.RegionController;
import controller.UserController;
import repository.GenericReposiroty;
import repository.json.JsonPostRepositoryImpl;
import repository.json.JsonRegionRepositoryImpl;
import repository.json.JsonUserRepositoryImpl;

import java.util.List;

public class UserControllerService implements UserController {

    private GenericReposiroty userRepository = new JsonUserRepositoryImpl();
    private GenericReposiroty postRepository = new JsonPostRepositoryImpl();
    private GenericReposiroty regionRepository = new JsonRegionRepositoryImpl();
    private RegionController regionController = new RegionControllerService();


    @Override
    public User checkSave(String firstName, String lastName, String regionName) {
        List<Post> posts = postRepository.getAll();

        Region region = regionController.checkSave(regionName);
        User user = new User(0, firstName, lastName, posts, region);
        return (User) userRepository.save(user);
    }

    @Override
    public User checkGetByld(Long id) {

        return (User) userRepository.getByld(id);
    }

    @Override
    public void checkGetAll() {
        List<User> allUsers = userRepository.getAll();
        if (allUsers == null) {
            System.out.println("The list of users is empty");
        } else {
            allUsers.stream().forEach(x -> System.out.println(x));
        }
    }

    @Override
    public User checkUpdate(Long id,String firstName, String lastName, String regionName) {
        List<Post> posts = postRepository.getAll();
        Region newRegion = (Region) regionRepository.save(new Region(0L, regionName));
        User newUser = new User(Math.toIntExact(id), firstName, lastName, posts, newRegion);

        return (User) userRepository.update(newUser);
    }

    @Override
    public void checkDeleteByld(Long id) {
        userRepository.deleteByld(id);
    }
}
