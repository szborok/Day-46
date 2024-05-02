package be03.borok_szabolcs.Logic;

import java.util.List;

public interface IMainLogic<T> {

    T GetOne(Integer id);                        // R - egy elemet
    void Insert(T object);                       // C - kap egy T tipusu elemet
    void Delete(Integer id);                     // D - kap egy indexet
    void Update(T object, Integer id);           // U - kap egy T tipusu elemet, valamint egy indexet
    List<T> GetAll();                            // R - osszes elemet

}
