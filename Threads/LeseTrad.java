package Threads;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class LeseTrad extends Thread {
    private String filnavn;
    private Monitor1 monitor;

    public LeseTrad(String filnavn, Monitor1 monitor) {
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    public void run() {
        try {
            monitor.leggTil(monitor.lesImmunrepertoarFraFil(filnavn));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
