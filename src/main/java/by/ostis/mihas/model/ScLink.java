package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.ScString;
import model.scparametr.scelementtype.ScLinkType;

public class ScLink extends ScElement {
    private ScString content;

    public ScLink(ScAddress scAddress, ScString content) {
        super(scAddress, new ScLinkType());
        this.content=content;
    }


    @Override
    public ScString get() {
        return content;
    }
}
