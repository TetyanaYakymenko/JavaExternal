package ua.com.threads.synchronize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Berth {
    private int id;
    private int capacity;
    private boolean isFree ;
    private Queue<String> containers = new LinkedList<String>();

    public Berth(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public void setContainer(String container){
        if(containers.size()< capacity){
            containers.add(container);
        }
    }
    public String getContainer(){
        return containers.poll();
    }

    public void generateContainers(){
        Random generator = new Random();
        int length = generator.nextInt(30);
        for (int i = 0; i < length; i++) {
            containers.add(" " +generator.nextInt(500));
        }
    }
}
