package ru.job4j.solid.lsp.foodstorage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ContextTest {
    @Test
    public void whenExpiredDateLessThen25PercentThenToWarehouse() {
        Warehouse warehouse = new Warehouse();
        Context context = new Context(warehouse);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +20);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -80);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        List<Food> foods = new ArrayList<>();
        foods.addAll(context.executeStrategy(food));
        assertThat(foods.get(0).getName(), is("Milk"));
    }

    @Test
    public void whenExpiredDateEndThenToTrash() {
        Trash trash = new Trash();
        Context context = new Context(trash);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, -1);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -50);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        List<Food> foods = new ArrayList<>();
        foods.addAll(context.executeStrategy(food));
        assertThat(foods.get(0).getName(), is("Milk"));
    }

    @Test
    public void whenExpiredDateFineThenToShop() {
        Shop shop = new Shop();
        Context context = new Context(shop);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +10);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -5);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        List<Food> foods = new ArrayList<>();
        foods.addAll(context.executeStrategy(food));
        assertThat(foods.get(0).getName(), is("Milk"));
    }

}