package com.example.policy_task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolicyObject {
    private final String objectName;
    private final List<PolicySubObject> policySubObjects;
    private final BigDecimal objectsPremium;

    public PolicyObject(final String objName, final List<PolicySubObject> policySubObjects) {
        this.objectName = objName;
        this.policySubObjects = List.copyOf(policySubObjects);
        this.objectsPremium = calculateOneObjectsPremiumFull();
    }

    public BigDecimal getObjectsPremium() {
        return objectsPremium;
    }

    private BigDecimal calculateOneObjectsPremiumFull() {
        List<BigDecimal> listOfSubObjectsPremiums = new ArrayList<>();
        for (PolicySubObject subObject : policySubObjects) {
            BigDecimal res = subObject.getSubObjectsPremium();
            listOfSubObjectsPremiums.add(res);
        }
        return listOfSubObjectsPremiums.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
