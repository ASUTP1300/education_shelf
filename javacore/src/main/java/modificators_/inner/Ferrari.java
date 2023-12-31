package modificators_.inner;

import modificators_.Car;

  class Ferrari extends Car {
      protected String name;

      public static void main(String[] args) {
          Жигули жигули = new Жигули();
          System.out.println(жигули.name);
      }
}

 class  Жигули extends Ferrari{
     public Жигули() {
         super();
         name = "Жига";
     }
 }
