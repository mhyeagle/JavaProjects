package TT;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestQueue {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public void getNode() throws InterruptedException {
        lock.lock();
        try {
            // return node
            notEmpty.await();
        } finally {
            notFull.signal();
            lock.unlock();
        }
    }

    public void putNode() throws InterruptedException {
        lock.lock();
        try {
            // put node
            notFull.await();
        } finally {
            notEmpty.signal();
            lock.unlock();
        }
    }
}
