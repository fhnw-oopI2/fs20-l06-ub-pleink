package tasky.commandPattern;

import tasky.State;
import tasky.Task;
import tasky.TaskData;
import static ui.CLI.in;
import static ui.CLI.taskyLogic;

public class UpdateCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Id of task: ");
        long tempId = in.nextLong();
        Task tempTask = taskyLogic.read(tempId);
        TaskData tempData = tempTask.getData();
        System.out.println("Choose option:\n" +
                "[1] everything\n" +
                "[2] title\n" +
                "[3] description\n" +
                "[4] due date\n" +
                "[5] update state");
        switch (in.nextInt()){
            case 1:
                System.out.println("title: ");
                tempData.setTitle(in.next());
                System.out.println("description: ");
                tempData.setDesc(in.next());
                System.out.println("due date (YYYY-MM-DD): ");
                tempData.setDue(taskyLogic.checkDate(in.next()));
                System.out.println("New state of task (todo, doing, done): ");
                String tempString = in.next().toUpperCase();
                try {
                    State tempState = State.valueOf(tempString);
                    taskyLogic.changeState(tempId, tempState);
                    System.out.println("Changed state to: " + tempString);
                    in.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("state not available!");
                }
                in.next();
                break;

            case 2:
                System.out.println("title: ");
                tempData.setTitle(in.next());
                in.next();
                break;

            case 3:
                System.out.println("description: ");
                tempData.setDesc(in.next());
                in.next();
                break;

            case 4:
                System.out.println("due date (YYYY-MM-DD): ");
                tempData.setDue(taskyLogic.checkDate(in.next()));
                in.next();
                break;

            case 5:
                System.out.println("New state of task (todo, doing, done): ");
                tempString = in.next().toUpperCase();
                try {
                    State tempState = State.valueOf(tempString);
                    taskyLogic.changeState(tempId, tempState);
                    System.out.println("Changed state to: " + tempString);
                    in.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("state not available!");
                }
                break;

            default:
                System.out.println("No valid option!");
        }
        taskyLogic.updateTask(tempId, tempData.getTitle(), tempData.getDesc(), tempData.getState(), tempData.getDue());

        return;
    }
}
