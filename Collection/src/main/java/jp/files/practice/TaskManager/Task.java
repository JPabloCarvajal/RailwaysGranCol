package jp.files.practice.TaskManager;

public class Task {

    private String name;
    private int priority;
    private boolean status;

    public Task(String name,int priority){
        this.name = name;
        this.status = false;
        this.priority = priority;
    }

    public Task(){
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void toStringg(){
        System.out.println("Name: "+ name +" Priority: "+priority+" Status: "+status);
    }
}