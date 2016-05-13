package by.ostis.mihas.screquest.usuallrequest;

import by.ostis.mihas.model.ScLink;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.AdvancedSctpClient;
import client.ConsSctpClient;
import model.scparametr.ScAddress;
import model.scparametr.ScContentSize;
import model.scparametr.ScString;
import model.scparametr.SctpCodeReturn;
import model.scresponce.SctpResponse;
import model.stcprequest.GetLinksByContentSctpRequest;
import model.stcprequest.SctpRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetLinksByConntentRequest implements ScRequest<List<ScLink>> {
    private String conntent;

    public GetLinksByConntentRequest(String conntent) {
        this.conntent = conntent;
    }

    public List<ScLink> execute(AdvancedSctpClient sctpClient) throws IOException, ScRequestException {
        List<ScLink> listLinks = new ArrayList<ScLink>();
        ScString scStringLink = new ScString(conntent);
        SctpRequest getLinksByContentSctpRequest = new GetLinksByContentSctpRequest(scStringLink);
        SctpResponse sctpResponse = sctpClient.perform(getLinksByContentSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            if (sctpResponse.getSctpCodeReturn()== SctpCodeReturn.UNSUCCESSFULLY){
                return listLinks;
            }
            throw new ScRequestException();
        }
        ScContentSize scContentSize = (ScContentSize)sctpResponse.getParametr(0);
        int numberOfLinks = scContentSize.get();
        for (int i=1; i<numberOfLinks; i++){
            ScAddress scAddressLink = (ScAddress)sctpResponse.getParametr(i);
            listLinks.add(new ScLink(scAddressLink,scStringLink));
        }
        return listLinks;
    }
}
