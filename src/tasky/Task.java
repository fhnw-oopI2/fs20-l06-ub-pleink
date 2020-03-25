package tasky;

import java.util.Objects;

public class Task {
    TaskData data;
    private long id;
    private static long counter = 0;


    public Task(TaskData data){
        id = counter;
        this.data = data;
        counter++;
    }

    public String toString(){
        return "ID: " + id + "\n" + data.toString();
    }

    public TaskData getData() {
        return data;
    }

    public void setData(TaskData data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
