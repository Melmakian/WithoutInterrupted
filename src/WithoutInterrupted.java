public class WithoutInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptedMethod();
    }

    public static void ourInterruptedMethod() {
        TestThread.cancel = true;
    }

    public static class TestThread implements Runnable {
        public static boolean cancel = false;

        @Override
        public void run() {
            while (!cancel) {
                try {
                    System.out.println("he - he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
