package com.togglz.service;

public class SecondFeature implements FeatureNew {
    @Override
    public FeatureNew getFeature() {
        return new SecondFeature();
    }

    @Override
    public String getName() {
        return "second Feature";
    }
}
