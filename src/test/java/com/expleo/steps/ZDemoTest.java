package com.expleo.steps;

import com.expleo.model.Repository;
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

    @Test
    public void lombokCheckTest()
    {
        //@Data

        //@Builder
        Repository repo=Repository.builder().id(4L).name("jack").full_name("jack den").build();

        //@AllArgsConstructor
        Repository rep=new Repository(4L,"jack","jack den");

        //@NoArgsConstructor
        Repository rep1=new Repository();
        rep1.setId(4L);
        rep1.setName("jack");
        rep1.setFull_name("jack den");
    }
}
