package jp.files.practice.TaskManager;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import jp.linkedlist.singly.LinkedList;
import jp.util.array.Array;
import jp.util.iterator.Iterator;

public class TaskManager {
    
    static LinkedList<Task> taskList = new LinkedList<>();
    
    public static boolean addTask(String taskName, int priority){
        try{
            if(priority>1){
                priority = 1;
            }
            Task task = new Task(taskName, priority);
            if(!taskList.contains(task)){
                taskList.add(task);
            }
            ToIntFunction<Task> comparator = (Task a) -> -a.getPriority();
            taskList.sort(comparator);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void tostringList(){
        Iterator<Task> iterator = taskList.iterator();
        while(iterator.hasNext()){
            iterator.next().toStringg();
        }
    }

    public static boolean removeTask(String taskName){
        Iterator<Task> iterator = taskList.iterator();

        Predicate<Task> filter = task -> task.getName().equals(taskName);
        taskList.remove(filter);
        return true;
    }

    public static boolean markComplete(String taskName){
        Iterator<Task> iterator = taskList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getName().equals(taskName)){
                iterator.next().setStatus(true);
            }
        }
        return true;
    }

    public static Task[] displayTasks(){
        return taskList.toArray();
    }   
    
    public static boolean removeCompletedTasks(){
        Predicate<Task> filter = task -> task.getStatus()==true;
        taskList.remove(filter);
        return true;
    }

    public static Task[] sortTasksByName(){
        ToIntFunction<Task> comparator = (Task task) -> task.getName().compareTo("");
        taskList.sort(comparator);
        
        return taskList.toArray();
    }


    public static void main(String[] args) {

        addTask("Estudiar", 0);
        addTask("Lavar ropa", 1);
        addTask("Limpiar pieza", 1);
        tostringList();
        System.out.println("-------------------------------------");
        removeTask("Estudiar");
        tostringList();
        System.out.println("-------------------------------------");
        markComplete("Lavar ropa");
        tostringList();
        System.out.println("----------------------------------------");
        removeCompletedTasks();
        tostringList();
        System.out.println("------------------------------------------");
        addTask("Amar", 0);
        addTask("Bailar", 0);
        tostringList();
    }
}
