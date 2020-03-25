package tasky.commandPattern;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Supported commands: show | add | update | delete | exit");
    }
}
