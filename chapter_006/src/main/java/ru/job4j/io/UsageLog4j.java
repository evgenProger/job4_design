package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args) {
        byte b = 24;
        short s = 30254;
        int i = 1256321;
        long l = 1235487432;
        float f = 35.254f;
        double d =  896.547d;
        char ch = 'H';
        boolean bool = false;
        LOG.debug("This is byte type: {}", b);
        LOG.debug("This is short type: {}", s);
        LOG.debug("This is int type: {}", i);
        LOG.debug("This is long type: {}", l);
        LOG.debug("This is float type: {}", f);
        LOG.debug("This is double type: {}", d);
        LOG.debug("This is char type: {}", ch);
        LOG.debug("This is boolean type: {}", bool);

    }
}
