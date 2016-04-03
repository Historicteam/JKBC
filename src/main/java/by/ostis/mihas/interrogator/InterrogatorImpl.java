package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.ScRequest;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.ConsSctpClient;

import java.io.IOException;

public class InterrogatorImpl implements Interrogator {
    private ConsSctpClient sctpClient;

    public InterrogatorImpl(ConsSctpClient sctpClient) {
        this.sctpClient = sctpClient;
    }

    public <T> T execute(ScRequest<T> scRequest) throws IOException, ScRequestException {
        T answer = scRequest.execute(sctpClient);
        return answer;
    }

    public void close() throws IOException {
        sctpClient.close();
    }
}
