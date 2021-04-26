package entities;

import entities.engimon.Engimon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventorySkillItem extends Inventory<SkillItem> {
    private List<Integer> jumlahTiapItem = new ArrayList<>();
    //  add item ke dalam inventory sebanyak n
    public void addItem(SkillItem item, int n)
    {
        if (jumlahItem + n <= MAX_INVENTORY)
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

    public int getIdxByName(String name) {
        int idx = 1;
        for (SkillItem skillItem : listInventory) {
            if (skillItem.getSkill().getName().equals(name)) {
                return idx;
            }

            idx++;
        }

        return idx;
    }

    //      del item berdasarkan index setelah memanggil method showInventory sebanyak n
    public void deleteItemByIdx(int index, int n)
    {
        if (jumlahTiapItem.get(index - 1) > n)
        {
            jumlahItem -= n;
            int total = jumlahTiapItem.get(index - 1) - n;
            jumlahTiapItem.set(index - 1,total);
        }else{
            jumlahItem-=jumlahTiapItem.get(index - 1);
            jumlahTiapItem.remove(index - 1);
            listInventory.remove(index -1);
        }
        JOptionPane.showMessageDialog(null, "Item berhasil dihapus dari inventory", "Delete Success", JOptionPane.PLAIN_MESSAGE);
        System.out.println("Item berhasil dihapus dari inventory");
    }

// mencari item berdasarkan indeks setelah memanggil method showInventory
    public SkillItem getItemByIdxShowInventory(int index)
    {
        return listInventory.get(index - 1);
    }


//    tampilkan isi inventory
    public void showInventory()
    {
        for (int i = 0; i < listInventory.size() ; i++)
        {
            System.out.println(Integer.toString(i + 1) +". "+ listInventory.get(i)+"/Qty:" + jumlahTiapItem.get(i));
        }
    }
// learn skill item berdasarkan index setelah memanggil method showInventory
    public void learnSkillItem(SkillItem skillItem, Engimon engi){
        int index = getIndex(skillItem);
        boolean learn =listInventory.get(index).learn(engi);
        if (learn)
        {
            deleteItemByIdx(index + 1,1);
            JOptionPane.showMessageDialog(null, "Berhasil dipelajari skill " + skillItem.getSkill().getName(), "Learn Success", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private int getIndex(SkillItem skillItem) {
        for (int i = 0; i < listInventory.size(); i++) {
            if (listInventory.get(i).getSkill().getName().equals(skillItem.getSkill().getName())) {
                return i;
            }
        }

        return -1;
    }

    public List<SkillItem> getSkillList()
    {
        return this.listInventory;
    }

    public List<Integer> getJumlahTiapItem() { return this.jumlahTiapItem;}
}
