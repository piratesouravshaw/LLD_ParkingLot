package org.bnpl.model;

public class Gate extends BaseModel{
    private int gateNo;
    private Operator operator;// Present at the gate not the same as the operator for ticket
    // Operator for ticket can be other than the operator at the gate
    GateStatus status;
    private GateType gateType;

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
