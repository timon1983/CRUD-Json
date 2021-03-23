package repository.json;

import Model.User;
import repository.GenericReposiroty;
import repository.UserRepository;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;


public class JsonUserRepositoryImpl implements UserRepository {

    private File file = new File("users.json");
    private GenericReposiroty postRepository = new JsonPostRepositoryImpl();
    private Reader reader = new FileReaderUser();
    private Writer writer = new FileWriterUser();


    @Override
    public User getByld(Long id) {

        List<User> users = reader.read(file);

        for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        List<User> users = reader.read(file);
        return users;
    }


    @Override
    public User save(User user) {

        long newUserId;
        long newRegionId;

        List<User> users = reader.read(file);

        if(users.size() == 0){
            newUserId = 1;
            newRegionId = 1;
        } else {
            newUserId = users.get(users.size() - 1).getId() + 1;
            newRegionId = users.get(users.size() - 1).getRegion().getId() + 1;
        }
        user.setId(newUserId);
        user.getRegion().setId(newRegionId);
        users.add(user);

        writer.write(users, file);

        return user;
    }


    @Override
    public User update(User user) {

        List<User> users = reader.read(file);

        List<User> userUpdate = users.stream().map(n -> {if(n.getId() == user.getId()){
             n.setFirstName(user.getFirstName());
             n.setLastName(user.getLastName());
             n.setRegion(n.getRegion());}
             return n;
         }).collect(Collectors.toList());
        User newUser = userUpdate.stream().filter(n -> n.getId() == user.getId()).findFirst().
                orElse(null);

        writer.write(userUpdate, file);

        return newUser;
    }


    @Override
    public void deleteByld(Long id) {

        List<User> users = reader.read(file);

        List<User> userUpdate = users.stream().map(n -> {if(n.getId() == id){
            users.remove(n);}
            return n;}).collect(Collectors.toList());

        writer.write(userUpdate, file);
    }
}

