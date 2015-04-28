package br.mack.projeto.war.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerFactory {

    private static Controller getControllerByClass(Class actionClass) {
        
        Controller controller;
        
        try {
            controller = (Controller) actionClass.newInstance();
            return controller;
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static final Controller getControllerByFullClassName(String className) {

        try {

            String name = "br.mack.projeto.war.controllers." + className + "Controller";
            Class actionClass = Class.forName(name);

            return getControllerByClass(actionClass);

        } catch (ClassNotFoundException e) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;

    }

}
