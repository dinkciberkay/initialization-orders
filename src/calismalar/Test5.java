package calismalar;

public class Test5 {

    public static void main(String[] args) {

        /**
         * Burası önemli; nesnesini oluşturarak deneyelim. !!
         * Önce static yapılar initialize edilecek
         * Sonra instance yapılar initialize edilecek
         * En sonda da constructor çağrısı olacak !!!! (Nesne olusturulmadan constructor çağrısı olamaz..)
         * <p>
         * Bu örnekte, instance variable yok. sadece static imitialization yapıyor su anda.
         * Bunların aralarına instance variable ve instance initialization blokları koyarak constructor'dan önce, static initializationlardan sonra
         * onların initialization olduğunu göreceğiz. !!!!
         * <p>
         *
         */

        new ClassE();

    }
}

class ClassE {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassE() {
        System.out.println("\nClassE() Baslatiliyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassE() Bitiriliyor...");
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
