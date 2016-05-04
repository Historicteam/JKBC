package by.ostis.mihas.screquest.usuallrequest;

import by.ostis.mihas.model.ScNode;
import by.ostis.mihas.screquest.exception.IdBusyException;
import by.ostis.mihas.screquest.exception.ScRequestException;
import client.ConsSctpClient;
import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.SctpCodeReturn;
import model.scparametr.scelementtype.ScNodeType;
import model.scresponce.SctpResponse;
import model.stcprequest.CreateNodeSctpRequest;
import model.stcprequest.GetElementByIdSctpRequest;
import model.stcprequest.SctpRequest;
import model.stcprequest.SetIdentifierSctpRequest;

import java.io.IOException;

public class MakeNodeScRequest implements ScRequest<ScNode> {
    private String idtf;
    private ScNodeType scNodeType;

    public MakeNodeScRequest(String idtf, ScNodeType scNodeType) {
        this.idtf = idtf;
        this.scNodeType = scNodeType;
    }

    public ScNode execute(ConsSctpClient sctpClient) throws IOException, ScRequestException {
        SctpRequest getElementByIdSctpRequest = new GetElementByIdSctpRequest(new ScString(idtf));
        SctpResponse sctpResponse = sctpClient.perform(getElementByIdSctpRequest);
        if (sctpResponse.getSctpCodeReturn()== SctpCodeReturn.SUCCESSFUL){
            throw new IdBusyException("Element with system id "+idtf+" already exists");
        }
        CreateNodeSctpRequest createNodeSctpRequest = new CreateNodeSctpRequest(scNodeType);
        sctpResponse = sctpClient.perform(createNodeSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        ScAddress scAddressNode = (ScAddress) sctpResponse.getParametr(0);
        ScString scString = new ScString(idtf);
        SctpRequest setIdentifierSctpRequest = new SetIdentifierSctpRequest(scAddressNode, scString);
        sctpResponse = sctpClient.perform(setIdentifierSctpRequest);
        if (sctpResponse.getSctpCodeReturn()!= SctpCodeReturn.SUCCESSFUL){
            throw new ScRequestException();
        }
        return new ScNode(scAddressNode, scString, scNodeType);
    }
}
