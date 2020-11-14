package com.example.demo.testcontroller;

import com.example.demo.MathUtil;
import com.example.demo.SampleResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping(value = "/")

    public String getHelloWorld() {

        return "Hello World";
    }

    @GetMapping("math/min/{a}/{b}")
    public String minEndpoint(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return "Min väärtus on: " + min(a, b);
    }

    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }

    }

    @GetMapping("math/abs/{a}")
    public String absEndpoint(@PathVariable("a") Integer a) {
        return "Abs väärtus on: " + MathUtil.abs(a);
    }

    @GetMapping("math/even/{a}")
    public String evenEndpoint(@PathVariable("a") Integer a) {
        return "Abs väärtus on: " + MathUtil.isNumberEven(a);
    }

    @GetMapping("math/fib/{a}")
    public String fib(@PathVariable("a") Integer a) {
        return "Fibonacci arv " + MathUtil.fibonacci1(a);
    }

    @GetMapping("math/closest")
    public String closest(@RequestParam("aKey") int a, @RequestParam("bKey") int b, @RequestParam("cKey") int c) {
        return "Closest to zero " + MathUtil.closestToZero(a, b, c);
    }

    @GetMapping("employee")
    public SampleResult lesson() {
        SampleResult a = new SampleResult();
        a.setAuto_number("098ABC");
        a.setName("Vasja Ass");
        a.setVanus("32");
        return (a);
    }

    List<SampleResult> elements = new ArrayList<>();

    @PostMapping("employee")
    public List<SampleResult> add_employee(@RequestBody SampleResult x) {
        elements.add(x);
        return (elements);
    }

    //returns out all employees
    @GetMapping("employees")
    public List<SampleResult> employees() {
         return (elements);
     }

    //returns employee by id
    @GetMapping("employee/{id}")
    public SampleResult return_employee(@PathVariable("id") Integer a) {
        return elements.get(a);
    }


     //updates employee data
     @GetMapping("employee/update/{id}")
     public List<SampleResult> update_employee(@PathVariable("id") Integer i,
                                         @RequestParam("name") String a,
                                         @RequestParam("auto") String b,
                                         @RequestParam("vanus") String c){

     elements.get(i).setName(a);
     elements.get(i).setAuto_number(b);
     elements.get(i).setVanus(c);
     return elements;
     }

    //add employee to list
    @GetMapping("employee/add")
    public List<SampleResult> add_employ(@RequestParam("name") String a,
                                         @RequestParam("auto") String b,
                                         @RequestParam("vanus") String c) {
        SampleResult x = new SampleResult();
        x.setName(a);
        x.setAuto_number(b);
        x.setVanus(c);
        elements.add(x);
        return (elements);

    }

    //delete employee
    @GetMapping("employee/delete/{id}")
    public List<SampleResult> delete_employee(@PathVariable("id") Integer i) {
       // List<SampleResult> elements_new = new ArrayList<>();
      //  elements_new=elements.remove(i);
        //return elements_new;
        elements.remove(elements.get(i));
        return elements;

    }
}
