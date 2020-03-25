package tasky.commandPattern;

import tasky.Task;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


import static ui.CLI.in;
import static ui.CLI.taskyLogic;

public class ShowAllCommand implements Command {

    private Map<String, Comparator<Task>> commands = new HashMap<>();

    public ShowAllCommand(){
        commands.put("title", (Task t1, Task t2) -> t1.getData().getTitle().compareTo(t2.getData().getTitle()));
        commands.put("desc", (Task t1, Task t2) -> t1.getData().getDesc().compareTo(t2.getData().getDesc()));
        commands.put("state", (Task t1, Task t2) -> t1.getData().getState().compareTo(t2.getData().getState()));
        commands.put("due", (Task t1, Task t2) -> t1.getData().getDue().compareTo(t2.getData().getDue()));
    }

    @Override
    public void execute() {
        System.out.println("Order by title | desc | state | due ");

        String command;
        Comparator<Task> comparator;
        command = in.nextLine();
        String commandSplit[] = command.split("-");
        try {
            comparator = commands.get(command);
            taskyLogic.sorter(comparator);
        } catch (NullPointerException e) {
            System.out.println("show tasks in current order!");
        } finally {
            for (Task task : taskyLogic.read()) {
                System.out.println(task + "\n");
            }
        }


    }
}
