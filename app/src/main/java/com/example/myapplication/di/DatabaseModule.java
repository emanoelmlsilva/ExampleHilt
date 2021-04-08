package com.example.myapplication.di;

import android.content.Context;
import com.example.myapplication.database.Models;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import io.requery.Persistable;
import io.requery.android.BuildConfig;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.reactivex.ReactiveEntityStore;
import io.requery.reactivex.ReactiveSupport;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;
import io.requery.sql.TableCreationMode;

@InstallIn(SingletonComponent.class)
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    public ReactiveEntityStore<Persistable> prevideDatabase(@ApplicationContext Context context){
        DatabaseSource source = new DatabaseSource(context, Models.DEFAULT, 1);
        if(BuildConfig.DEBUG){
            source.setTableCreationMode(TableCreationMode.DROP_CREATE);
        }
        Configuration configuration = source.getConfiguration();
        return ReactiveSupport.toReactiveStore(new EntityDataStore<Persistable>(configuration));
    }

}
