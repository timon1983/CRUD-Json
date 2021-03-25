package repository.json.io.write;

import java.io.File;
import java.util.List;

public interface Writer <T>{
    void write(List<T> list, File file);
}
