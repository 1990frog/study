class InnerClassThis {
  public int age = 18;    
  class Inner {
      public int age = 20;    
      public void showAge() {
          int age  = 25;
          System.out.println(age);//空1
          System.out.println(this.age);//空2
          System.out.println(InnerClassThis.this.age);//空3
      }
  }
}