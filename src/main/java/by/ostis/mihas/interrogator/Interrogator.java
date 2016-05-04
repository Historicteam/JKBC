package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.rxrequest.RxScRequest;
import by.ostis.mihas.screquest.usuallrequest.ScRequest;
import by.ostis.mihas.screquest.exception.ScRequestException;
import rx.Observable;

import java.io.IOException;

public interface Interrogator {
    public<T> T execute(ScRequest<T> scRequest) throws IOException, ScRequestException;
    public<T> Observable<T> execute(RxScRequest<T> scRequest);
    void close() throws IOException;
}
