package by.ostis.mihas.screquest;

import by.ostis.mihas.screquest.exception.ScRequestException;
import client.ConsSctpClient;

import java.io.IOException;

public interface ScRequest<T> {
    public T execute(ConsSctpClient sctpClient) throws IOException, ScRequestException;
}
