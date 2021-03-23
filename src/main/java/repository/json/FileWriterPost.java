package repository.json;

import Model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterPost implements WriterPost{

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void write(List<Post> list, File file) {

        List<Post> postUpdate = list;
        JsonArray jsonArrayWrite = new JsonArray();
        for(int i = 0; i < postUpdate.size(); i++){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", postUpdate.get(i).getId());
            jsonObject.addProperty("content", postUpdate.get(i).getContent());
            jsonObject.addProperty("created", postUpdate.get(i).getCreated());
            jsonObject.addProperty("updated", postUpdate.get(i).getUpdated());
            jsonArrayWrite.add(jsonObject);
        }
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(gson.toJson(jsonArrayWrite));
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
