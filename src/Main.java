import thread.UserSession;
import thread.MyThread;


public class Main {
    /*
     * Реализация SharedMemory.
     * */
    private static void launchThread() throws Exception {
        UserSession user1 = new UserSession(1, 500000);
        UserSession user2 = new UserSession(2, 5000000);
        UserSession user3 = new UserSession(3, 100000);
        UserSession user4 = new UserSession(4, 40000000);

        MyThread thread1 = new MyThread(user1);
        MyThread thread2 = new MyThread(user2);
        MyThread thread3 = new MyThread(user3);
        MyThread thread4 = new MyThread(user4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }

    public static void main(String args[]) {
        try {
            System.out.println("Shared memory started");
            launchThread();
        } catch (Exception ex) {
            System.out.println("Ошибка");
        }
    }
}
