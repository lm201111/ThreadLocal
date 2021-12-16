package thread;

import customers.User;
import customers.UserData;

/*
* Класс, реализующий имитацию деятельности пользователя.
* */
public class UserSession implements Runnable {
    private MyThreadLocal<User> thlUser = new MyThreadLocal();
    private MyThreadLocal<String> thlThreadInfo = new MyThreadLocal();
    private MyThreadLocal<Long> thlCounter = new MyThreadLocal();

    // Id пользователя, который "открывает сессию".
    private int userId;
    private UserData repo = new UserData();
    private long operations;

    public UserSession(int userId, long operations) {
        this.userId = userId;
        this.operations = operations;
    }

    @Override
    public void run() {
        User user = repo.getUser(userId);

        thlUser.put(user);
        thlThreadInfo.put("Идентификатор процесса(pid) " + Thread.currentThread().getId() + "; \\n Поток: " + Thread.currentThread().getName());
        thlCounter.put((long) 1);

        while (thlCounter.get() < operations) {
            thlCounter.put(thlCounter.get() + 1);
        }

        System.out.println(userId + " — Пользователь : " + thlUser.get().toString());
        System.out.println(userId + " — Информация о потоке : " + thlThreadInfo.get());
        System.out.println(userId + " — Номер операции : " + thlCounter.get());
    }
}
