package calismalar;

public class Test2 {

    /**
     * Burada da ClassB 'nin static variable'ı olan i değişkenine ulaşıyoruz.
     * Sadece 5 yazmasını beklerken class yüklendi ve ilk değer atamaları (initialization) yapıldı.
     * static başlatma bloğu içerisideki işlemleri de çalıştırdı doğal olarak.
     * ilk değer ataması 0 olacaktır.
     * sonrasında d1'e random atama yapıldı blok içerisinde.
     * constructor çalışmadı !!. nesne oluşturulmadı çünkü.
     * sonrasında aşağı doğru diğer static initializer block çalıştı d2'nin de ilk değer ataması 0 olarak yapıldı.
     * sonrasında d2'ye de random bir değer atandı blok içerisinde.
     * ardından diğer static bloğun içerisinde Selam yazdırdı.
     * en son da i'nin değerini main içerisinde sout ettirdiğimiz için 5 yazdırdı.
     * (ilk baştaki 5 te integer i'ye değer ataması yapılıp static blokta sout ettirdik)
     * Eğer biz bir değer atamasaydık (double olan d1 değişkeni gibi) ilk baştaki static blokta da sout ederken 0 basacaktı. int initialize value 0 çünkü.
     * sonraki static bloklarda bir değer ataması yapsaydık en son o verdiğimiz değeri main içerisinde çağırdığımız ClassB.i kısmında yazacaktı.
     */

    public static void main(String[] args) {
        System.out.println(ClassB.i);
    }
}

class ClassB {
    static int i = 5;
    private static double d1;

    static {
        System.out.println("i: " + i);
        System.out.println("d1'in initial degeri: " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1 in yeni degeri : " + d1);
    }

    public ClassB() {
        System.out.println("\nClassB() Başlatılıyor..\n");
        System.out.println("d1'in degeri : " + d1);
        d1 = Math.random() * 10;
        System.out.println("d1'in yeni degeri : " + d1);

        System.out.println("d2'nin degeri :" + d2);
        d2 = Math.random() * 100;
        System.out.println("d2'nin yeni degeri : " + d2);
        System.out.println("ClassB() Bitiriliyor...");
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
