package ua.com.threads.synchronize;

import ua.com.threads.synchronize.Berth;

public class Port {
    private String name;
    private int berhsNumber;
    private Berth[] berchs;

    public Port(String name, int berhsNumber) throws IllegalArgumentException {
        super();
        this.name = name;
        this.berhsNumber = berhsNumber;
        this.berchs = new Berth[berhsNumber];
        for (int i = 0; i < berchs.length; i++) {
            berchs[i] = new Berth(i, i);
        }
    }

    public Berth getFreeBerch() {
        for (int i = 0; i < berhsNumber; i++) {
            if (berchs[i].isFree()) {
                berchs[i].setFree(false);
                return berchs[i];
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
