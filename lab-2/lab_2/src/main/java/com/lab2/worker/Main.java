package com.lab2.worker;

/**
 * Main.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Input point of program.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        WorkerImpl worker = new WorkerImpl();
        worker.run();
    }
}
