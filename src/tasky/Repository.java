package tasky;

import java.util.List;

public interface Repository {

    Task create(TaskData taskData);
    void delete(long id);
    List<Task> read();
    void update(Task task);
    Task read(long id);
}
