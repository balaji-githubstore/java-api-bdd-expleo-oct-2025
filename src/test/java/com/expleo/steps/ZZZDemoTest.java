package com.expleo.steps;

import com.expleo.config.ConfigReader;
import com.expleo.config.TokenManager;
import com.expleo.helpers.GitAPIHelper;
import com.expleo.model.Repository;
import com.expleo.utils.GitRequestSpecBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * WIll be deleted. not part of bdd framework
 * No need to add this
 */
public class ZZZDemoTest {

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
//        Repository rep2=new Repository(4L,"jack","jack den");
        //@NoArgsConstructor
        Repository rep3=new Repository();
        rep3.setId(4L);
        rep3.setName("jack");
        rep3.setFull_name("jack den");

        Repository repo4=Repository.builder().name("new-repo-api-automation").build();
    }

    /**
     * Test GitAPIHelper.java class
     */
    @Test
    public void listAllRepoForUserTest()
    {
       Response response= GitAPIHelper.listRepositoriesForAuthenticatedUser();
       System.out.println(response.asString());
    }

    /**
     * Below code give you idea about src/main/java section
     * @throws IOException
     */
    @Test
    public void UnderstandGitHelperRun() throws IOException {

        //TokenManager.java
        FileInputStream file=new FileInputStream("src/test/resources/secret.json");
        JsonPath jsonPath=new JsonPath(file);
        String token=jsonPath.get("token");

        //ConfigReader.java
        file=new FileInputStream("src/test/resources/config.properties"); //new FileNotFoundException("")
        Properties prop=new Properties();
        prop.load(file);  //new IOException
        String baseURI=prop.getProperty("github.base.uri");
        String openAPISpec=prop.getProperty("openapi.spec.path");
        System.out.println(baseURI);


        //GitRequestSpecBuilder.java
        RequestSpecification req=new RequestSpecBuilder()
                .setBaseUri(ConfigReader
                        .getBaseURI())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", TokenManager.getToken())
                .log(LogDetail.ALL)
                .build();


        Response response= RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpec())
                .when()
                .get("/user/repos");

        System.out.println(response.asString());

        //deserialization from response object to pojoclass
        List<Repository> repo= response.as(new TypeRef<List<Repository>>() {});
        System.out.println(repo.get(0).getId());
        System.out.println(repo.get(0).getName());
        System.out.println(repo.get(0).getFull_name());

        //deserialization from response object to pojoclass
        List<Repository> repo1= response.jsonPath().getList(".",Repository.class);
        System.out.println(repo1.get(0).getId());
        System.out.println(repo1.get(0).getName());
        System.out.println(repo1.get(0).getFull_name());

    }
}
