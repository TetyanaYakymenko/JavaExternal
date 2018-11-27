package ua.com.threads.synchronize;

import  ua.com.threads.lock.Ship;
//import ua.com.threads.collection.Ship;

public class Demo {
    public static void main(String [] args){
        Port port = new Port("First Port",3);

        Thread ship1 = new Thread(new Ship("Tutanic", 10, port));
        Thread ship2 = new Thread(new Ship("Shippp", 5, port));
        Thread ship3 = new Thread(new Ship("Kiev", 5, port));

        ship1.start();
        ship2.start();
        ship3.start();
    }
}
