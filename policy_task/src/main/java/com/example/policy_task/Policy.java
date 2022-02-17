package com.example.policy_task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Policy {
    private final String number;
    private final Status status;
    private final List<PolicyObject> listOfPolicyObjects;
    private final BigDecimal premium;

    public Policy(final String number, final Status status, final List<PolicyObject> policyObjects) {
        this.number = number;
        this.status = status;
        this.listOfPolicyObjects = List.copyOf(policyObjects);
        this.premium = calculatePolicyPremiumFull();
    }

    public BigDecimal getPremium() {
        return premium;
    }

    private BigDecimal calculatePolicyPremiumFull() {
        List<BigDecimal> listOfObjectPremiumsForEachSubObject = new ArrayList<>();
        for (PolicyObject object : listOfPolicyObjects) {
            BigDecimal res = object.getObjectsPremium();
            listOfObjectPremiumsForEachSubObject.add(res);
        }
        return listOfObjectPremiumsForEachSubObject.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

