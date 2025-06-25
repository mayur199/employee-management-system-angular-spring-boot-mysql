package com.example.demo.model;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Status fromLabel(String label) {
        return java.util.Arrays.stream(values()).filter(s -> s.label.equals(label)).findFirst().orElseThrow(() -> new IllegalArgumentException("No enum constant with label " + label));
    }

}
