package repository.json;

import Model.Post;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderPost implements ReaderPost{

    Gson gson = new Gson();

    @Override
    public List<Post> read(File file) {

        List<Post> posts = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            JsonArray jsonArrayRead = gson.fromJson(br, JsonArray.class);

                for (int i = 0; i < jsonArrayRead.size(); i++) {
                    Post postFromJson = gson.fromJson(jsonArrayRead.get(i), Post.class);
                    posts.add(postFromJson);
                }
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
