package syntax.innerclass;

class Outer {
  private int age = 20;
  public void method() {
      final int age2 = 30;
      Object obj = new Object();
      class Inner {
          public void show() {
              System.out.println(age);
              //从内部类中访问方法内变量age2，需要将变量声明为最终类型。
              System.out.println(age2);
              System.out.println(obj);
          }
      }
      Inner i = new Inner();
      i.show();

//      obj = new StringReader();
  }
}