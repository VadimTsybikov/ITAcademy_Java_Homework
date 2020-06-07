package operators;

public class OperatorsMain1 {
    public static void main(String[] args) {
        System.out.println("Битовые операции с положительными операндами:");

        byte a1 = 42;                                       //0010_1010 = 42
        byte b1 = 15;                                       //0000_1111 = 15

        byte a1_inv = (byte)~a1;                            //1101_0101 = -43
        System.out.printf("НЕ: ~%d = %d\n", a1, a1_inv);

        byte b1_inv = (byte)~b1;                            //1111_0000 = -16
        System.out.printf("НЕ: ~%d = %d\n", b1, b1_inv);

        byte x1_2 = (byte)(a1 | b1);                        //0010_1111 = 47
        System.out.printf("ИЛИ: %d | %d = %d\n", a1, b1, x1_2);

        byte x1_1 = (byte)(a1 & b1);                        //0000_1010 = 10
        System.out.printf("И: %d & %d = %d\n", a1, b1, x1_1);

        byte x1_3 = (byte)(a1 ^ b1);                        //0010_0101 = 37
        System.out.printf("Исключающее ИЛИ: %d ^ %d = %d\n", a1, b1, x1_3);

        byte x1_4 = (byte)(a1 >> b1);                       //0000_0000 = 0
        System.out.printf("Сдвиг вправо: %d >> %d = %d\n", a1, b1, x1_4);

        byte x1_5 = (byte)(a1 << b1);                       //0000_0000 = 0
        System.out.printf("Сдвиг влево: %d << %d = %d\n", a1, b1, x1_5);

        byte x1_6 = (byte)(a1 >>> b1);                      //0000_0000 = 0
        System.out.printf("Сдвиг вправо без сохранения знака: %d >>> %d = %d\n", a1, b1, x1_6);

        System.out.println("Битовые операции с присваиванием:");
        byte x1_7 = 0;                                      //0000_0000 = 0
        System.out.printf("N = %d\n", x1_7);
        x1_7 |= a1;                                         //0010_1010 = 42
        System.out.printf("N |= %d; N = %d\n", a1, x1_7);
        x1_7 &= b1;                                         //0000_1010 = 10
        System.out.printf("N &= %d; N = %d\n", b1, x1_7);
        x1_7 ^= b1;                                         //0000_0101 = 5
        System.out.printf("N ^= %d; N = %d\n", b1, x1_7);
        x1_7 >>= b1;                                        //0000_0000 = 0
        System.out.printf("N >>= %d; N = %d\n", b1, x1_7);
        x1_7 <<= b1;                                        //0000_0000 = 0
        System.out.printf("N <<= %d; N = %d\n", b1, x1_7);
        x1_7 >>>= b1;                                       //0000_0000 = 0
        System.out.printf("N >>>= %d; N = %d\n", b1, x1_7);

        System.out.println("\nБитовые операции с отрицательными операндами:");

        byte a2 = -42;                                      //1101_0110 = -42
        byte b2 = -15;                                      //1111_0001 = -15

        byte a2_inv = (byte)~a2;                            //0010_1001 = 41
        System.out.printf("НЕ: ~%d = %d\n", a2, a2_inv);

        byte b2_inv = (byte)~b2;                            //0000_1110 = 14
        System.out.printf("НЕ: ~%d = %d\n", b2, b2_inv);

        byte x2_2 = (byte)(a2 | b2);                        //1111_0111 = -9
        System.out.printf("ИЛИ: %d | %d = %d\n", a2, b2, x2_2);

        byte x2_1 = (byte)(a2 & b2);                        //1101_0000 = -48
        System.out.printf("И: %d & %d = %d\n", a2, b2, x2_1);

        byte x2_3 = (byte)(a2 ^ b2);                        //0010_0110 = 39
        System.out.printf("Исключающее ИЛИ: %d ^ %d = %d\n", a2, b2, x2_3);

        byte x2_4 = (byte)(a2 >> b2);                       //1000_0000 = -1
        System.out.printf("Сдвиг вправо: %d >> %d = %d\n", a2, b2, x2_4);

        byte x2_5 = (byte)(a2 << b2);                       //0000_0000 = 0
        System.out.printf("Сдвиг влево: %d << %d = %d\n", a2, b2, x2_5);

        byte x2_6 = (byte)(a2 >>> b2);                      //1000_0000 = -1
        System.out.printf("Сдвиг вправо без сохранения знака: %d >>> %d = %d\n", a2, b2, x2_6);

        System.out.println("Битовые операции с присваиванием:");
        byte x2_7 = 0;                                      //0000_0000 = 0
        System.out.printf("N = %d\n", x2_7);
        x2_7 |= a2;                                         //1101_0110 = -42
        System.out.printf("N |= %d; N = %d\n", a2, x2_7);
        x2_7 &= b2;                                         //1101_0000 = -48
        System.out.printf("N &= %d; N = %d\n", b2, x2_7);
        x2_7 ^= b2;                                         //0010_0001 = 33
        System.out.printf("N ^= %d; N = %d\n", b2, x2_7);
        x2_7 >>= b2;                                        //0000_0000 = 0
        System.out.printf("N >>= %d; N = %d\n", b2, x2_7);
        x2_7 <<= b2;                                        //0000_0000 = 0
        System.out.printf("N <<= %d; N = %d\n", b2, x2_7);
        x2_7 >>>= b2;                                       //0000_0000 = 0
        System.out.printf("N >>>= %d; N = %d\n", b2, x2_7);
    }
}