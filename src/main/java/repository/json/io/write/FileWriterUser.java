package repository.json.io.write;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterUser implements WriterUser{

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void write(List<User> list, File file) {

        List<User> userUpdate = list;
        JsonArray jsonArrayWrite = new JsonArray();
        for(int i = 0; i < userUpdate.size(); i++){
            JsonArray jsonArrayPost = new JsonArray();
            JsonObject jsonObjectRegion = new JsonObject();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", userUpdate.get(i).getId());
            jsonObject.addProperty("firstName", userUpdate.get(i).getFirstName());
            jsonObject.addProperty("lastName", userUpdate.get(i).getLastName());
            for(int j = 0; j < userUpdate.get(i).getPosts().size(); j++){
                JsonObject jsonObjectPost = new JsonObject();
                jsonObjectPost.addProperty("id", userUpdate.get(i).getPosts().get(j).getId());
                jsonObjectPost.addProperty("content", userUpdate.get(i).getPosts().get(j).getContent());
                jsonObjectPost.addProperty("created", userUpdate.get(i).getPosts().get(j).getCreated());
                jsonObjectPost.addProperty("updated", userUpdate.get(i).getPosts().get(j).getUpdated());
                jsonArrayPost.add(jsonObjectPost);
            }
            jsonObject.add("posts", jsonArrayPost);
            jsonObjectRegion.addProperty("id", userUpdate.get(i).getRegion().getId());
            jsonObjectRegion.addProperty("name", userUpdate.get(i).getRegion().getName());
            jsonObject.add("region",jsonObjectRegion);

            jsonArrayWrite.add(jsonObject);
        }
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(gson.toJson(jsonArrayWrite));
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
