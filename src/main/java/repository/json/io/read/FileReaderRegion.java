package repository.json.io.read;

import Model.Region;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class FileReaderRegion implements Reader {

    @Override
    public List read(File file) {
        List<Region> regions = new ArrayList<>();
        Gson gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            regions = gson.fromJson(br, JsonArray.class).stream().map(n -> {
                return gson.fromJson(n , Region.class);
            }).collect(Collectors.toList());
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


