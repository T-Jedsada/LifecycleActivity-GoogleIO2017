package com.ponthaitay.lifecycleactivity.googleio2017.room.kotlincode

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EmployeeViewModel : ViewModel() {

    private var mutableStudentEntity: MutableLiveData<List<EmployeeEntity>>? = null

    fun insertStudent(dao: EmployeeDao?, entity: EmployeeEntity): Disposable = Observable.empty<Any>()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { dao?.insertEmployee(entity) }

    fun getStudentById(dao: EmployeeDao?, firstName: String?): LiveData<List<EmployeeEntity>> {
        mutableStudentEntity = MutableLiveData()
        dao?.queryEmployee(firstName)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { mutableStudentEntity?.value = it }
        return mutableStudentEntity as LiveData<List<EmployeeEntity>>
    }
}