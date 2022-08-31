package calismalar;

public class Test6 {

    /**
     * Bu örnekte de ClassF nin sabit değişkeni olan CONSTANT a ulaşmak isteyelim
     * Not : Sabit değişken final keyword ile kullanılan primitive veya String alanlardır.Boş olarak tanıtılamaz. İlk değer ataması yapılmak zorunludur.
     * Burada sadece Selam initialize edildi! Diğer static alanların initalize edilmesine gerek yok. Sabit değişkene erişiyoruz.
     */

    public static void main(String[] args) {

        System.out.println(ClassF.CONSTANT);

    }
}

class ClassF {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassF() {
        System.out.println("\nClassF() Baslatiliyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassF() Bitiriliyor...");
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