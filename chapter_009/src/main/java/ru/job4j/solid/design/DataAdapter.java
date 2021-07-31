package ru.job4j.solid.design;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataAdapter extends XmlAdapter<String, Calendar> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Calendar unmarshal(String s) throws Exception {
        return null;
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return dateFormat.format(calendar.getTime());
    }
}
