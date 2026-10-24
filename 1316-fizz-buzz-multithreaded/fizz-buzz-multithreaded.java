class FizzBuzz {
    private int n;
    private volatile int i;
    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n){
            int currentI = i;
            if(currentI <= n && currentI%3 == 0 && currentI%5 != 0){
                printFizz.run();
                i++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
         while(i <= n){
            int currentI = i;
            if(currentI <= n && currentI%3 != 0 && currentI%5 == 0){
                printBuzz.run();
                i++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n){
            int currentI = i;
            if(currentI <= n && currentI%3 == 0 && currentI%5 == 0){
                printFizzBuzz.run();
                i++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            int currentI = i;
            if(currentI <= n && currentI%3 !=0  && currentI%5!=0){
                printNumber.accept(i);
                i++;
            }
        }
    }
}