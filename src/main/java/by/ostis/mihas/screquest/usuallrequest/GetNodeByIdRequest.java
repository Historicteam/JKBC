package by.ostis.mihas.screquest.usuallrequest;

import by.ostis.mihas.model.ScNode;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.AdvancedSctpClient;
import client.ConsSctpClient;
import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.SctpCodeReturn;
import model.scparametr.scelementtype.ScElementType;
import model.scresponce.SctpResponse;
import model.stcprequest.GetElementByIdSctpRequest;
import model.stcprequest.GetElementTypeStcpRequest;
import model.stcprequest.SctpRequest;

import java.io.IOException;

public class GetNodeByIdRequest implements ScRequest<ScNode> {
    private String id;

    public GetNodeByIdRequest(String id) {
        this.id = id;
    }

    public ScNode execute(AdvancedSctpClient sctpClient) throws IOException, ScRequestException {
        ScString scStringId =  new ScString(id);
        SctpRequest getElementByIdSctpRequest = new GetElementByIdSctpRequest(scStringId);
        SctpResponse sctpResponse = sctpClient.perform(getElementByIdSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        ScAddress scAddressNode = (ScAddress) sctpResponse.getParametr(0);
        GetElementTypeStcpRequest getElementTypeStcpRequest = new GetElementTypeStcpRequest(scAddressNode);
        sctpResponse = sctpClient.perform(getElementTypeStcpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        ScElementType scElementTypeNode = (ScElementType) sctpResponse.getParametr(0);
        return new ScNode(scAddressNode,scElementTypeNode,scStringId);
    }
}
