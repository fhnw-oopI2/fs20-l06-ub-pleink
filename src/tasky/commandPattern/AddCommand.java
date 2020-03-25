package tasky.commandPattern;

import java.time.LocalDate;

import static ui.CLI.in;
import static ui.CLI.taskyLogic;

public class AddCommand implements Command {


    @Override
    public void execute() {

        String titel, desc;
        LocalDate due;
        System.out.println("Title: ");
        titel = in.nextLine();
        System.out.println("Description: ");
        desc = in.nextLine();
        System.out.println("Due date (YYYY-MM-DD): ");
        due = taskyLogic.checkDate(in.nextLine());
        taskyLogic.createTask(titel, desc, due);
    }
}
