import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestRxJava {

    public static void main(String[] args) {

        System.out.println("--- window ---");
        Observable.range(1, 5).window(3).subscribe(s -> {
            System.out.println("next window ");
            s.subscribe(i -> System.out.println("items in window" +i));
        });

        System.out.println("--- take ---");
        Observable.range(1, 5).take(3)
                .subscribe(s -> {
                    System.out.println("" + s);
                });

        System.out.println("--- Flowable ---");
        Flowable<Integer> observable = Flowable.range(1, 133);
        observable.subscribe(new DefaultSubscriber<Integer>() {
            @Override public void onStart() {
                request(1);
            }
            @Override public void onNext(Integer t) {
                System.out.println("" + t);
                request(1);
            }
            @Override public void onError(Throwable t) {
                System.out.println("" + t);
            }
            @Override public void onComplete() {
                System.out.println("complete");
            }
        });

        System.out.println("--- Cold observable ---");
        Observable.range(1, 11)
                .observeOn(Schedulers.computation())
                .subscribe(Subscribers::compute);


        System.out.println("--- MissingBackpressureException ---");
        PublishSubject<Integer> source = PublishSubject.<Integer>create();
        source
                .observeOn(Schedulers.computation())
                .subscribe(Subscribers::compute, Throwable::printStackTrace);
        IntStream.range(1, 100).forEach(source::onNext);


        System.out.println("--- Buffering Overproducing Observable ---");
        PublishSubject<Integer> source1 = PublishSubject.<Integer>create();
        source1
                .buffer(1024)
                .subscribe(Subscribers::compute, Throwable::printStackTrace);

        IntStream.range(1, 100_000).forEach(source1::onNext);

        System.out.println("--- Skipping Elements ---");
        PublishSubject<Integer> sourceSkipping = PublishSubject.<Integer>create();
        sourceSkipping
                .sample(10, TimeUnit.MILLISECONDS)
                .throttleFirst(10, TimeUnit.MILLISECONDS)
                .subscribe(Subscribers::compute, Throwable::printStackTrace);
        IntStream.range(1, 100_000_0000).forEach(sourceSkipping::onNext);


        System.out.println("--- Flowable ---");
        Flowable.range(1, 1_000_000)
                .observeOn(Schedulers.computation())
                .subscribe(Subscribers::compute, Throwable::printStackTrace);

        Flowable.range(1, 1_000_000)
                .subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    public void onStart() {
                        request(1);
                    }

                    public void onNext(Integer v) {
                        Subscribers.compute(v);

                        request(1);
                    }

                    @Override
                    public void onError(Throwable ex) {
                        ex.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Subscribers {

    public static void compute(Integer v) {
        try {
            System.out.println("" + v);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void compute(List<Integer> integers) {
        try {
            System.out.println("" + integers);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void compute(Observable<Integer> integerObservable) {
        integerObservable.subscribe(s -> {
            System.out.println("" + s);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
