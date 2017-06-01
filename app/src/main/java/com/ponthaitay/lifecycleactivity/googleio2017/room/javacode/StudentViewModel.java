package com.ponthaitay.lifecycleactivity.googleio2017.room.javacode;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class StudentViewModel extends ViewModel {

    private MutableLiveData<List<StudentEntity>> mutableLiveData;

    void insertStudent(final StudentDao dao, final StudentEntity entity) {
        Observable.empty()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        dao.insertStudent(entity);
                    }
                });
    }

    LiveData<List<StudentEntity>> getStudentById(StudentDao dao, int id) {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            dao.queryStudent(id).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<StudentEntity>>() {
                        @Override
                        public void accept(List<StudentEntity> studentEntities) throws Exception {
                            mutableLiveData.setValue(studentEntities);
                        }
                    });
        }

        return mutableLiveData;
    }

}