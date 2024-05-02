package be03.borok_szabolcs.Repository;

import java.sql.SQLException;

import java.util.List;

public interface IMainRepository<T> {

    // IMainrepository<T> : Minden olyan tipusra meghivhato interface, amit mi T helyere irunk
    // Egy generikus osztalyt kepvisel, amely minden osztalynak megfeleltetheto
    // T: tetszoleges osztaly
    // Generikus: Altalanos


    // T tipusu elemmel fog visszaterni, hol T barmilyen tipusu elem
    
    T GetOne(Integer id) throws SQLException;    // R - egy elemet
    void Insert(T object) throws SQLException;                       // C - kap egy T tipusu elemet
    void Delete(Integer id) throws SQLException;                     // D - kap egy indexet
    void Update(T object, Integer id) throws SQLException;           // U - kap egy T tipusu elemet, valamint egy indexet
    List<T> GetAll() throws SQLException;                            // R - osszes elemet

}
