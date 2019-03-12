package com.TogglzDemo;

import com.togglz.configuration.FeatureTogglz;
import org.junit.Rule;
import org.junit.Test;
import org.togglz.junit.TogglzRule;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestFeatures {

    @Rule
    public TogglzRule togglzRule = TogglzRule.allEnabled(FeatureTogglz.class);

    //WE can enable and disable all the feature flags on this method by using the rule
    @Test
    public void testAllFeatures() {
        assertTrue(FeatureTogglz.NEW_FEATURE.isActive());
        togglzRule.disable(FeatureTogglz.OLD_FEATURE);
        assertFalse(FeatureTogglz.OLD_FEATURE.isActive());
    }
}
