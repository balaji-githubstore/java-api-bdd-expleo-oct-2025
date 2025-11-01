package com.expleo.steps;

import com.expleo.helpers.GitAPIHelper;
import com.expleo.model.Repository;
import io.restassured.response.Response;
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
        Repository repo1=Repository.builder().id(4L).name("jack").full_name("jack den").build();

        //@AllArgsConstructor
        Repository rep2=new Repository(4L,"jack","jack den");

        //@NoArgsConstructor
        Repository rep3=new Repository();
        rep3.setId(4L);
        rep3.setName("jack");
        rep3.setFull_name("jack den");


        Repository repo4=Repository.builder().name("new-repo-api-automation").build();


    }

    @Test
    public void listAllRepoForUserTest()
    {
       Response response= GitAPIHelper.listRepositoriesForAuthenticatedUser();
       System.out.println(response.asString());

    }
}
