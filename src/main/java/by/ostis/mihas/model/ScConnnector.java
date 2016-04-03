package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.scelementtype.ScElementType;

public class ScConnnector extends ScElement {

    private ScElementType scElementType;
    private ScElement firstNeighbor;
    private ScElement secondNeighbor;

    public ScConnnector(ScAddress scAddress, ScElementType scElementType, ScElement firstNeighbor, ScElement
            secondNeighbor) {
        super(scAddress);
        this.scElementType = scElementType;
        this.firstNeighbor = firstNeighbor;
        this.secondNeighbor = secondNeighbor;
    }
}
