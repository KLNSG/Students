package domain;


import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;
import util.SerializeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache implements Cache {
    private static Jedis jedis =new Jedis();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private final String id;

    public MyCache(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
           Lock lock=readWriteLock.writeLock();
           try{
               lock.lock();
               jedis.set(SerializeUtil.serialize(o),SerializeUtil.serialize(o1));
           }finally {
               lock.unlock();
           }
    }

    @Override
    public Object getObject(Object o) {
        return SerializeUtil.deserizlize(jedis.get(SerializeUtil.serialize(o)));
    }

    @Override
    public Object removeObject(Object o) {
        return jedis.expire(SerializeUtil.serialize(o),0);
    }

    @Override
    public void clear() {
      jedis.flushAll();
    }

    @Override
    public int getSize() {
        return jedis.dbSize().intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
