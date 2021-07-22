package ru.job4j.solid.srp.design;

import java.util.function.Predicate;

public class ReportForProgrammers implements Report {
    private Store store;

    public ReportForProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder html = new StringBuilder();
        html.append("<p>")
                .append("Name; Hired; Fired; Salary;")
                .append("</p>")
                .append(System.lineSeparator());

        for (Employee employee: store.findBy(filter)) {
            html.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>")
                    .append(System.lineSeparator());
        }
        return html.toString();
    }
}
