package by.ostis.mihas.screquest.usuallrequest;

import by.ostis.mihas.screquest.exception.ScRequestException;
import client.AdvancedSctpClient;
import client.ConsSctpClient;

import java.io.IOException;

public interface ScRequest<T> {
    public T execute(AdvancedSctpClient sctpClient) throws IOException, ScRequestException;
}
