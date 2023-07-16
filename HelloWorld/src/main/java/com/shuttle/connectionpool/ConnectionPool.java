package com.shuttle.connectionpool;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ConnectionPool {

    /** 连接池大小 */
    private final int poolSize;

    /** 连接池对象数组 */
    private final Connection[] connections;

    /** 连接状态数组 */
    private final AtomicIntegerArray connectionsStatus;

    private static final int FREE = 0;
    private static final int BUSY = 1;

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new Connection[poolSize];
        this.connectionsStatus = new AtomicIntegerArray(poolSize);
        for (int i = 0; i < poolSize; i++) {
//            connections[i] = new MockConnection();
        }
    }

    public Connection borrow() {
        while (true) {
            for (int i = 0; i < poolSize; i++) {
                if (connectionsStatus.get(i) == FREE) {
                    if (connectionsStatus.compareAndSet(i, FREE, BUSY)) {
                        return connections[i];
                    }
                }
            }
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean free(Connection connection) {
        for (int i = 0; i < poolSize; i++) {
            if (connections[i] == connection) {
                connectionsStatus.compareAndSet(i, BUSY, FREE);
                synchronized (this) {
                    this.notifyAll();
                }
                return true;
            }
        }

        return false;
    }


}

//class MockConnection implements Connection {
//
//}