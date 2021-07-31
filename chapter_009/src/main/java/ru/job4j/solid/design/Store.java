package ru.job4j.solid.design;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
