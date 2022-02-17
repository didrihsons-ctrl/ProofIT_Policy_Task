package com.example.policy_task;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyObjectTest {

    PolicyObject house;

    PolicySubObject tvFire = new PolicySubObject("A TV", 100, RiskType.FIRE);
    PolicySubObject ps5Fire = new PolicySubObject("A PS5", 100.1, RiskType.FIRE);
    PolicySubObject carFire = new PolicySubObject("A car", 99.9, RiskType.FIRE);

    PolicySubObject tvTheft = new PolicySubObject("A TV", 15, RiskType.THEFT);
    PolicySubObject ps5Theft = new PolicySubObject("A PS5", 15.1, RiskType.THEFT);
    PolicySubObject carTheft = new PolicySubObject("A car", 14.99, RiskType.THEFT);

    @Test
    void testOneSubObject() {
        house = new PolicyObject("A House", List.of(tvFire));
        assertEquals(new BigDecimal("1.40"), house.getObjectsPremium());

        house = new PolicyObject("A House", List.of(tvTheft));
        assertEquals(new BigDecimal("0.75"), house.getObjectsPremium());
    }

    @Test
    void testNoSubObject() {
        house = new PolicyObject("A House", List.of());
        assertEquals(new BigDecimal("0"), house.getObjectsPremium());
    }

    @Test
    void testMultipleSubObject() {
        house = new PolicyObject("A House", List.of(ps5Fire, carFire));
        assertEquals(new BigDecimal("3.80"), house.getObjectsPremium());

        house = new PolicyObject("A House", List.of(ps5Theft, carTheft));
        assertEquals(new BigDecimal("2.40"), house.getObjectsPremium());
    }
}