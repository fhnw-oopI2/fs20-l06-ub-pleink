package ui;

import tasky.*;
import tasky.commandPattern.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLI {

    public static Scanner in;
    public static TaskyLogic taskyLogic = new TaskyLogic();
    public static String command;

    private Map<String, Command> commands = new HashMap<>();

    public CLI(){
        in = new Scanner(System.in);

        commands.put("add", new AddCommand());
        commands.put("delete", new DeleteCommand());
        commands.put("exit", new ExitCommand());
        commands.put("show", new ShowCommand());
        commands.put("update", new UpdateCommand());
        commands.put("help", new HelpCommand());
    }

    public void run() {
        System.out.println(" == Welcome to Tasky CLI == ");

        Command Execute;

        while(true) {
            command = in.nextLine();
            try {
                Execute = commands.get(command);
                Execute.execute();
            } catch (NullPointerException e) {
                Execute = commands.get("help");
                Execute.execute();
            }

        }
    }
}

