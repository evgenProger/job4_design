package ru.job4j.solid.design;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

public class ReportToJson implements Report {
    private Store store;

    public ReportToJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray arrEmployees = new JSONArray();
        for (Employee emp: store.findBy(filter)) {
            JSONObject jsonEmployee = new JSONObject();
            jsonEmployee.put("name", emp.getName());
            jsonEmployee.put("hired", dateFormat.format(emp.getHired().getTime()));
            jsonEmployee.put("fired", dateFormat.format(emp.getFired().getTime()));
            jsonEmployee.put("salary", emp.getSalary());
            arrEmployees.put(jsonEmployee);
        }
        System.out.println(arrEmployees);

        return arrEmployees.toString();
    }
}
