package com.example.policy_task;

import java.math.BigDecimal;

public class PolicySubObject {
    private final String subObjectName;
    private final double sumInsured;
    private final RiskType riskType;
    private final BigDecimal subObjectsPremium;

    public PolicySubObject(String subObjectName, double sumInsured, RiskType riskType) {
        this.subObjectName = subObjectName;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
        this.subObjectsPremium = calculateSubObjectsPremium();

    }

    public double getSumInsured() {
        return sumInsured;
    }

    public BigDecimal getSubObjectsPremium() {
        return subObjectsPremium;
    }

    private BigDecimal calculateSubObjectsPremium() {
        BigDecimal sumInsured = new BigDecimal(getSumInsured());
        return riskType.checkCoefficient(sumInsured);
    }
}