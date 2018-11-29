package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;

import lombok.Data;

import com.microsoft.azure.functions.*;

public class Function {

    private ArrayList<Employee> employees = new ArrayList<>();

    @FunctionName("create")
    public Employee create(@HttpTrigger(name = "createemployeerest", methods = {
            HttpMethod.POST }, route = "employee", authLevel = AuthorizationLevel.ANONYMOUS)

    Employee employee) {

        employee.setId(0);
        employee.setName("name teste");
        employee.setAge(11);
        employee.setSallary(100000);

        employees.add(employee);

        return employee;
    }

    @FunctionName("read")
    public ArrayList<Employee> read(@HttpTrigger(name = "listemployee", methods = {
            HttpMethod.GET }, route = "employee"

    ) Employee employee) {

        return employees;
    }

    @FunctionName("update")
    public Employee update(@HttpTrigger(name = "updateemployee", methods = {
            HttpMethod.PUT }, route = "employee"

    ) Employee employee) {

        employee.setName(employee.getName() + " - updated!");

        return employee;
    }

    @FunctionName("delete")
    public Employee delete(@HttpTrigger(name = "delete-employee", methods = {
            HttpMethod.DELETE }, route = "employee"

    ) Employee employee) {
        employees.remove(employee);

        return employee;
    }
}

@Data
class Employee {
    private long id;
    private String name;
    private int age;
    private double sallary;

    public Employee() {
    }

    public Employee(long id, String name, int age, double sallary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.sallary = sallary;
    }
}
