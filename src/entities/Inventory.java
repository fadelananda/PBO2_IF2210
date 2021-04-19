package entities;

import java.util.ArrayList;
import java.util.List;


public abstract class  Inventory<T> {
    protected static final int MAX_INVENTORY = 10;
    protected List<T> listInventory = new ArrayList<>();
    protected static int jumlahItem = 0;

    public static int getJumlahItem()
    {
        return jumlahItem;
    }
    //abstract method
    public abstract void addItem(T item , int n);
    public abstract void deleteItemByIdx(int index, int n);
    public abstract T getItemByIdxShowInventory(int index);
    public abstract void showInventory();
    }