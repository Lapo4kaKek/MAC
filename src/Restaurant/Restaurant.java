package Restaurant;
import Restaurant.models.Guest;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Restaurant {
    // здесь храним список посетителей, и ...
    ArrayList<Guest> guests;
    public Restaurant(ArrayList<Guest> list) {
        guests = list;
    }
    public Restaurant() {
    }
}
