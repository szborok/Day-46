package be03.borok_szabolcs.Logic;

import java.sql.SQLException;

import java.util.List;

public interface IMainLogic<T> {

    T getOne(Integer id);                        // R - egy elemet
    void insert(T object);                       // C - kap egy T tipusu elemet
    void delete(Integer id);                     // D - kap egy indexet
    void update(T object, Integer id);           // U - kap egy T tipusu elemet, valamint egy indexet
    List<T> getAll();                            // R - osszes elemet

}
