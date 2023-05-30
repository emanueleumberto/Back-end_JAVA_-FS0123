package com.example.SpringAppTestJunit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ProductTest.class, UserTest.class })
public class AllTests {

}
