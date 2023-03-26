//import Restaurant.models.*;

import Restaurant.models.*;
import Restaurant.models.DishCards;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Parser {
    MenuDishesList menu;
    //Menu menu;
    List<Guest> guests;
    ArrayList<Cooker> cookers;
    List<Operation> operations;
    List<Equipment> equipments;
    List<DishCard> dish_cards;
    List<EquipmentType> equipmentTypeList;
    List<AdvancedProduct> productList;
    public List<Cooker> getCookers() {
        return cookers;
    }
    public List<DishCard> getDishcard() {
        return dish_cards;
    }
    public List<Equipment> getEquipments() {
        return equipments;
    }
    public List<AdvancedProduct> getAdvancedProducts() {
        return productList;
    }
    public List<Guest> getGuests() {
        return guests;
    }
    public Guest getOneGuest(int index) {
        return guests.get(index);
    }
    public void JsonParse() {
        ExecutorService executor = Executors.newFixedThreadPool(8); // создаем пул потоков
        List<Callable<Void>> tasks = new ArrayList<>(); // создаем список задач
        // Добавляем задачи в список
        tasks.add(() -> {
            getCookersJson();
            return null;
        });
        tasks.add(() -> {
            getDishesCardsJson();
            return null;
        });
        tasks.add(() -> {
            getGuestsJson();
            return null;
        });
        tasks.add(() -> {
            getEquipmentJson();
            return null;
        });
        tasks.add(() -> {
            getEquipmentTypeJson();
            return null;
        });
        tasks.add(() -> {
            getProductsJson();
            return null;
        });
        tasks.add(() -> {
            getProductTypeJson();
            return null;
        });
        tasks.add(() -> {
            getMenuJson();
            return null;
        });

        // выполняем задачи и получаем список Future
        try {
            List<Future<Void>> futures = executor.invokeAll(tasks);
            for (Future<Void> future : futures) {
                // ожидаем завершения задачи
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // закрываем пул потоков
            executor.shutdown();
        }
    }
    // it's Ok
    public void getCookersJson() {
        Path path = Paths.get("input/cookers.txt"); // создаем объект Path для файла products.json
        try {
            String content = new String(Files.readAllBytes(path));
            //System.out.println(content);
            CookersList cookersList = new Gson().fromJson(content, CookersList.class);
            cookers = cookersList.getCookers();
            //System.out.println(cookers);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // it's Ok
    public void getDishesCardsJson() {
        Path path = Paths.get("input/dish_cards.txt");
        try {
            DishCards dishCards = new Gson().fromJson(new String(Files.readAllBytes(path)), DishCards.class);
            dish_cards = dishCards.getDishCards();
            System.out.println(dishCards);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // it's Ok
    public void getGuestsJson() {
        Path path = Paths.get("input/visitors_orders.txt");
        try {
            GuestsList guestsList = new Gson().fromJson(new String(Files.readAllBytes(path)), GuestsList.class);
            guests = guestsList.getVisitorsOrders();
            System.out.println(guestsList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // it's Ok
    public void getEquipmentJson() {
        Path path = Paths.get("input/equipment.txt");
        try {
            EquipmentList equipmentList = new Gson().fromJson(new String(Files.readAllBytes(path)), EquipmentList.class );
            equipments = equipmentList.getEquipments();
            System.out.println(equipmentList);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // it's Ok
    public void getEquipmentTypeJson() {
        Path path = Paths.get("input/equipment_type.txt");
        try {
            EquipmentTypeList equipmentTypeList_ = new Gson()
                    .fromJson(new String(Files.readAllBytes(path)), EquipmentTypeList.class);
            equipmentTypeList = equipmentTypeList_.getVisitorsOrders();
            System.out.println(equipmentTypeList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /* здесь нужно поправить поля в products для совпадения
    public void getProductsJson() {
        Path path = Paths.get("input/products.txt");
        try {
            ProductsList productsList = new Gson().fromJson(new String(Files.readAllBytes(path)), ProductsList.class);
            System.out.println(productsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    // it's Ok
    public void getProductTypeJson() {
        Path path = Paths.get("input/product_types.txt");
        try {
            ProductTypes productTypes = new Gson().fromJson(new String(Files.readAllBytes(path)), ProductTypes.class);

            System.out.println(productTypes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // it's Ok
    public void getMenuJson() {
        Path path = Paths.get("input/menu_dishes.txt");
        try {
            MenuDishesList menuDishesList = new Gson().fromJson(new String(Files.readAllBytes(path)), MenuDishesList.class);
            menu = menuDishesList;
            System.out.println(menuDishesList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // it's Ok
    public void getProductsJson() {
        Path path = Paths.get("input/products.txt");
        try {
            AdvancedProductList productList_ = new Gson().fromJson(new String(Files.readAllBytes(path)), AdvancedProductList.class);
            productList = productList_.getProducts();
            System.out.println(productList_);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
