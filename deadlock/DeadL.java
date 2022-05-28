public class DeadL {


    public static void main(String args[]) {

        final String res1 = "Eins";
        final String res2 = "Zwei";

        Thread thread1 = new Thread() {
            public void run() {
                synchronized (res1) {
                    System.out.println("Thread 1: Res1 blockieren");
                    try {
                        Thread.sleep(10000);
                    } catch (Exception ex) {
                    }
                }
                synchronized (res2) {
                    System.out.println("Thread 1: Res2 blockieren");
                }
            }

        };


        Thread thread2 = new Thread() {
            public void run() {

                synchronized (res2) {
                    System.out.println("Thread 2: Res2 blockieren");
                    try {
                        Thread.sleep(5000);
                        System.out.println("Warten...");
                    } catch (Exception ex) {
                    }
                }
                synchronized (res1) {
                    System.out.println("Thread 2: Res1 blockieren");
                }
            }
        };


        thread1.start();
        thread2.start();

    }
}
