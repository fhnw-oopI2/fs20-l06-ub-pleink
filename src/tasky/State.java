package tasky;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum State {
    TODO, DOING, DONE;

    public static List<State> getAllStates(){
        return Stream.of(State.TODO, State.DOING, State.DONE)
                .collect(Collectors.toList());
    }
}
