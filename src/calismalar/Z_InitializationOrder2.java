package calismalar;

import java.util.Arrays;

public class Z_InitializationOrder2 {

    /**
     * Bir önceki önemli örneğe ek olarak bu örnekte de nesne oluşturmayı da ekleyelim.
     * Önceki kısımlar dahil olsun yani main içerisinde InitializationOrder ın i'sine erişmek isteyelim öncelikle.
     * Sonra da nesnesini oluşturalım.
     * Bu aşamada önceki yapılan işlemleri yine yapacak ek olarak nesne oluşturmaktan kaynaklanan;
     * nesne variable'ları ve nesne initialization block'ları çalışacak. (instance variable & instance initialization blocks)
     * Önce name'e null atanacak. sonra static'ler zaten işlemi önce görmüştü. c nesnesi oluşturulacak.
     * c'nin içinde static b var oluşturulacak mı? hayır. bir daha olusturulmasına gerek yok static yapının. öncesinde olusturulmustu.
     * static yapı sınıfın init sırasında bir kere olusturuldu zaten tekrar olusturulmaz. dolayısıyla in B() yazmayacak. STATİC YAZILMIŞ ÇÜNKÜ. STATİC OLMASAYDI ONA DA GİRMESİ GEREKİRDİ.
     * zaten yazmıştı. static i'ye ulaşmak istediğimizde init edilmişti.
     * sadece c'nin constructor call'u yapılacak. c nesnesi olusturulmak için. ve geri dönecek.
     * sonrasında instance block olan boolean array init edilecek.
     * sonrasında constructor call yapıldı InitializationOrder sınıfına ait. (öncesinde instance variable ve instance blockları init ettik.)
     * this() ile this() olmayana kadar en son constructora kadar gidip sırasıyla en başa kadar geri döner.
     */

    static int i = 13;
    String name;
    static AA a = new AA();

    public Z_InitializationOrder2() {
        this("InitializationOrder1");
        System.out.println("InitializationOrder()");
    }

    public Z_InitializationOrder2(String name) {
        this("InitializationOrder2", 5);
        System.out.println("in InitializationOrder(String name)");

    }

    public Z_InitializationOrder2(String name, int i) {
        this.name = name;
        System.out.println("in InitializationOrder(String name, int i)");
    }


    CC cc = new CC();

    static int[] ints = new int[10];

    static {
        System.out.println("Initializing the int array (STATIC INIT BLOCK)");
        for (int i = 0; i < ints.length; i++) ints[i] = i * 10;
    }

    boolean[] booleans = new boolean[10];

    {
        System.out.println("Initializing the boolean array (INSTANCE INIT BLOCK)");
        boolean x = false;
        Arrays.fill(booleans, !x);
    }

    public static final DD d = new DD();

    public static void main(String[] args) {
        System.out.println(Z_InitializationOrder2.i); /* Örneğin*/
        System.out.println("************************");
        Z_InitializationOrder2 io = new Z_InitializationOrder2();
    }
}

class AA {
    public AA() {
        System.out.println("in constructor A()");
    }

    CC c = new CC();
}

class BB {
    public BB() {
        System.out.println("in constructor B()");
    }

    public void printB() {
        System.out.println("in printB() function");
    }
}

class CC {
    static BB b = new BB();

    public CC() {
        System.out.println("in constructor C()");
    }

    static void printC() {
        System.out.println("in static method printC() function");
    }
}

class DD {
    static int i;

    static {
        i = 65;
        System.out.println("i: " + i);
    }

    public DD() {
        System.out.println("in constructor D()");
    }
}
