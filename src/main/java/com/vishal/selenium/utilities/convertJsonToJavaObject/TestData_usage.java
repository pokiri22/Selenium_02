package com.vishal.selenium.utilities.TestNG;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestData_usage {

    public static void main(String[] args) throws IOException {

        //        InputStream stream = Files.newInputStream(Path.of("src\\main\\resources\\dummy.txt));
        //        String content = IOUtils.toString(stream, StandardCharsets.UTF_8);
        //        System.out.println(content);
        //         Uses a physical file path  , Works only inside your IDE  , Breaks after packaging as JAR , Breaks in CI/CD pipelines
        //         Breaks if project structure changes

        // we can also do it as below ( recomended one  )
            InputStream stream_x = TestData_usage.class.getClassLoader().getResourceAsStream("sample.json");
        //String content2 = IOUtils.toString(stream_x, StandardCharsets.UTF_8);
        //System.out.println(content2);

        // Main.class        = gives the Class object of your Main class.
        // .getClassLoader() = it gives the class Loader that loaded this class.
        // .getResourcesAsStream( file_name ) = Search for a file named dummy.txt inside the classpath and return  it as an InputStream.

        InputStream stream1 = TestData_usage.class.getClassLoader(). getResourceAsStream("sample.json");
        String json = new String(stream1.readAllBytes(), StandardCharsets.UTF_8);
        //System.out.println(json);

        // one stream can be used only one time so, it will throw an error for using this stream 2 times. { xd }
        ObjectMapper mapper = new ObjectMapper();
        //TestData_sample obj = mapper.readValue(stream1, TestData_sample.class); // it will throw error because of { xd }
        TestData_sample obj2 = mapper.readValue(json , TestData_sample.class);  // it will be passed
        System.out.println(obj2.mapArr.get(0).getCompanies().get("first"));

//        ObjectMapper mapper2 = new ObjectMapper();
//        JsonNode root = mapper2.readTree(new File("PATH"));
//
//        for (JsonNode person : root.get("mapArr")) {
//            if (person.get("name").asText().equals("king")) {
//
//                String company = person
//                        .get("companies")
//                        .get("second")
//                        .asText();
//
//                System.out.println(company);
//            }
//        }

    }
}
