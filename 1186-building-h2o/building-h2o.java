class H2O {
    int hcount = 0;
    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (hcount == 2){
            wait();
        }
        releaseHydrogen.run();
        hcount++;
        notifyAll();
    }
    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (hcount < 2){
            wait();
        }
        releaseOxygen.run();
        hcount = 0;
        notifyAll();
    }
}