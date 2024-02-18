package com.example.test

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    val stringObservable : Observable<String> = Observable.just("Hello Message","Hello Message","Hello Message","Hello Message","Hello Message")
//    val intObservable  = Observable.just(1,2,3,4,5,6,7,8,9,10)

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    val iterNum = listOf<Int>(1,2,3,4)
    val intObservable = Observable.just(numbers)
    val numberObservable = Observable.fromArray(numbers)
    val iterateWay = Observable.fromIterable(iterNum)

    val customObervable = Observable.create {emitter ->
        emitter.onNext("Hello")
        emitter.onNext("Hello1")
        emitter.onNext("Hello2")
        emitter.onNext(4)
        emitter.onNext(true)
        emitter.onComplete()
    }

    val rangeObservable = Observable.range(1, 10)

    rangeObservable.subscribeBy {
        println(it)
    }

    val compositeDisposable = CompositeDisposable()

    compositeDisposable.add(
        rangeObservable.subscribeBy {
            println(it)
        }
    )

    compositeDisposable.add(
        intObservable.subscribeBy {
            println(it)
        }
    )

    val disposable = stringObservable.subscribeBy(
        onNext = {
                 println("onNext $it")
        },
        onComplete = {
            println("onOnComplete")
        },
        onError = {
            println("onError ${it.message}")
        }
    )

    compositeDisposable.dispose()
    disposable.dispose()

}