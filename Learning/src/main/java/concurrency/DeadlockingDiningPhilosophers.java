package concurrency;
import java.util.concurrent.*;

public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        ChopStick[] sticks = new ChopStick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new ChopStick();
        for (int i = 0; i < size; i++)
            exec.execute(new Philosopher(sticks[i],
                    sticks[(i+1) % size], i, ponder));
        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
