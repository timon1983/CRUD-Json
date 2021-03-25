package repository.json.io.read;

import Model.Post;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class FileReaderPost implements ReaderPost{

    @Override
    public List<Post> read(File file) {
        List<Post> posts = new ArrayList<>();
        Gson gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            posts = gson.fromJson(br, JsonArray.class).stream().map(n -> {
                return gson.fromJson(n , Post.class);
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e){
            File fileJson = new File("posts.json");
            try {
                fileJson.createNewFile();
            } catch (IOException ioException) {
                System.out.println("Ошибка создания файла");;
            }
        } catch(IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return posts;
    }
}
