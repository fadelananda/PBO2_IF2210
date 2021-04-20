package entities;
import entities.engimon.Engimon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventorySkillItem extends Inventory<SkillItem> {
    private List<Integer> jumlahTiapItem = new ArrayList<>();
    //  add item ke dalam inventory sebanyak n
    public void addItem(SkillItem item, int n)
    {
        if (jumlahItem < MAX_INVENTORY)
        {
            int indexElement = listInventory.indexOf(item);
            if (indexElement == -1)
            {
                listInventory.add(item);
                Collections.sort(listInventory, (SkillItem e1, SkillItem e2) -> e2.getSkill().getBasePower()-e1.getSkill().getBasePower());
                jumlahTiapItem.add(n);
            }else
            {
                int total = jumlahTiapItem.get(indexElement) + n;
                jumlahTiapItem.set(indexElement,total);
            }
            System.out.println("Berhasil ditambahkan!");
            jumlahItem+=n;
        }else{
            System.out.println("Inventory sudah penuh");
        }
    }
    //      del item berdasarkan index inventory sebanyak n
    public void deleteItemByIdx(int index, int n)
    {
        if (jumlahTiapItem.get(index) > n)
        {
            jumlahItem -= n;
            int total = jumlahTiapItem.get(index) - n;
            jumlahTiapItem.set(index,total);
        }else{
            jumlahItem-=jumlahTiapItem.get(index);
            jumlahTiapItem.remove(index);
            listInventory.remove(index);
        }
        System.out.println("Item berhasil dihapus dari inventory");
    }

// mencari item berdasarkan indeks saat isi inventory ditampilkan
    public SkillItem getItemByIdxShowInventory(int index)
    {
        return listInventory.get(index);
    }


//    tampilkan isi inventory
    public void showInventory()
    {
        for (int i = 0; i < listInventory.size() ; i++)
        {
            System.out.println(Integer.toString(i + 1) +". "+ listInventory.get(i)+"/Qty:" + jumlahTiapItem.get(i));
        }
    }
// learn skill item
    void learnSkillItem(int index, Engimon engi){
        boolean learn =listInventory.get(index -1).learn(engi);
        if (learn)
        {
            deleteItemByIdx(index,1);
            jumlahItem--;
        }
    }
}
