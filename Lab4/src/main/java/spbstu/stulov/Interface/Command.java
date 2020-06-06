package spbstu.stulov.Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {
    public enum TASK_TYPE {
        ADD("\\add", 3),
        DELETE("\\delete", 2),
        SHOW_ALL("\\show_all", 1),
        PRICE("\\price", 2),
        CHANGE_PRICE("\\change_price", 3),
        FILTER_BY_PRICE("\\filter_by_price", 3),
        EXIT("\\exit", 1),
        ERROR("ERROR", 0);

        private String command;
        private int wordAmount;

        TASK_TYPE(String command, int amount) {
            this.command = command;
            this.wordAmount = amount;
        }

        public int getSize() {
            return wordAmount;
        }

        @Override
        public String toString() {
            return command;
        }
    }

    private BufferedReader bufferedReader;

    private List<String> commadComponents;

    private TASK_TYPE commandType;

    public Command() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.commadComponents = new ArrayList<>();
        this.commandType = TASK_TYPE.ERROR;
    }

    public void read() throws Exception {
        this.commandType = TASK_TYPE.ERROR;

        final String[] components = bufferedReader.readLine().split(" ");

        this.commadComponents = new ArrayList<>(components.length);

        for (var component : components) {
            commadComponents.add(component);
        }

        detecCommand();
    }

    public List<String> getComponents() {
        return commadComponents;
    }

    public TASK_TYPE getType() {
        return commandType;
    }

    private void detecCommand() {
        for (var command : TASK_TYPE.values()) {
            boolean COMMAND_IS_CORRECT =
                    commadComponents.get(0).equals(command.command) && (commadComponents.size() == command.wordAmount);
            if (COMMAND_IS_CORRECT) {
                commandType = command;
                break;
            }
        }
    }
}
