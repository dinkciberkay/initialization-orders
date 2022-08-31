package calismalar;

public class Test7 {

    /**
     * Bu aşamada da nesne oluşturma işlemleri sırasını inceleyelim.
     * Örnekte görüldüğü gibi instance yapılar var. Instance variable ve instance initialization blocks
     * ClassG g; işlemi ile önceki örneklerde de ele almıştık. initialization blokları tetiklenmeyecektir
     * <p>
     * Ancak; ClassG g = new ClassG(); ile nesne oluşturma işlemi yaptığımızda;
     * static hiçbir yapı olmadığı için nesneyle alakalı tüm yapılar: instance init blocks ve instance variable'lar yukarıdan aşağıya doğru initialize edilecektir.
     * <p>
     * Art arda iki tane bu objeden oluşturmak istersek bu işlemler art arda iki defa tekrarlanacak.
     * Her obje oluşturma işlemlerinde yine yine gerçekleştirilir.
     * <p>
     * new ClassG().printInfo() dersek de yine Nesne oluşturma işlemi içindeki işlemler çalışır ve sonra print info metodu da tetiklenir. (new ClassG() nesne oluşturma işlemi zaten)
     */


    public static void main(String[] args) {
//        ClassG g; //Hiçbir şey yazılmayacak.
        ClassG g1 = new ClassG(); // bu aşamada nesne olusturuyoruz.
        System.out.println("***************************************");
        ClassG g2 = new ClassG(); // bu aşamada nesne olusturuyoruz.
        System.out.println("***************************************");
        new ClassG().printInfo(); // Nesne oluşturma işlemi içindeki işlemler çalışır ve sonra print info metodu da tetiklenir.


    }

}

class ClassG {
    int i = 5;
    double d;
    String name;

    {
        System.out.println("In {}-1 (1.instance init block)");
        System.out.println("i: " + i);
    }

    {
        System.out.println("In {}-2 (2.instance init block)");
        System.out.println("d'nin initial degeri: " + d);
        d = Math.random() * 10;
        System.out.println("d'nin yeni degeri: " + d);
    }

    {
        System.out.println("In {}-3 (3.instance init block)");
    }

    public ClassG() {
        this("ClassG");
        System.out.println("\nClassG() constructor icerisindeyiz..");
        System.out.println("d'nin degeri: " + d);
        d = Math.random() * 10;
        System.out.println("d'nin yeni degeri: " + d);
    }

    public ClassG(String name) {
        this.name = name;
        System.out.println("\nClassG(String name) constructor icerisindeyiz");
        System.out.println("d'nin degeri: " + d);
        d = Math.random() * 10;
        System.out.println("d'nin yeni degeri: " + d);
    }

    void printInfo() {
        System.out.println("\nInfo");
        System.out.println("i: " + i + " | d: " + d + " | name:" + name);
    }
}
