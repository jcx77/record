package com.framework.api.account.vo;

import com.framework.commons.vo.ui.PageRequest;

public class AcParam extends PageRequest {
    private String name;
    private String billId;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
