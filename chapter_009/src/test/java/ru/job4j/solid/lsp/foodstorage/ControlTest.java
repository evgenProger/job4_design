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

  /*  @Before
    public void fillingStores() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
    }
   */

    @Test
    public void whenExpiredDateLessThen25PercentThenToWarehouse() {
        List<Store> stores = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        stores.add(warehouse);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +20);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -80);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        assertTrue(stores.get(0).accept(food));
    }

    @Test
    public void whenExpiredDateEndThenToTrash() {
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(trash);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, -1);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -50);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        assertTrue(stores.get(0).accept(food));

    }

    @Test
    public void whenExpiredDateFineThenToShop() {
        Shop shop = new Shop();
        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +10);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -5);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 5);
        assertTrue(stores.get(0).accept(food));
    }

    @Test
    public void whenExpiredDateFreshThenDiscount() {
        Shop shop = new Shop();
        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, +30);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -1);
        Food food = new Food("Milk", expiredDate, createDate, 60.2, 0);
        assertTrue(stores.get(0).accept(food));
    }

    /*
    @Test
    public void whenDirectFoodToPlace() {
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Context contextWarehouse = new Context(warehouse);
        Context contextTrash = new Context(trash);
        Context contextShop = new Context(shop);
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
        Food toWarehouse = new Food("Milk", expiredDateForWarehouse, createDateForWarehouse, 60.2, 0);
        Food toTrash = new Food("Sour Cream", expiredDateForTrash, createDateForTrash, 87, 0);
        Food toShop = new Food("Meat", expiredDateForShop, createDateForShop, 124, 0);
        Food toDiscount = new Food("Ice cream", expiredDateForDiscount, createDateForDiscount, 26, 0);
        assertThat(contextWarehouse.executeStrategy(toWarehouse).get(0).getName(), is("Milk"));
        assertThat(contextTrash.executeStrategy(toTrash).get(0).getName(), is("Sour Cream"));
        assertThat(contextShop.executeStrategy(toShop).get(0).getName(), is("Meat"));
        assertThat(contextShop.executeStrategy(toDiscount).get(0).getDiscount(), is(10.0));
    }

     */
}