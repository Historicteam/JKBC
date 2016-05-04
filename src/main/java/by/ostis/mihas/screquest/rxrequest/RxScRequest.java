package by.ostis.mihas.screquest.rxrequest;

import client.ConsSctpClient;
import rx.Observable;
import rx.Subscriber;

public abstract class RxScRequest<T> {


    public Observable<T> execute(ConsSctpClient sctpClient) {
        Observable<T> myObservable = Observable.create(
            new Observable.OnSubscribe<T>() {
                @Override
                public void call(Subscriber<? super T> sub) {
                    executor(sctpClient, sub);
                }
            }
        );
        return myObservable;
    }

    abstract public void executor(ConsSctpClient sctpClient, Subscriber<? super T> sub);
}
