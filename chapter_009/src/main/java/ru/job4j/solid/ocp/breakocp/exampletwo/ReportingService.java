package ru.job4j.solid.ocp.breakocp.exampletwo;

public class ReportingService {
    public void generateReportBasedOnType(ReportingType reportingType) {
        System.out.println("===================================");
        System.out.println("Generating report based on Type");
        System.out.println("===================================");

        if ("CSV".equalsIgnoreCase(reportingType.toString())) {
            generateCSVReport();
        } else if ("XML".equalsIgnoreCase(reportingType.toString())) {
            generateXMLReport();
        }
    }
    
    private void generateCSVReport() {
        System.out.println("Generate CSV Report");
    }

    private void generateXMLReport() {
        System.out.println("Generate XML Report");
    }

}
