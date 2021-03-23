package repository.json;

import Model.Region;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterRegion implements WriterRegion{

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void write(List<Region> list, File file) {

        List<Region> regionUpdate = list;
        JsonArray jsonArrayWrite = new JsonArray();
        for(int i = 0; i < regionUpdate.size(); i++){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", regionUpdate.get(i).getId());
            jsonObject.addProperty("name", regionUpdate.get(i).getName());
            jsonArrayWrite.add(jsonObject);
        }
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(gson.toJson(jsonArrayWrite));
        } catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
