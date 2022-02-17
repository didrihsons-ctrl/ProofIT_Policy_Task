package com.example.policy_task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyTest {
    PolicyObject flat;
    PolicyObject garage;
    PolicyObject house;

    @BeforeEach
    void setUp() {
        PolicySubObject tv = new PolicySubObject("A TV", 100, RiskType.FIRE);
        PolicySubObject PS5 = new PolicySubObject("A PS5", 100.1, RiskType.FIRE);
        PolicySubObject car = new PolicySubObject("A car", 99.9, RiskType.FIRE);

        flat = new PolicyObject("A Flat", List.of(tv));
        garage = new PolicyObject("A Garage", List.of(tv, car, PS5));
        house = new PolicyObject("A House", List.of(tv, PS5));
    }

    @Test
    void testOneObject() {
        Policy testOneObject = new Policy("LV123-12332", Status.REGISTERED, List.of(flat));
        assertEquals(new BigDecimal("1.40"), testOneObject.getPremium());
    }

    @Test
    void testNoObject() {
        Policy testNoObjects = new Policy("LV123-12332", Status.REGISTERED, List.of());
        assertEquals(new BigDecimal("0"), testNoObjects.getPremium());
    }

    @Test
    void testMultipleObjects() {
        Policy testMultipleObjects = new Policy("LV123-12332", Status.REGISTERED, List.of(garage, flat, house));
        assertEquals(new BigDecimal("10.40"), testMultipleObjects.getPremium());
    }

}