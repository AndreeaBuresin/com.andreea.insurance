package asigurari.controller;

import asigurari.data.repository.RepoFactory;

/**
 * Created by buresina on 26/10/2016.
 */
public class ControllerFactory {
    private ControllerFactory(){}

    public static IController createController(Class tClass) {
        return new GenericController(RepoFactory.createRepo(tClass));
    }
}
