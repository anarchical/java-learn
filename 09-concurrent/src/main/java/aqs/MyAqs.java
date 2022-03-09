package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author YeYaqiao
 */
public class MyAqs {

    public static void main(String[] args) {

        MyLock myLock = new MyLock();

        new Thread(() -> {
            myLock.lock();
            System.out.println(Thread.currentThread().getName() + " locking");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " unlocking");
            myLock.unlock();

        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.lock();
            System.out.println(Thread.currentThread().getName() + " locking");
            System.out.println(Thread.currentThread().getName() + " unlocking");
            myLock.unlock();

        }, "t2").start();
    }
}

class MyLock implements Lock {

    class MySync extends AbstractQueuedSynchronizer {

        //尝试加锁
        @Override
        protected boolean tryAcquire(int arg) {
            //尝试更改标记 state，用CAS的方法
            if (compareAndSetState(0, arg)) {
                //加锁成功
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(arg);
            return true;
        }

        //是否为独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }

    }

    private MySync sync = new MySync();

    //加锁
    @Override
    public void lock() {
        sync.acquire(1);
    }

    //加可打断的锁
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

    }

    //尝试加锁，只尝试一次
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    //尝试加锁，带超时时间
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    //解锁
    @Override
    public void unlock() {
        sync.release(0);
    }

    //条件
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
