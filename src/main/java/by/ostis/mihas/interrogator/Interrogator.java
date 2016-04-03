package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.ScRequest;
import by.ostis.mihas.screquest.exception.ScRequestException;

import java.io.IOException;

public interface Interrogator {
    public<T> T execute(ScRequest<T> scRequest) throws IOException, ScRequestException;
    void close() throws IOException;
}
