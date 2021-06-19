package repository.json.io.read;

import Model.Post;
import Model.Region;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderPost implements ReaderPost{
    @Override
    public List<Post> read(File file) {
        List<Post> posts = new ArrayList<>();
        Gson gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            posts = gson.fromJson(br, new TypeToken<List<Region>>() {}.getType());
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
