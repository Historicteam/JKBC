package by.ostis.mihas.interrogator;

import client.ConsSctpClientImpl;

import java.io.IOException;

public class InterrogatorBuilder {
    public static Interrogator getInstance(String host, int port) throws IOException {
        return new InterrogatorImpl(new ConsSctpClientImpl(host,port));
    }
}
