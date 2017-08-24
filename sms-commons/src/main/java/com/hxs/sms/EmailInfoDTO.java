package com.hxs.sms;

import com.hxs.sms.model.BaseModel;

import java.util.Date;


public class EmailInfoDTO extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String sendCode;


    /**
     * 邮件人
     */
    private String[] sendTo;

    /**
     * 邮件人
     */
    private String sendToStr;

    /**
     * 抄送
     */
    private String[] toCc;

    /**
     * 抄送人
     */
    private String toCcStr;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 更新日期
     */
    private Date updateDate;

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the sendTo
     */
    public String[] getSendTo() {
        return sendTo;
    }

    /**
     * @param sendTo the sendTo to set
     */
    public void setSendTo(String[] sendTo) {
        this.sendTo = sendTo;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getSendToStr() {
        if (sendToStr == null) {
            if (sendTo != null) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < sendTo.length; i++) {
                    sb.append(sendTo[i]);
                    if (i < sendTo.length - 1) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return "";
            }
        } else {
            return this.sendToStr;
        }
    }

    public void setSendToStr(String sendToStr) {
        this.sendToStr = sendToStr;
    }

    /**
     * @return the toCc
     */
    public String[] getToCc() {
        return toCc;
    }

    /**
     * @param toCc the toCc to set
     */
    public void setToCc(String[] toCc) {
        this.toCc = toCc;
    }

    /**
     * @return the toCcStr
     */
    public String getToCcStr() {
        if (toCcStr == null) {
            if (toCc != null) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < toCc.length; i++) {
                    sb.append(toCc[i]);
                    if (i < toCc.length - 1) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return "";
            }

        } else {
            return this.toCcStr;
        }
    }

    /**
     * @param toCcStr the toCcStr to set
     */
    public void setToCcStr(String toCcStr) {
        this.toCcStr = toCcStr;
    }


}

