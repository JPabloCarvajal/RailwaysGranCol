package jp.files.SOLUCION_PARCIAL.TASK_MANAGER;

import java.util.function.ToIntFunction;

import jp.array.Array;
import jp.linkedlist.doubly.circular.LinkedList;
import jp.priorityQueue.PriorityQueue;
import jp.util.iterator.Iterator;

public class TaskManager {
    
    static Array<PriorityQueue<Task>> arrayOfPriorityQueue = new Array<>(25);
    
    public TaskManager(){
        for(int i = 0; i < 25; i++){
            // Crea una nueva instancia de PriorityQueue<Task> para cada cola de prioridad
            arrayOfPriorityQueue.add(new PriorityQueue<>(2));
        }
    }

    public static void addTask(Task task){
        int priorityIndex = 25 - task.getPriority();
    
        if(task.getTaskCategory().equals(TaskCategory.REQUIREMENT)){
            arrayOfPriorityQueue.get(priorityIndex).insert(0, task);
            return;
        }
        else if(task.getTaskCategory().equals(TaskCategory.DEVELOPMENT) || task.getTaskCategory().equals(TaskCategory.TESTING)){
            arrayOfPriorityQueue.get(priorityIndex).insert(1, task);
        }
    }

    public static void showTasks() {
        for (int i = 0; i < 25; i++) {
            Iterator<Task> iterator = arrayOfPriorityQueue.get(i).iterator();
            while (iterator.hasNext()) {

                Task task = iterator.next();
                System.out.println("\nPrioridad " + (25 - i) + ": ");
                task.toStringg();
            }
        }
    }
    

    public static void showAllTasks() {
        for (int i = 0; i < 25; i++) {
            System.out.println("\nPrioridad " + (25 - i) + ": ");
            System.out.println(arrayOfPriorityQueue.get(i).toString());
        }
    }
    

    public static Task searchTask(String name,String description){
        for(int i = 0; i < 25; i++){

            //iterador de la cola de prioridad de cada indice de array de 25 xd
            Iterator<Task> iterator = arrayOfPriorityQueue.get(i).iterator();

            while(iterator.hasNext()){
                Task temptask = iterator.next();

                if(temptask.getTaskName().equals(name) || temptask.getDescription().equals(description)){
                    return temptask;
                }
            }
        }
        System.out.println("Tarea no encontrada o nombre o descripcion no coinciden con ninguna tarea.");
        return null;
    }

    public static void markAsCompleted(String name){
        for(int i = 0; i < 25; i++){

            //iterador de la cola de prioridad de cada indice de array de 25 xd
            Iterator<Task> iterator = arrayOfPriorityQueue.get(i).iterator();

            while(iterator.hasNext()){
                Task task = iterator.next();

                if(task.getTaskName().equals(name)){
                    task.setStatus(true);
                }    
            }
        }
        System.out.println("Tarea(s) marcadas como completada");
    }

    public static LinkedList<Task> returnDoublyCircularList(){

        LinkedList<Task> lista = new LinkedList<>();

        for(int i = 0; i < 25; i++){
            Iterator<Task> iterator = arrayOfPriorityQueue.get(i).iterator();
            while(iterator.hasNext()){
                Task task = iterator.next();
                lista.add(task);
            }
            ToIntFunction<Task> comparator = (Task a) -> a.getPriority();
            lista.sort(comparator);
        }
        System.out.println(lista.toString()); 
        return lista;
    }

    public static void changeTaskPriority(String taskName, int newPriority, TaskCategory newCategory) {
        Task taskita = searchTask(taskName, "");

        Array<PriorityQueue<Task>> newArrayOfPriorityQueue = new Array<>(25);

        // Copiar las colas de prioridad originales a la nueva matriz
        for (int i = 0; i < 25; i++) {
            newArrayOfPriorityQueue.add(new PriorityQueue<>(2));
            Iterator<Task> iterator = arrayOfPriorityQueue.get(i).iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (!task.equals(taskita)) {
                    newArrayOfPriorityQueue.get(i).insert(task);
                }
            }
        }

        taskita.setPriority(newPriority);
        taskita.setTaskCategory(newCategory);

        addTask(taskita);
        arrayOfPriorityQueue = newArrayOfPriorityQueue;
    }

    public static void main(String[] args) {

        TaskManager pepe = new TaskManager();

        Task tarea1 = new Task("correr", 25, "tengo que correr",TaskCategory.REQUIREMENT);
        Task tarea2 = new Task("Estudiar", 1, "tengo que estudiar",TaskCategory.TESTING);
        Task tarea3 = new Task("Estudiar requerimiento", 1, "tengo que estudiar Requerimientos",TaskCategory.REQUIREMENT);
        Task tarea4 = new Task("nada", 10, "tengo que hacer nada",TaskCategory.TESTING);
        pepe.addTask(tarea3);
        pepe.addTask(tarea2);
        pepe.addTask(tarea1);
        pepe.addTask(tarea4);
        showAllTasks();

        pepe.searchTask("correr", "tengo que correr");

        pepe.markAsCompleted("correr");

        System.out.println("--------------------");
        showTasks();

        pepe.returnDoublyCircularList();
    }
}

