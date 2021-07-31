package ru.job4j.solid.design;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportTest {

    private static final Object UTF = 8;

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForProgrammers(store);
        StringBuilder expect = new StringBuilder()
                .append("<p>")
                .append("Name; Hired; Fired; Salary;")
                .append("</p>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenSalaryInDollarsGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForCounters(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(6000.0).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenSalaryDescendingOrderGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee workerTwo = new Employee("Evgeniy", now, now, 150);
        store.add(worker);
        store.add(workerTwo);
        Report engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerTwo.getName()).append(";")
                .append(workerTwo.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee workerTwo = new Employee("Evgeniy", now, now, 150);
        store.add(worker);
        store.add(workerTwo);
        Report engine = new ReportToXML(store);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<Employees>")
                .append(System.lineSeparator());
        for (Employee emp : store.findBy(employee -> true)) {
            String expect = String.format("<Employee name=\"%s\" hired=\"%s\" fired=\"%s\" salary=\"%s\"/>",
                    emp.getName(), dateFormat.format(emp.getHired().getTime()),
                    dateFormat.format(emp.getFired().getTime()), emp.getSalary());
            sb.append(expect).append(System.lineSeparator());
        }
        sb.append("</Employees>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true).replaceAll(" ", ""),
                is(sb.toString().replaceAll(" ", "")));
    }

    @Test
    public void whenGenerateJSON() {
        JSONArray expect = new JSONArray();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee worker = new Employee("Ivan", now, now, 100.5);
        Employee workerTwo = new Employee("Evgeniy", now, now, 150.25);
        store.add(worker);
        store.add(workerTwo);
        Report engine = new ReportToJson(store);
        for (Employee emp : store.findBy(employee -> true)) {
            JSONObject jsonEmployees = new JSONObject();
            jsonEmployees.put("name", emp.getName());
            jsonEmployees.put("hired", dateFormat.format(emp.getHired().getTime()));
            jsonEmployees.put("fired", dateFormat.format(emp.getFired().getTime()));
            jsonEmployees.put("salary", emp.getSalary());
            expect.put(jsonEmployees);
        }
        assertThat(engine.generate(employee -> true), is(expect.toString()));
    }
}

    /*
      String expect = String.format("%s\"fired\":\"%s\", \"name\":\"%s\",  \"hired\":\"%s\", \"salary\": %s %s",
                    "{",
                    dateFormat.format(emp.getFired().getTime()),
                    emp.getName(), dateFormat.format(emp.getHired().getTime()),
                    emp.getSalary(), "}");

            text.append(expect);
     */


