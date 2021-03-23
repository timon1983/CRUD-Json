package repository.json;

import Model.Post;
import Model.Region;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderRegion implements Reader {

    Gson gson = new Gson();

    @Override
    public List read(File file) {
        List<Region> regions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            JsonArray jsonArrayRead = gson.fromJson(br, JsonArray.class);

            for (int i = 0; i < jsonArrayRead.size(); i++) {
                Region regionFromJson = gson.fromJson(jsonArrayRead.get(i), Region.class);
                regions.add(regionFromJson);
            }
        } catch (FileNotFoundException e){
            File fileJson = new File("regions.json");
            try {
                fileJson.createNewFile();
            } catch (IOException ioException) {
                System.out.println("Ошибка создания файла");;
            }
        } catch(IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return regions;
    }
}


