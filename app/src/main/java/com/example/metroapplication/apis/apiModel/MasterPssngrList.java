package com.example.metroapplication.apis.apiModel;

public class MasterPssngrList {

    int id;
            int paxTypeId;
            String paxType;
            String desc;
            String criteria;
            String docReq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaxTypeId() {
        return paxTypeId;
    }

    public void setPaxTypeId(int paxTypeId) {
        this.paxTypeId = paxTypeId;
    }

    public String getPaxType() {
        return paxType;
    }

    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getDocReq() {
        return docReq;
    }

    public void setDocReq(String docReq) {
        this.docReq = docReq;
    }
}
