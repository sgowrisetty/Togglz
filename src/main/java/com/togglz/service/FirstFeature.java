package com.togglz.service;

public class FirstFeature implements  FeatureNew{
    @Override
    public FeatureNew getFeature() {
        return new FirstFeature();
    }

    @Override
    public String getName() {
        return "FirstFeature";
    }
}
