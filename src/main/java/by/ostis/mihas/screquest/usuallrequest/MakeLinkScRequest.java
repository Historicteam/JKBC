package by.ostis.mihas.screquest.usuallrequest;

import by.ostis.mihas.model.ScLink;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.AdvancedSctpClient;
import client.ConsSctpClient;
import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.SctpCodeReturn;
import model.scresponce.SctpResponse;
import model.stcprequest.CreateLinkSctpRequest;
import model.stcprequest.SetLinkContentSctpRequest;

import java.io.IOException;

public class MakeLinkScRequest implements ScRequest<ScLink> {
    private String conntent;

    public MakeLinkScRequest(String conntent) {
        this.conntent = conntent;
    }

    public ScLink execute(AdvancedSctpClient sctpClient) throws IOException, ScRequestException {
        CreateLinkSctpRequest createLinkSctpRequest = new CreateLinkSctpRequest();
        SctpResponse sctpResponse = sctpClient.perform(createLinkSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        ScAddress linkScAdress = (ScAddress) sctpResponse.getParametr(0);
        ScString linkConntent = new ScString(conntent);
        SetLinkContentSctpRequest setLinkContentSctpRequest = new SetLinkContentSctpRequest(linkScAdress, linkConntent);
        sctpResponse = sctpClient.perform(setLinkContentSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        return new ScLink(linkScAdress, linkConntent);
    }
}
