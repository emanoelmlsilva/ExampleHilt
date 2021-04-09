package com.example.myapplication.database;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.requery.Persistable;
import io.requery.reactivex.ReactiveEntityStore;;

@Singleton
public class IceCreamDataStore {

    String[] listFlavorOne = {"Maçã", "Abacate", "Mel", "Banana", "Framboesa", "Baunilha", "Hortelã", "Mirtilo", "Cereja", "Uva", "Limão", "Abacaxi", "Manga", "Morango", "Coco"};
    String[] listFlavorTow = {"Chiclete", "Chocolate", "Massa de Biscoito", "Algodão Doce", "Menta", ""};
    String[] listSyrup = {"Caramelo", "Chocolate", "Morango", "Leite em Pó", "Caramelo Salgado", "Limão", "Leite Condensado", "Menta", "Marshmallow"};
    String[] listML = {"250ML", "500ML"};

    public ReactiveEntityStore<Persistable> dataStore;

    @Inject
    public IceCreamDataStore(ReactiveEntityStore<Persistable> dataStore){
        this.dataStore = dataStore;
    }

    private IceCreamDAOEntity createIceCream(){
        Random random = new Random();
        IceCreamDAOEntity iceCreamDAOEntity = new IceCreamDAOEntity();
        String flavorOne = listFlavorOne[random.nextInt(listFlavorOne.length)];
        String flavorTow = listFlavorTow[random.nextInt(listFlavorTow.length)];
        String syrup = listSyrup[random.nextInt(listSyrup.length)];
        iceCreamDAOEntity.setFlavorOne(flavorOne);
        iceCreamDAOEntity.setFlavorTow(flavorTow);
        iceCreamDAOEntity.setSyrup(syrup);
        iceCreamDAOEntity.setML(listML[random.nextInt(listML.length)]);
        iceCreamDAOEntity.setPrice((float) random.nextInt(40));
        return iceCreamDAOEntity;
    }

    public List<IceCreamDAOEntity> getListIceCream(){
        return dataStore.select(IceCreamDAOEntity.class).get().toList();
    }

    public void insertIceCream(){
        IceCreamDAOEntity iceCreamDAOEntity = createIceCream();
        dataStore.insert(iceCreamDAOEntity).subscribe();
    }

    public void deleteIceCream(IceCreamDAOEntity iceCreamDAOEntity){
        dataStore.delete(iceCreamDAOEntity).subscribe();
    }
}
