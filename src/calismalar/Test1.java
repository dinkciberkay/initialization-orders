package calismalar;

public class Test1 {

    /**
     * Burada hiçbir şeyi çıktı olarak göstermeyecektir. Sadece ClassA'ya ulaştık.
     * Nesnesini oluşturmadık. Instance initializer blokları ya da constructor'lar zaten çagırılmayacak.
     * Class ile alakalı da hiçbir statik yapıya da ulaşmayız.
     * <p>
     * (Sınıfın nesnesinin olusturulması,
     * Sınıfın static methodunu çagırmak
     * Static bir alana atama yapmak ya da kullanmak
     * <p>
     * Bu işlemler, sınıfın static üyesine ulaşmak, nesnesini olusturmak veya constructor çagırmak,
     * sınıfın yüklenmesini, hazırlanıp başlatılmasını saglar. Burada    bu işlemlerden herhangi biri yapılmıyor.
     */

    public static void main(String[] args) {
        ClassA a;
    }
}

class ClassA {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassA() {
        System.out.println("\nClassA() Başlatılıyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassA() Bitiriliyor...");
    }

    static void printInfo() {
        System.out.println("\nInfo..");
        System.out.println("i: " + i + " d1: " + d1 + " d2: " + d2);
    }

    private static double d2;

    static {
        System.out.println("d2 'nin initial degeri : " + d2);
        d2 = Math.random() * 100;
        System.out.println("d2 'nin yeni değeri : " + d2);
    }

    public static final String CONSTANT = "Selam";

    static {
//        CONSTANT = "selaam"; // YAPILAMAZ ÇÜNKÜ BU BİR SABİT DEĞİŞKEN. değerine ulaşıldığı zaman initialize edildiği için
//      static init içerisinde initialize edilemeeezz!!
        System.out.println("Constant : " + CONSTANT);
    }

    private static String init() {
        System.out.println("in init()");
        return "55";
    }



}
