package tasky;

import java.util.ArrayList;
import java.util.List;

public class Repo implements Repository{

    List<Task> repoList;

    public Repo(){
        repoList = new ArrayList<>();
    }

    @Override
    public Task create(TaskData taskData) {
        Task tempTask = new Task(taskData);
        repoList.add(tempTask);
        return tempTask;
    }

    @Override
    public void delete(long id) {
        for(Task task : repoList){
            if (task.getId() == id){
                System.out.println("Remove Task at index: " + repoList.indexOf(task));
                repoList.remove(task);
                return;
            }
        }
    }

    @Override
    public List<Task> read() {
        return repoList;
    }

    @Override
    public void update(Task task) {
        for (Task repoListTask : repoList){
            if (repoListTask.getId() == task.getId()){
                repoListTask = task;
                System.out.println("Updated Task at index: "+ repoList.indexOf(repoListTask));
                return;
            }
        }

    }

    @Override
    public Task read(long id) {
        for(Task task : repoList){
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }
}
