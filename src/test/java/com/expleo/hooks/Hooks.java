package com.expleo.hooks;

import com.expleo.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context)
    {
        this.context=context;
    }

    //before each scenario
    @Before
    public void beforeScenario(Scenario scenario)
    {
        System.out.println(scenario.getName());
    }

    //after each scenario
    @After
    public void endScenario()
    {
        if(context.getResponse()!=null)
        {
            context.reset();
        }
        System.out.println("reset context");
    }
}


