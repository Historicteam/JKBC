package by.ostis.mihas.model;

import model.scparametr.ScAddress;
import model.scparametr.ScString;

public class ScLink extends ScElement {
    private ScString content;

    public ScLink(ScAddress scAddress,  ScString content) {
        super(scAddress);
        this.content = content;
    }
}
