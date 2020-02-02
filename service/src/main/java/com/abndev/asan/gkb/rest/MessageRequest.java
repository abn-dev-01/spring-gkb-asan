package com.abndev.asan.gkb.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageRequest {
    private String inn;
    private boolean consentConfirmed;

    public MessageRequest() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageRequest{");
        sb.append("inn='").append(inn).append('\'');
        sb.append(", consentConfirmed=").append(consentConfirmed);
        sb.append('}');
        return sb.toString();
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public boolean isConsentConfirmed() {
        return consentConfirmed;
    }

    public void setConsentConfirmed(boolean consentConfirmed) {
        this.consentConfirmed = consentConfirmed;
    }
}
