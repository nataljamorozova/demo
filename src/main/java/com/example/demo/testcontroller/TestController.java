package com.example.demo.testcontroller;

import com.example.demo.MathUtil;
import com.example.demo.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

  //  @GetMapping(value = "/")
   // public String getHelloWorld() {

   //     return "Hello World";
  //  }
    @CrossOrigin
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
    public String return_employee(@PathVariable("id") Integer a) {
        String sql = "SELECT auto_number FROM employee WHERE id=:v1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        //SampleResult employee=jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<SampleResult>());
        String auto = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        //return elements.get(a);
        return auto;
    }

    @GetMapping("employee/name/{id}")
    public List<String> name_vanus(@PathVariable("id") Integer a) {
        String sql = "SELECT name FROM employee WHERE vanus=:v1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        List<String> name=jdbcTemplate.queryForList(sql, paramMap, String.class);
        return name;
    }

    //updates employee data
    @GetMapping("employee/update/{id}")
    public List<SampleResult> update_employee(@PathVariable("id") Integer i,
                                              @RequestParam("name") String a,
                                              @RequestParam("auto") String b,
                                              @RequestParam("vanus") Integer c) {
        String sql = "UPDATE employee SET name=:v1, auto_number=:v2, vanus=:v3 WHERE id=:i";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        paramMap.put("v2", b);
        paramMap.put("v3", c);
        paramMap.put("i", i);
        jdbcTemplate.update(sql, paramMap);
        //elements.get(i).setName(a);
        //  elements.get(i).setAuto_number(b);
        // elements.get(i).setVanus(c);
        return elements;
    }

    //add employee to list
    @GetMapping("employee/add")
    public List<SampleResult> add_employ(@RequestParam("name") String a,
                                         @RequestParam("auto") String b,
                                         @RequestParam("vanus") Integer c) {
        String sql = "INSERT INTO employee (name, auto_number, vanus) VALUES (:v1, :v2, :v3)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        paramMap.put("v2", b);
        paramMap.put("v3", c);
        jdbcTemplate.update(sql, paramMap);
        //SampleResult x = new SampleResult();
        //  x.setName(a);
        // x.setAuto_number(b);
        //  x.setVanus(c);
        //   elements.add(x);
        return (elements);

    }

    //delete employee
    @GetMapping("employee/delete/{id}")
    public List<SampleResult> delete_employee(@PathVariable("id") Integer i) {
        String sql = "DELETE FROM employee WHERE id=:v1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", i);
        jdbcTemplate.update(sql, paramMap);
        //elements.remove(elements.get(i));
        return elements;
    }

    //tagastab töötajat id järgi
    @GetMapping("employee/all/{id}")
    public List employee_all(@PathVariable("id") Integer i){
        String sql ="SELECT * FROM employee WHERE id=:v1";
        Map paramMap=new HashMap();
        paramMap.put("v1", i);
        List results=jdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
        return results;
    }

    //tagastab kõik töötajad
    @GetMapping("employee/all")
    public List employee_all(){
        String sql ="SELECT * FROM employee";
        Map paramMap=new HashMap();
        List results=jdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
        return results;
    }

    private class ObjectRowMapper implements RowMapper<SampleResult> {
        @Override
        public SampleResult mapRow(ResultSet resultSet, int i) throws SQLException{
            SampleResult employee=new SampleResult();
            employee.setName(resultSet.getString("name"));
            employee.setAuto_number(resultSet.getString("auto_number"));
            employee.setVanus(resultSet.getString("vanus"));
            return employee;


        }
    }
}
