package calismalar;

public class Z_InitializationOrder {

    /**
     * Karmaşık ve çok güzel bir örnek,
     * <p>
     * <p>
     * önce static kısımlar initialize edilecek demiştik
     * önce i initialize edilecek, sonra a initialize edilecek. Ama A classının a nesnesi initailize edilmesi demek A'nin yüklenmesi ve nesnesinin olusturulması demektir.
     * A'nın yüklenmesi sırasında A'nın static kısımları yüklenecek burada şu anda Anın static kısmı yok. Sonra A'nın nesnesi oluşturulmadan önce instance variable yüklenecek. var mı ? var.
     * yani c oluşturulacak. C 'nin olusturulması için C yüklenecek. Cnin static field'ları yüklenecek. Var mı? var. B'nin objesi için B yüklenecek. B yüklensin. Constructor çağrısı yapıldı geriye geldik.
     * C deyiz. C nin constructor çağrısı yapıldı ve in C() yazdık. ordan çıkıp A ya geri geldik. (önce fieldlar sonra constructorlar tabii) şimdi A nın constructor'ındayız in A() bastık.
     * <p>
     * sadece A a = new A() için bu işlemleri yaptık
     * <p>
     * devamında, C c =new C() static değil. statikler öncelikli.. ints array static. initialize edilir. sonrasında static init blok var o başladı. boolean array static değil henüz init edilmez.
     * instance init blok henüz init edilmedi. en sonda da d objesi oluşturulur. D nin oluşması için yine D ye girip static variable ve static init bloklar yüklenir. sonrasında constructor çağrılır ve d objesi oluşturuldu.
     * <p>
     * !!! DOLAYISIYLA main metotta InitializationOrder içindeki static bir field'a ulaşırsam eğer, sırasıyla bunları yapmak zorundayız. tüm static yapılar initialize edilecek !!!
     * Ayrıca önceki örneklerde main metot'un bulunduğu classta init blokları ve variable lar yoktu. BURADAKİ ÖRNEKTE MAİN METOTU BOŞ ÇALIŞTIRSAK BİLE class yüklenecek. class'a ait alanlar yüklenecek yanii!!!
     * instance variable ve instance init'ler nesneye ait!! dolayısıyla onların yüklenmesini bu aşamada beklemiyoruz. constructor da çağrılmaz bu aşamada nesne oluşturmuyoruz.
     * !!!
     */

    static int i = 13;
    String name;
    static A a = new A();

    public Z_InitializationOrder() {
        this("InitializationOrder1");
        System.out.println("InitializationOrder()");
    }

    public Z_InitializationOrder(String name) {
        this("InitializationOrder2", 5);
        System.out.println("in InitializationOrder(String name)");

    }

    public Z_InitializationOrder(String name, int i) {
        this.name = name;
        System.out.println("in InitializationOrder(String name, int i)");
    }


    C c = new C();

    static int[] ints = new int[10];

    static {
        System.out.println("Initializing the int array (STATIC INIT BLOCK)");
        for (int i = 0; i < ints.length; i++) ints[i] = i * 10;
    }

    boolean[] booleans = new boolean[10];

    {
        System.out.println("Initializing the boolean array (INSTANCE INIT BLOCK)");
        boolean x = false;
        for (int i = 0; i < booleans.length; i++) booleans[i] = !x;
    }

    public static final D d = new D();

    public static void main(String[] args) {
        System.out.println(Z_InitializationOrder.i); /* Örneğin*/
        System.out.println("************************");
    }

}

class A {
    public A() {
        System.out.println("in constructor A()");
    }

    C c = new C();
}

class B {
    public B() {
        System.out.println("in constructor B()");
    }

    public void printB() {
        System.out.println("in printB() function");
    }
}

class C {
    static B b = new B();

    public C() {
        System.out.println("in constructor C()");
    }

    static void printC() {
        System.out.println("in static method printC() function");
    }
}

class D {
    static int i;

    static {
        i = 65;
        System.out.println("i: " + i);
    }

    public D() {
        System.out.println("in constructor D()");
    }
}

