package Restaurant.agents;

import Restaurant.models.VisOrdDish;


import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    String message;
    ArrayList<VisOrdDish> id;

    public Message(String s, ArrayList<VisOrdDish> orderAgent) {
        message = s;
        id = orderAgent;
    }
    public String getMessage() {
        return message;
    }
}
