package org.iths.test.sprint3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:org/iths/test/sprint3",
		glue = {"classpath:org/iths/test/stepDefs"}
		)
public class Sprint3TestSuite {}
