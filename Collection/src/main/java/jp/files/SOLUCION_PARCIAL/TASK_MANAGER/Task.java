package jp.files.SOLUCION_PARCIAL.TASK_MANAGER;

public class Task {
    private String taskName;//
    private int priority;//
    private boolean status;//
    private String description;//
    private TaskCategory taskCategory;//

    public Task(String taskName,int priority,String description,TaskCategory taskCategory){
        this.taskName = taskName;
        if (priority < 1 || priority > 25) {
            this.priority = 1;
        } else {
            this.priority = priority;
        }
        this.taskCategory = taskCategory;
        this.description = description;
        this.status = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public TaskCategory getTaskCategory(){
        return taskCategory;
    }

    public void toStringg(){
        System.out.println("Nombre: "+taskName+", Prioridad: "+ priority+ ", Status: "+status+", Descripcion: "+description+ ", Task category: "+taskCategory);
    }
}
