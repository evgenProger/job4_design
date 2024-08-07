package ru.job4j.solid.ocp.breakocp.exampletwo;

public class GenerateReportMain {
    public static void main(String[] args) {
        ReportingService rs = new ReportingService();
        rs.generateReportBasedOnType(ReportingType.CSV);
        System.out.println();
        rs.generateReportBasedOnType(ReportingType.XML);
    }
}
