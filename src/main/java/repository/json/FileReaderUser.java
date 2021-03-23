package repository.json;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileReaderUser implements ReaderUser {

    Gson gson = new Gson();

    @Override
    public List<User> read(File file) {

                List<User> users = new ArrayList<>();
                try(BufferedReader br = new BufferedReader(new FileReader(file))){
                    JsonArray jsonArrayRead = gson.fromJson(br, JsonArray.class);
                    for(int i = 0; i < jsonArrayRead.size(); i++){
                        User userFromJson = gson.fromJson(jsonArrayRead.get(i), User.class);
                        users.add(userFromJson);
                    }
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

