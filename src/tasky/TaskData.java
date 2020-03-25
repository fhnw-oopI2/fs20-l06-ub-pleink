package tasky;

import java.time.LocalDate;

public class TaskData {
    private State state;
    private String title;
    private String desc;
    private LocalDate due;

    public TaskData(String title, String desc, LocalDate due, State state){
        this.title = title;
        this.desc = desc;
        this.due = due;
        this.state = state;
    }

    public String toString(){
        String out;
        out = "Title: " + title + "\n" +
                "Desription: " + desc + "\n" +
                "Due date: " + due +  "\n" +
                "State: " + state;
        return out;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDue() {
        return due;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }


}
