package com.myproject;

import com.harium.propan.Propan;
import com.harium.propan.core.context.ApplicationGL;

public class Main extends Propan {

    public Main() {
        super(1280, 720);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("My Propan Project");
        main.init();
    }

    public ApplicationGL startApplication() {
        return new HelloPropanGDX(w, h);
    }
}
