package com.abndev.asan.gkb.dom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegAddresses {
    private List<RegAddress> addresses;

    public RegAddresses() {
    }

    public List<RegAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<RegAddress> addresses) {
        this.addresses = addresses;
    }
}
