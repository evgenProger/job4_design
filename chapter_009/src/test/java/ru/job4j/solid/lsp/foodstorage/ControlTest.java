package ru.job4j.solid.lsp.foodstorage;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlTest {

    private List<Store> stores = new ArrayList<>();
    private ControlQuality controlQuality;
    private Warehouse warehouse;
    private Trash trash;
    private Shop shop;

    @Before
    public void fillingStores() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        controlQuality = new ControlQuality(stores);

    }

    @Test
    public void whenExpiredDateLessThen25PercentThenToWarehouse() {
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +20);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -80);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        controlQuality.distribute(food);
        assertThat(warehouse.getFoods().get(0).getName(), is("Milk"));
    }

    @Test
    public void whenExpiredDateEndThenToTrash() {
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, -1);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -50);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        controlQuality.distribute(food);
        assertThat(trash.getFoods().get(0).getName(), is("Milk"));

    }

    @Test
    public void whenExpiredDateFineThenToShop() {
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +10);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -5);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 0);
        controlQuality.distribute(food);
        assertThat(shop.getFoods().get(0).getName(), is("Milk"));
    }

    @Test
    public void whenExpiredDateFreshThenDiscount() {
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +30);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -1);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 0);
        controlQuality.distribute(food);
        assertThat(shop.getFoods().get(0).getDiscount(), is(10.0));
    }

    @Test
    public void whenDirectFoodToPlace() {
        Calendar expiredDateForWarehouse = Calendar.getInstance();
        expiredDateForWarehouse.add(Calendar.DAY_OF_MONTH, +20);
        Calendar createDateForWarehouse = Calendar.getInstance();
        createDateForWarehouse.add(Calendar.DAY_OF_MONTH, -80);
        Calendar expiredDateForTrash = Calendar.getInstance();
        expiredDateForTrash.add(Calendar.DAY_OF_MONTH, -1);
        Calendar createDateForTrash = Calendar.getInstance();
        createDateForTrash.add(Calendar.DAY_OF_MONTH, -50);
        Calendar expiredDateForShop = Calendar.getInstance();
        expiredDateForShop.add(Calendar.DAY_OF_MONTH, +10);
        Calendar createDateForShop = Calendar.getInstance();
        createDateForShop.add(Calendar.DAY_OF_MONTH, -5);
        Calendar expiredDateForDiscount = Calendar.getInstance();
        expiredDateForDiscount.add(Calendar.DAY_OF_MONTH, +30);
        Calendar createDateForDiscount = Calendar.getInstance();
        createDateForDiscount.add(Calendar.DAY_OF_MONTH, -1);
        Food toWarehouse = new Food("Cheese", expiredDateForWarehouse, createDateForWarehouse, 60.2, 0);
        Food toTrash = new Food("Sour Cream", expiredDateForTrash, createDateForTrash, 87, 0);
        Food toShop = new Food("Meat", expiredDateForShop, createDateForShop, 124, 0);
        Food toDiscount = new Food("Ice cream", expiredDateForDiscount, createDateForDiscount, 26, 0);
        controlQuality.distribute(toWarehouse);
        controlQuality.distribute(toTrash);
        controlQuality.distribute(toShop);
        controlQuality.distribute(toDiscount);
        assertThat(warehouse.getFoods().get(0).getName(), is("Cheese"));
        assertThat(trash.getFoods().get(0).getName(), is("Sour Cream"));
        assertThat(shop.getFoods().get(0).getName(), is("Meat"));
        assertThat(shop.getFoods().get(1).getDiscount(), is(10.0));
        assertThat(warehouse.getFoods().size(), is(1));
        assertThat(trash.getFoods().size(), is(1));
        assertThat(shop.getFoods().size(), is(2));
    }
}