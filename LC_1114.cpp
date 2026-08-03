class Foo {
private:
    mutex mtx;
    condition_variable cv;
    int state;

public:
    Foo() {
        state = 0;
    }

    void first(function<void()> printFirst) {
        printFirst();

        unique_lock<mutex> lock(mtx);
        state = 1;
        cv.notify_all();
    }

    void second(function<void()> printSecond) {
        unique_lock<mutex> lock(mtx);

        cv.wait(lock, [this] {
            return state >= 1;
        });

        printSecond();

        state = 2;
        cv.notify_all();
    }

    void third(function<void()> printThird) {
        unique_lock<mutex> lock(mtx);

        cv.wait(lock, [this] {
            return state >= 2;
        });

        printThird();
    }
};
