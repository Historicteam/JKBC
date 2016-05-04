package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.rxrequest.RxScRequest;
import by.ostis.mihas.screquest.usuallrequest.ScRequest;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.ConsSctpClient;
import rx.Observable;

import java.io.IOException;

public class InterrogatorImpl implements Interrogator {
    private ConsSctpClient sctpClient;

    protected InterrogatorImpl(ConsSctpClient sctpClient) {
        this.sctpClient = sctpClient;
    }

    public <T> T execute(ScRequest<T> scRequest) throws IOException, ScRequestException {
        T answer = scRequest.execute(sctpClient);
        return answer;
    }

    @Override
    public <T> Observable<T> execute(RxScRequest<T> scRequest) {
        return scRequest.execute(sctpClient);

    }

    public void close() throws IOException {
        sctpClient.close();
    }
}
