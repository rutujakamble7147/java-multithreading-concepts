public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is running");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        new Thread(()-> System.out.println("Thread2 is running ...")).start();
    }
}