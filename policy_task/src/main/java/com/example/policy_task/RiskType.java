package com.example.policy_task;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum RiskType {
    FIRE {
        final BigDecimal over = BigDecimal.valueOf(100);
        int res;

        @Override
        public BigDecimal checkCoefficient(BigDecimal sumInsured) {
            res = sumInsured.compareTo(over);
            if (res == 1) {
                coefficient = BigDecimal.valueOf(0.024);
            } else {
                coefficient = BigDecimal.valueOf(0.014);
            }
            return getPremiumForOneSubObject(coefficient, sumInsured);
        }
    }, THEFT {
        private final BigDecimal equalOrOver = BigDecimal.valueOf(15);
        int res;

        @Override
        public BigDecimal checkCoefficient(BigDecimal sumInsured) {
            res = sumInsured.compareTo(equalOrOver);
            if (res == 1 || res == 0) {
                coefficient = BigDecimal.valueOf(0.05);
            } else {
                coefficient = BigDecimal.valueOf(0.11);
            }
            return getPremiumForOneSubObject(coefficient, sumInsured);
        }
    };

    BigDecimal coefficient;

    RiskType() {

    }

    public abstract BigDecimal checkCoefficient(BigDecimal sumInsured);

    BigDecimal getPremiumForOneSubObject(BigDecimal coefficient, BigDecimal sumInsured) {
        BigDecimal res = sumInsured.multiply(coefficient);
        return res.setScale(2, RoundingMode.HALF_UP);
    }
}
