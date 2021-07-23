package ru.job4j.solid.ocp.breakocp.exampletwo;
/*
Как видим, нам нужно изменить во многих местах, которые мы уже протестировали,
 и нам нужно еще раз протестировать все функции.

 Посмотрим, как принцип открытого и закрытого дизайна сможет решить эту проблему.
Создадим интерфейс  ReportingService.java.

https://java2blog.com/open-closed-principle-java/
 */

public class GenerateReportMain {
    public static void main(String[] args) {
        ReportingService rs = new ReportingService();
        // Generate CSV file
        rs.generateReportBasedOnType(ReportingType.CSV);
        System.out.println();
        // Generate XML file
        rs.generateReportBasedOnType(ReportingType.XML);
    }
}
