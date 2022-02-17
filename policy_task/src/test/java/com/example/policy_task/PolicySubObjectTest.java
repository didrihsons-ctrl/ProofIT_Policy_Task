package com.example.policy_task;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicySubObjectTest {
    PolicySubObject tvFire = new PolicySubObject("A TV", 100, RiskType.FIRE);
    PolicySubObject ps5Fire = new PolicySubObject("A PS5", 100.1, RiskType.FIRE);
    PolicySubObject carFire = new PolicySubObject("A car", 99.9, RiskType.FIRE);

    PolicySubObject tvTheft = new PolicySubObject("A TV", 15, RiskType.THEFT);
    PolicySubObject ps5Theft = new PolicySubObject("A PS5", 15.1, RiskType.THEFT);
    PolicySubObject carTheft = new PolicySubObject("A car", 14.99, RiskType.THEFT);

    @Test
    void fireSumInsuredOver() {
        assertEquals(new BigDecimal("2.40"), ps5Fire.getSubObjectsPremium());
    }

    @Test
    void fireSumInsuredEqual() {
        assertEquals(new BigDecimal("1.40"), tvFire.getSubObjectsPremium());
    }

    @Test
    void fireSumInsuredUnder() {
        assertEquals(new BigDecimal("1.40"), carFire.getSubObjectsPremium());
    }

    @Test
    void theftSumInsuredOver() {
        assertEquals(new BigDecimal("0.75"), ps5Theft.getSubObjectsPremium());
    }

    @Test
    void theftSumInsuredEqual() {
        assertEquals(new BigDecimal("0.75"), tvTheft.getSubObjectsPremium());
    }

    @Test
    void theftSumInsuredUnder() {
        assertEquals(new BigDecimal("1.65"), carTheft.getSubObjectsPremium());
    }
}