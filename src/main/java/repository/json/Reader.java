package repository.json;

import java.io.File;
import java.util.List;

public interface Reader <T>{
    List<T> read(File file);
}
