package ru.job4j.solid.design;

import java.util.function.Predicate;

public class ReportForCounters implements Report{
    private Store store;

    public ReportForCounters(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        double dollar = 60;
        text.append("Name; Hired; Fired; Salary;")
        .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * dollar).append(";")
                    .append(System.lineSeparator());


        }
        return text.toString();
    }
}
