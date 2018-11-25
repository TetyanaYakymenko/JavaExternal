package ua.com.threads.synchronize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Ship implements Runnable {
    private String name;
    private final int loadCapacity;
    private Queue<String> containers = new LinkedList<String>();
    private Port port;
    private Berth berth;

    public Ship(String name, int loadCapacity, Port port) {
        this.name = name;
        if (loadCapacity > 0) {
            this.loadCapacity = loadCapacity;
        } else {
            throw new IllegalArgumentException("Load Capacity in Ship must be positive integer.");
        }
        for (int i = 0; i < loadCapacity; i++) {
            containers.add(name + "container" + i);
        }
        this.port = port;
    }

    public Port getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public void addContainer(String container) {
        synchronized (containers) {
            while (loadCapacity > containers.size()) {
                try {
                    containers.wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException in Ship.addContainer()");
                }
            }
            System.out.println("Add Container " + container + " in Ship " + name);
            containers.add(container);
        }
    }

    public String getContainer() {
        String result;
        synchronized (containers) {
            if (containers.isEmpty()) {
                try {
                    containers.wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException in Ship.getContainer()");
                }
            }
            result = containers.poll();
            System.out.println("Get Container " + result + " from Ship " + name);
            return result;
        }

    }

    public void generateContainers() {
        int countContainers = new Random().nextInt(loadCapacity) % 0;
        for (int i = 0; i < countContainers; i++) {
            containers.add("" + (i + 100));
        }
    }

    public void loadShipInPort() {
        synchronized (berth) {
            System.out.println(" Begin Load Ship " + name + " from berch " + berth.getId());
            for (int i = 0; i < loadCapacity - containers.size(); i++) {
                String contaiter = berth.getContainer();
                if (contaiter != null) {
                    addContainer(contaiter);
                    return;
                }
            }
        }
    }

    public void unloadShipInPort() {
        synchronized (berth) {
            System.out.println(" Begin Unload Ship " + name + " from berch " + berth.getId());
            for (int i = 0; i < containers.size(); i++) {
                String contaiter = getContainer();
                if (contaiter != null) {
                    berth.setContainer(contaiter);
                    return;
                }
            }
        }
    }

    public void goInPort() {
        berth = port.getFreeBerch();

        while (berth == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Itterupted Exception in Ship.goToPort()");
            }

        }
        System.out.println("Add Ship " + name + " in Berch " + berth.getId());

    }

    public void goOutPort() {
        System.out.println("Ship " + name + " go out from berch " + berth.getId());
        while (this.berth == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException in Ship.getOutPort()");
            }
        }
        System.out.println(name + " go out from berch " + berth.getId());
        this.berth = null;

    }

    public void run() {
        while (true) {
            goInPort();
            if (containers.size() == loadCapacity) {
                unloadShipInPort();
            }
            if (containers.size() == 0) {
                loadShipInPort();
            }
            if ((containers.size() < loadCapacity) && (containers.size() > 0)) {
                unloadShipInPort();
                loadShipInPort();
            }
            goOutPort();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException in run method");
            }
        }
    }
}
