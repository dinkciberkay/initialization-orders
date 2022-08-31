package calismalar;

public class Test3 {
    /**
     * Burada da ClassC'nin static metoduna erişmek istesek.
     * Test2 deki gibi aynı şeyler initialize edildi. Sonrasında init metodu çağırıldı.
     */

    public static void main(String[] args) {
        ClassC.init();
    }
}

class ClassC {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassC() {
        System.out.println("\nClassC() Başlatılıyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassC() Bitiriliyor...");
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

    public static String init() {
        System.out.println("in init()");
        return "55";
    }

}
