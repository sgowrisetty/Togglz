package com.togglz.configuration;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum FeatureTogglz implements Feature {

    //For Togglz Console : http://localhost:8080/togglz-console/index

    @Label("new Feature")
    NEW_FEATURE,
    @Label("Old Feature")
    OLD_FEATURE,
    @Label("Using Feature")
    USE_FEATURE;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
