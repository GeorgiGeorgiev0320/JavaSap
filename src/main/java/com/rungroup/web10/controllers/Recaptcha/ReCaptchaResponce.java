package com.rungroup.web10.controllers.Recaptcha;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

public class ReCaptchaResponce {

    private boolean success;
    private String hostname;
    private String challenge_ts;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getChallenge_ts() {
        return challenge_ts;
    }

    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public String[] getErrprCodes() {
        return errprCodes;
    }

    public void setErrprCodes(String[] errprCodes) {
        this.errprCodes = errprCodes;
    }

    @JsonProperty("error-codes")
    private String[] errprCodes;
}
