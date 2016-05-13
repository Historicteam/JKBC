package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.scelementtype.ScElementType;

abstract public class ScElement {
    private ScAddress scAddress;
    private ScElementType scElementType;

    public ScElement(ScAddress scAddress, ScElementType scElementType) {
        this.scAddress = scAddress;
        this.scElementType = scElementType;
    }

    public ScAddress getScAddress() {
        return scAddress;
    }

    public ScElementType getScElementType() {
        return scElementType;
    }

    abstract public ScString get();
}
