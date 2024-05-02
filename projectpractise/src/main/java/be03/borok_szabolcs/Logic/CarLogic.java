package be03.borok_szabolcs.Logic;

import be03.borok_szabolcs.Repository.MainRepository;

public abstract class MainLogic<T> implements IMainLogic<T> {
    MainRepository<T> repository;

    public MainLogic() {
        this.repository = new MainRepository;
    }





}
