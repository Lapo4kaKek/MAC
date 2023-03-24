//import Restaurant.models.*;

import Restaurant.models.*;
import Restaurant.models.DishCards;
import com.google.gson.reflect.TypeToken;
import org.json.*;
import com.google.gson.Gson;
import Restaurant.models.DishCards.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import Restaurant.models.*;

public class Parser {
    Menu menu;
    ArrayList<Guest> guests;
    ArrayList<Cooker> cookers;
    ArrayList<Operation> operations;
    ArrayList<Equipment> equipments;


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
            e.printStackTrace();
        }
    }
    public void getGuestsJson() {
        Path path = Paths.get("input/guests.txt");
        try {
            GuestsList guestsList = new Gson().fromJson(new String(Files.readAllBytes(path)), GuestsList.class);
            //System.out.println(guestsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getDishesCardsJson() {
        Path path = Paths.get("input/dish_cards.json");
        try {
            DishCards dishCards = new Gson().fromJson(new String(Files.readAllBytes(path)), DishCards.class);
            int x =4;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
