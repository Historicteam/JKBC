package by.ostis.mihas.model;

import model.scparametr.ScAddress;

abstract public class ScElement {
    private ScAddress scAddress;

    public ScElement(ScAddress scAddress) {
        this.scAddress = scAddress;
    }
}
