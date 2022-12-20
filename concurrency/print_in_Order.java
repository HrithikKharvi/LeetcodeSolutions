class Foo {

    String s1 = "";
    String s2 = "";
    String s3 = "";
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.

          printFirst.run();
          this.s1 = "first";
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
          while(this.s1 == "")Thread.sleep(1);
        printSecond.run();
        s2 = "second";
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
          while(this.s2 == "")Thread.sleep(1);
          printThird.run();
    }
}
