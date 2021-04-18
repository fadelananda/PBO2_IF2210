package entities;

import java.util.List;

public class Inventory<T> {
    private static final int MAX_INVENTORY = 10;
    private List<T> listInventory;
    private static int jumlahItem = 0;
    public void addItem(T item)
    {
        if (jumlahItem < MAX_INVENTORY)
        {
            System.out.println("Berhasil ditambahkan!");
            listInventory.add(item);
            jumlahItem++;
        }else{
            System.out.println("Inventory sudah penuh");
        }
    }

    public void deleteItemByIdx(int index)
    {
        listInventory.remove(index);
        jumlahItem--;
        System.out.println("Item berhasil dihapus dari inventory");
    }

//    //delete item by type T
//    void deleteItem(T item){
//        auto it = find_if( listInventory.begin(), listInventory.end(),
//                [&](T& element){ return element == item;} );
//
//        if (it != listInventory.end())
//        {
//            listInventory.erase(it);
//            jumlahItem--;
//        }else{
//            cout<< item <<" tidak ditemukan di dalam inventory" << endl; //harus ada ostream dulu pada kelas yang menjadi type data
//        }
//    }

//    // mencari item berdasarkan indeks saat isi inventory ditampilkan
    public T getItemByIdxShowInventory(int index)
    {
        return listInventory.get(index);
    }

//    //tampilkan isi inventory
    public void showInventory()
    {
        int count = 0;
        listInventory.forEach(s -> System.out.println(s));
    }

    public int getCapacity()
    {
        return listInventory.size();
    }


//    T getItemByIdx(int index) {
//        if (index < jumlahItem) {
//            return this->listInventory[index];
//        } else {
//            throw "Index Tidak Benar!";
//        }
//    }

//    int getIdxByItem(T item) {
//        int index = 0;
//        class vector <T> :: iterator it;
//        for(it = listInventory.begin(); it != listInventory.end(); ++it){
//            if (*it == item) {
//                return index;
//            } else {
//                ++index;
//            }
//        }
//    }

//    //get Engimon
//    Engimon getEngimon(int idxEngimon){
//        if(idxEngimon < MAX_INVENTORY)
//            return this->listInventory[idxEngimon];
//        else
//        throw "Tidak ada engimon";
//    }

//    Engimon* getEngimonPoint(int idxEngimon){
//        if(idxEngimon < MAX_INVENTORY)
//            return &listInventory[idxEngimon];
//        else
//        throw "Tidak ada engimon";
//    }

//    template <>
//    class Inventory <Skill_Item>
//    {
//        private:
//        vector<pair<Skill_Item, int>> listInventory;
//        public:
//
//        //add skill item dengan jumlah tertentu ke bag skill
//        void addItem(Skill_Item skillItem , int jumlah){
//            if (jumlahItem < MAX_INVENTORY)
//            {
//                // vector<pair<Skill_Item, int>>::iterator it;
//                auto it = find_if( listInventory.begin(), listInventory.end(),
//                        [&](pair<Skill_Item, int>& element){ return element.first == skillItem;} );
//                int index = std::distance(listInventory.begin(), it);
//
//                if (it != listInventory.end()){
//                    listInventory[index].second += jumlah;
//                }else{
//                    listInventory.push_back(make_pair(skillItem, jumlah));
//                }
//                cout<< jumlah<< " "<<skillItem.getSkill().getSkillName() <<" berhasil ditambahkan ke inventory" << endl;
//                jumlahItem+=jumlah;
//            }else{
//                cout<< "Inventory sudah penuh" << endl;
//            }
//        }
//
//        //delete skill item berdasarkan indeks saat di show inventory dengan jumlah tertentu
//        void deleteItemByIdx(int index,int jumlah){
//            vector<pair<Skill_Item, int>>::iterator iter = listInventory.begin() + index - 1;
//            if (listInventory[index - 1].second > jumlah)
//            {
//                jumlahItem-=jumlah;
//                listInventory[index -1].second -= jumlah;
//            }else{
//                jumlahItem-=listInventory[index - 1].second;
//                listInventory.erase(iter);
//            }
//        }
//
//        //delete item berdasarkan skillitem dengan jumlah tertentu
//        void deleteItem(Skill_Item skillItem,int jumlah){
//            auto it = find_if( listInventory.begin(), listInventory.end(),
//                    [&](pair<Skill_Item, int>& element){ return element.first == skillItem;} );
//
//            int index = std::distance(listInventory.begin(), it);
//            if (it != listInventory.end())
//            {
//                if (listInventory[index].second > jumlah)
//                {
//                    jumlahItem-=jumlah;
//                    listInventory[index].second -= jumlah;
//                }else{
//                    jumlahItem-=listInventory[index].second;
//                    listInventory.erase(it);
//                }
//            }else{
//                cout<< skillItem.getSkill().getSkillName() <<" tidak ditemukan di dalam inventory" << endl;
//            }
//        }
//
//        //learnskill item
//        void learnSkillItem(int index, Engimon engi){
//            bool learn = listInventory[index - 1].first.learn(&engi);
//            if (learn)
//            {
//                deleteItem(listInventory[index - 1].first,1);
//                jumlahItem--;
//            }
//
//
//        }
//        int getCapacity(){
//            return listInventory.size();
//        }
//        //menampilkan isi inventory
//        void showInventory()
//        {
//            cout<<"   Nama : Qty\n";
//            int count = 0;
//            for (auto iter : listInventory) {
//                cout <<++count << ". "<< iter.first.getSkill().getSkillName() << " : " << iter.second<< "\n";
//            }
//        }
    }
