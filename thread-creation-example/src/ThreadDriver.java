
class NumberPrinter{
    void print() throws InterruptedException {

        for (int i = 10; i <=10 ; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +" " + i);

        }
    }
}
    class ThreadExample extends Thread{
    NumberPrinter numberPrinter;

         ThreadExample(NumberPrinter numberPrinter) {
            this.numberPrinter = numberPrinter;
        }

        @Override
        public void run() {
            System.out.println(" name " +Thread.currentThread().getName());
            try {
                this.numberPrinter.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

public class ThreadDriver {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        ThreadExample Thread1 = new ThreadExample(numberPrinter);
        Thread1.setName("Thread 1");
        Thread1.setPriority(Thread.MAX_PRIORITY);
        Thread1.start();

        ThreadExample Thread2 = new ThreadExample(numberPrinter);
        Thread2.setName("Thread 2");
        Thread2.setPriority(Thread.NORM_PRIORITY);
        Thread2.start();

        ThreadExample Thread3 = new ThreadExample(numberPrinter);
        Thread3.setName("Thread 3");
        Thread3.setPriority(Thread.MIN_PRIORITY);
        Thread3.start();

        ThreadExample Thread4 = new ThreadExample(numberPrinter);
        Thread4.setName("Thread 4");
        Thread4.start();

        System.out.println("Main thread terminated .");


    }
}
