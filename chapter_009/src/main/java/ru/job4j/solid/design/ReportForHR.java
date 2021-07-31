package ru.job4j.solid.design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {
    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> emp = store.findBy(filter);
        emp.sort(new ComparatorBySalary().reversed());
        text.append("Name; Salary;")
        .append(System.lineSeparator());
        for (Employee employee : emp) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    private static class ComparatorBySalary implements Comparator<Employee> {
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return (int) (emp1.getSalary() - emp2.getSalary());
        }
    }
}
