package com.codehunter;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author codehunter
 */
public class BrokerServer {
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();

        TransportConnector connector = new TransportConnector();
        connector.setUri(new URI("tcp://localhost:61616"));
        broker.addConnector(connector);
        broker.setPersistent(false);
        broker.setUseJmx(true);
        broker.start();
        // now lets wait forever to avoid the JVM terminating immediately
        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }
}
