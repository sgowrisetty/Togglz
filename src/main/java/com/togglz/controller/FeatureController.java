package com.togglz.controller;

import com.togglz.configuration.FeatureTogglz;
import com.togglz.configuration.TogglzConfiguration;
import com.togglz.service.FeatureNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.console.TogglzConsoleServlet;

@RestController
@RequestMapping(value = "/api")
public class FeatureController {

    @Autowired
    private FeatureNew featureNew;

    //This method will check the request whether the feature is set enabled or not and return the responce
    @GetMapping(value = "/oldFeature")
    public String getOldImplementation() {
        if (FeatureTogglz.OLD_FEATURE.isActive())
            return "Old Implementation";
        else
            return "this Feature is disabled";
    }

    //This method will check the request whether the feature is set enabled or not and return the responce
    @GetMapping(value = "/newFeature")
    public String getNewImplementation() {
        if (FeatureTogglz.NEW_FEATURE.isActive())
            return "New Implementation";
        else
            return "this Feature is disabled";
    }

    //This Method will retrieve the active implimentation of the Feature class
    @GetMapping(value = "/getActiveFeature")
    public String getFeature() {
        return this.featureNew.getName();
    }

}
