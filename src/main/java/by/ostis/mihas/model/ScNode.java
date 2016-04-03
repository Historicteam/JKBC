package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.scelementtype.ScElementType;

public class ScNode extends ScElement {
    private ScString systemIdtf;
    private ScElementType scElementType;

    public ScNode(ScAddress scAddress, ScString systemIdtf, ScElementType scElementType) {
        super(scAddress);
        this.systemIdtf = systemIdtf;
        this.scElementType = scElementType;
    }
}
