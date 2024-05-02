package be03.borok_szabolcs.Repository;

import java.sql.SQLException;

import java.util.List;

public interface IMainRepository<T> {

    // IMainrepository<T> : Minden olyan tipusra meghivhato interface, amit mi T helyere irunk
    // Egy generikus osztalyt kepvisel, amely minden osztalynak megfeleltetheto
    // T: tetszoleges osztaly
    // Generikus: Altalanos


    // T tipusu elemmel fog visszaterni, hol T barmilyen tipusu elem
    
    T getOne(Integer id) throws SQLException;    // R - egy elemet
    void insert(T object);                       // C - kap egy T tipusu elemet
    void delete(Integer id);                     // D - kap egy indexet
    void update(T object, Integer id);           // U - kap egy T tipusu elemet, valamint egy indexet
    List<T> getAll();                            // R - osszes elemet

}
