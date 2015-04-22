package br.apd3.projeto.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerFactory {

    public static final Controller getControllerByClass(Class actionClass) {
        Controller controller;
        try {
            controller = (Controller) actionClass.newInstance();
            return controller;
        } catch (InstantiationException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static final Controller getControllerByFullClassName(String className) {

        try {

            String name = "br.apd3.projeto.controllers" + className + "Controller";
            Class actionClass = Class.forName(name);

            return getControllerByClass(actionClass);

        } catch (ClassNotFoundException e) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;

    }

}
