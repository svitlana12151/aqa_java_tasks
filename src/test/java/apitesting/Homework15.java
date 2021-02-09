package test.java.apitesting;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

public class Homework15 {
    String taskId;

    @Test(priority = 1)
    public void getAllTasks() {
    given().header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                when().get("https://api.todoist.com/rest/v1/tasks").
                then().statusCode(200).
                assertThat().body(matchesJsonSchemaInClasspath("getBodyasArray.json"));
    }

    @Test(priority = 0)
    public void createNewTask() {
        String expectTaskName = "Fruits";
        Response response = given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                contentType(ContentType.JSON).
                body(new File("createNewTask.json")).
                when().
                post("https://api.todoist.com/rest/v1/tasks");
        JsonPath path = response.jsonPath();
        String actualTaskName = path.get("content");
        taskId = path.get("id").toString();
        response.then().statusCode(200).
                assertThat().body(matchesJsonSchemaInClasspath("getBodyValidation.json"));
        assertEquals(actualTaskName, expectTaskName);
    }

    @Test(dependsOnMethods = "createNewTask", priority = 2)
    public void getTaskById() {
        Response response = given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                contentType(ContentType.JSON).
                when().
                get("https://api.todoist.com/rest/v1/tasks/" + taskId).andReturn();
        JsonPath path = response.jsonPath();
        String actualTaskId = path.get("id").toString();
        response.then().statusCode(200).
                assertThat().body(matchesJsonSchemaInClasspath("getBodyValidation.json"));
        assertEquals(actualTaskId, taskId);
    }

    @Test(dependsOnMethods = "createNewTask", priority = 3)
    public void updateTask(){
       given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                header("Content-Type", "application/json").
                body(new File("updateTask.json")).
                when().
                post("https://api.todoist.com/rest/v1/tasks/" + taskId).
        then().statusCode(204);
    }

    @Test(dependsOnMethods = "createNewTask", priority = 4)
    public void closeTaskById(){
        given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                when().
                post("https://api.todoist.com/rest/v1/tasks/" + taskId + "/close").
                then().statusCode(204);
    }
    @Test
            (dependsOnMethods = "closeTaskById", priority = 5)
    public void reopenTaskById(){
        given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                when().
                post("https://api.todoist.com/rest/v1/tasks/" + taskId + "/reopen").
                then().statusCode(204);
    }

    @Test(dependsOnMethods = "createNewTask", priority = 6)
    public void deleteTaskById(){
        given().
                header("Authorization", "Bearer 07dec7d7d043c45d4a81bd4c2f371baeb530970f").
                when().
                delete("https://api.todoist.com/rest/v1/tasks/" + taskId).
                then().statusCode(204);
    }
}
