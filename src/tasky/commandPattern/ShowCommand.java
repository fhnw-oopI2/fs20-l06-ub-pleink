package tasky.commandPattern;

import tasky.Task;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static ui.CLI.command;
import static ui.CLI.in;
import static ui.CLI.taskyLogic;

public class ShowCommand implements Command {

    private Map<String, Comparator<Task>> commands = new HashMap<>();

    public ShowCommand(){
        commands.put("title", (Task t1, Task t2) -> t1.getData().getTitle().compareTo(t2.getData().getTitle()));
        commands.put("desc", (Task t1, Task t2) -> t1.getData().getDesc().compareTo(t2.getData().getDesc()));
        commands.put("state", (Task t1, Task t2) -> t1.getData().getState().compareTo(t2.getData().getState()));
        commands.put("due", (Task t1, Task t2) -> t1.getData().getDue().compareTo(t2.getData().getDue()));
    }

    @Override
    public void execute() {
        System.out.println("Show one by ID -> ID x \n" +
                "Order by title | desc | state | due \n" +
                "add \" reverse\" for reverse sort");

        command = in.nextLine();
        String commandSplit[] = command.split(" ");
        if (!commandSplit[0].equals("ID")) {
            Comparator<Task> comparator;
            try {
                comparator = commands.get(commandSplit[0]);
                if (commandSplit.length == 2 && commandSplit[1].equals("reverse")){
                    comparator.reversed();
                }
                taskyLogic.sorter(comparator);
            } catch (NullPointerException e) {
                System.out.println("show tasks in current order!");
            } finally {
                for (Task task : taskyLogic.read()) {
                    System.out.println(task + "\n");
                }
            }
        } else {
            System.out.println(taskyLogic.read(Long.parseLong(commandSplit[1])));
        }
    }
}
