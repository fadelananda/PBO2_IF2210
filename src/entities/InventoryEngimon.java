package entities;

import entities.engimon.Engimon;

public class InventoryEngimon extends Inventory<Engimon>{

    public void addItem(Engimon item,int n)
    {
        if (jumlahItem < MAX_INVENTORY)
        {
            System.out.println("Berhasil ditambahkan!");
            listInventory.add(item);
//            Collections.sort(listInventory, (Engimon e1, Engimon e2) -> e2.getLevel()-e1.getLevel());
//            listInventory = listInventory.stream().collect(Collectors.groupingBy(Engimon::getSpeciesName)).values().stream().toList();
            jumlahItem++;
        }else{
            System.out.println("Inventory sudah penuh");
        }
    }
//
    public void deleteItemByIdx(int index,int n)
    {
        listInventory.remove(index);
        jumlahItem--;
        System.out.println("Item berhasil dihapus dari inventory");
    }

//    //    // mencari item berdasarkan indeks saat isi inventory ditampilkan
    public Engimon getItemByIdxShowInventory(int index)
    {
        return listInventory.get(index);
    }


//    //    tampilkan isi inventory
    public void showInventory()
    {
        for (int i = 0; i < listInventory.size() ; i++)
        {
            System.out.println(Integer.toString(i + 1) +". "+ listInventory.get(i));
        }
    }
}
