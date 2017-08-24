package com.hxs.sms;

public class AuthInfo {

    private String memberId;

    public AuthInfo(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
