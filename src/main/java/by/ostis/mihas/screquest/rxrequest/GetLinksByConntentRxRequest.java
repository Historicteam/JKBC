package by.ostis.mihas.screquest.rxrequest;

import by.ostis.mihas.model.ScLink;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.ConsSctpClient;
import model.scparametr.ScAddress;
import model.scparametr.ScContentSize;
import model.scparametr.ScString;
import model.scparametr.SctpCodeReturn;
import model.scresponce.SctpResponse;
import model.stcprequest.GetLinksByContentSctpRequest;
import model.stcprequest.SctpRequest;
import rx.Subscriber;

import java.io.IOException;

public class GetLinksByConntentRxRequest extends RxScRequest<ScLink> {
    private String conntent;

    public GetLinksByConntentRxRequest(String conntent) {
        this.conntent = conntent;
    }

    @Override
    public void executor(ConsSctpClient sctpClient, Subscriber<? super ScLink> sub) {
        ScString scStringLink = new ScString(conntent);
        SctpRequest getLinksByContentSctpRequest = new GetLinksByContentSctpRequest(scStringLink);
        SctpResponse sctpResponse = null;
        try {
            sctpResponse = sctpClient.perform(getLinksByContentSctpRequest);
        } catch (IOException e) {
            sub.onError(e);
            e.printStackTrace();
        }
        if (sctpResponse.getSctpCodeReturn() != SctpCodeReturn.SUCCESSFUL) {
            if (sctpResponse.getSctpCodeReturn() == SctpCodeReturn.UNSUCCESSFULLY) {
                sub.onCompleted();
            }
            sub.onError(new ScRequestException());
        }
        ScContentSize scContentSize = (ScContentSize) sctpResponse.getParametr(0);
        int numberOfLinks = scContentSize.get();
        for (int i = 1; i < numberOfLinks; i++) {
            ScAddress scAddressLink = (ScAddress) sctpResponse.getParametr(i);
            sub.onNext(new ScLink(scAddressLink, scStringLink));
        }
    }
}
