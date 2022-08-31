package calismalar;

public class Test4 {

    /**
     * Burada da önce ClassD nin static bir instance'ını çağırıp sonra metodunu çağıralım
     * ClassD nin static variable'ını okumak için zaten bir initialize işlemi yapılacak. Sonrasında init() metodu için
     * tekrar yapmaya gerek kalmayacaktır. O yüzden initialize işlemindeki işlemleri bir kere yapacaktır.
     * <p>
     * Önemli bir örnek olarak da; printInfo() metodunu da çağıralım. Yine aynı şekilde tek bir initialize olacaktır.
     * Buradaki önemli nokta printInfo() metodu içerisinde d2ye değer ataması yok ve sout şeklinde direkt yazdırılıyor.
     * Static init blok çalışıp orada değer ataması yaptığı için d2 yi dolu bir şekilde printInfo metodunda yazdırıyor.
     */

    public static void main(String[] args) {
        System.out.println(ClassD.i);

        ClassD.init();

        ClassD.printInfo();
    }
}

class ClassD {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassD() {
        System.out.println("\nClassD() Başlatılıyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassD() Bitiriliyor...");
    }

    static void printInfo() {
        System.out.println("\nInfo..");
        System.out.println("i: " + i + " d1: " + d1 + " d2: " + d2);
    }

    private static double d2;

    static {
        System.out.println("d2 'nin initial degeri : " + d2);
        d2 = Math.random() * 100;
        System.out.println("d2 'nin yeni degeri : " + d2);
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
