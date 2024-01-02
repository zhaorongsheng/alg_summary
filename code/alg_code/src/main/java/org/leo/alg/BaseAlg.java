package org.leo.alg;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/2 19:42
 * @Version 1.0
 */
public abstract class BaseAlg {
    protected abstract void prepare();

    protected abstract void run();

    public void start() {
        System.out.println("Begin run alg: " + this.getClass().getSimpleName());
        this.prepare();
        this.run();
    }

    protected void print(Object o) {
        if (o == null) {
            System.out.print("NULL");
        } else {
            System.out.print(o);
        }
    }

    protected void println(Object o) {
        if (o == null) {
            System.out.println("NULL");
        } else {
            System.out.println(o);
        }
    }


}
