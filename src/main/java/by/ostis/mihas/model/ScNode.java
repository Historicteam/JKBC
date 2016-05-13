package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.scelementtype.ScElementType;

public class ScNode extends ScElement {
    private ScString systemIdtf;

    public ScNode(ScAddress scAddress, ScElementType scElementType, ScString systemIdtf) {
        super(scAddress, scElementType);
        this.systemIdtf=systemIdtf;
    }


    @Override
    public ScString get() {
        return systemIdtf;
    }
}
