package tasky;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;

public class TaskyLogic {

    private static Repo repo;

    public TaskyLogic() {
        repo = new Repo();
        createTask("task 1", "aufgabe 1 was noch zu tun ist... und noch getan werden muss", checkDate("2020-02-02"));
        createTask("task 2", "aufgabe 2", checkDate("2020-01-01"));
    }

    public static void createTask(String title, String desc, LocalDate due) {
        TaskData taskData = new TaskData(title, desc, due, State.TODO);
        repo.create(taskData);
    }

    public static void deleteTask(long id) {
        repo.delete(id);
    }

    public static void changeState(long id, State state) {
        Task tempTask = repo.read(id);
        TaskData tempData = tempTask.getData();
        tempData.setState(state);
    }

    public static void updateTask(long id, String title, String desc, State state, LocalDate due) {
        Task tempTask = repo.read(id);
        TaskData tempData = tempTask.getData();
        tempData.setTitle(title);
        tempData.setDesc(desc);
        tempData.setState(state);
        tempData.setDue(due);
    }

    public static List<Task> read() {
        return repo.read();
    }

    public static Task read(long id) {
        return repo.read(id);
    }

    public static LocalDate checkDate(String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tempDate;
        try {
            tempDate = LocalDate.parse(date, dateFormat);
            return tempDate;
        } catch (DateTimeParseException e) {
            System.out.println("invalid date");
        }
        return null;
    }

    public void sorter(Comparator<Task> c) throws NullPointerException{
        repo.repoList.sort(c);
    }


}
