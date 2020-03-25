package tasky.commandPattern;

import static ui.CLI.in;
import static ui.CLI.taskyLogic;

public class DeleteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Id of task: ");
        taskyLogic.deleteTask(in.nextLong());
        System.out.println("Deleted task successful");
    }
}