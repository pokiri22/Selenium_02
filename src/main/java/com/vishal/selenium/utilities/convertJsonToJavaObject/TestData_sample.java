package com.vishal.selenium.utilities.TestNG;

import java.util.List;
import java.util.Map;

public class TestData_sample {
    public String environment;
    public String baseUrl;

   // public List<Map<Object,Object> > arr; // method 1
    // System.out.println(obj2.arr.get(0).get("name"));

    public List<Person> arr; // method 2
    // System.out.println(obj2.arr.get(0).name);

    public List<CompanyDetails> mapArr;
}
 class Person {
    public String name;
    public String age;
}

class CompanyDetails {

    private String name;
    public Map<String, String> companies;

    public String getName() {
        return name;
    }

    public Map<String, String> getCompanies() {
        return companies;
    }
}
