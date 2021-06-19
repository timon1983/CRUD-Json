package repository.json.io.read;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUser implements ReaderUser {

    @Override
    public List<User> read(File file) {
        List<User> users = new ArrayList<>();
        Gson gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            users = gson.fromJson(br, new TypeToken<List<User>>(){}.getType());
        }catch (FileNotFoundException e){
                    File fileJson = new File("users.json");
                    try {
                        fileJson.createNewFile();
                    } catch (IOException ioException) {
                        System.out.println("Ошибка создания файла");;
                    }
                }
                catch(IOException e) {
                    System.out.println("Произошла ошибка ввода-вывода");
                }
                return users;
    }
}

