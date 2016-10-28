package asigurari.data.repository;

import asigurari.controller.IController;

/**
 * Created by buresina on 26/10/2016.
 */
public class RepoFactory {

    public static IController createRepo(Class tClass) {
        return new GenericRepository(tClass);
    }
}
