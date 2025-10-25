package com.expleo.steps;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * WIll be deleted. not part of bdd framework
 * No need to add this
 */
public class ZDemoTest {

    @Test
    public void ReadProp() throws IOException {
        FileInputStream file=new FileInputStream("src/test/resources/config.properties"); //new FileNotFoundException("")

        Properties prop=new Properties();
        prop.load(file);  //new IOException

        String baseURI=prop.getProperty("github.base.uri");
        System.out.println(baseURI);

    }
}
