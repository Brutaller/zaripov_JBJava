package kpfu;

import kpfu.Model;

/**
 * Created by Azat Zaripov on 23.12.2015.
 */
public class Service {
    private Model model = new Model();

    public String showString() {
        model.setString("Hello world");
        return model.getString();
    }


}
