package com.company.JavaEnum.baeldung;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

// https://www.baeldung.com/a-guide-to-java-enums

@Data
public class Pizza {
    PizzaStatus status;

    @AllArgsConstructor
    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        @Getter private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }
}
