package by.bstu.sinjakkirill.basejava.laba_3;
import static java.lang.Math.*;

/**
 * Created by Sinyak Kirill on 19.09.2016.
 */
public class JavaTestTepy {

    static int sint;
    final int  _int1 = 1;
    public final int _int2 = 2;
    public static  final int _int3 = 3;

    public static void main(String[] args) {

        char _char = 'k';
        int _int = 99;
        short _short  = 66;
        byte _byte = 127;
        long _long = 9999;
        boolean _boolean = false;
        String _string = "Hello world!";
        double _double = 12.99;
        char _char1 = 'a';
        char _char2 = '\u0061';
        char _char3 = 97;

        System.out.println("Strint + int: " + _string + " + " + _int + " = " + (_string + _int));
        System.out.println("String + char: " + _string + " + " + _char + " = " + (_string + _char));
        System.out.println("String + double: " + _string + " + " + _double + " = " + (_string + _double));
        System.out.println("byte  = byte + int: " + "Incompatible types!");
        System.out.println("int = double + long: " + "Incompatible types!");
        System.out.println("long = int + 2147483647: " + (_long = _int + 2147483647));
        System.out.println("Вывод значения без инициализации: " + sint);
        System.out.println("boolean = boolean && boolean: " + _boolean + " && " + (_boolean = _boolean && _boolean));
        System.out.println("boolean= boolean ^ boolean: "  + _boolean + " ^ " + (_boolean = _boolean ^ _boolean));
        System.out.println("Типы для 9223372036854775807 - " + "long");
        System.out.println("Типы для 0x7fff_ffff_fff - " + "long");
        System.out.println("'a' - " + _char1 + ";   '/u0061' - " + _char2 + ";   97 - " + _char3);
        System.out.println("'a' + '/u0061' + 97 = " + "Incompatible types!");
        System.out.println("3.45 % 2.4 = " +  3.45 % 2.4 );
        System.out.println("1.0/0.0 = " + 1.0/0.0);
        System.out.println("log(-345) = " + log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);
        System.out.println("Math.round(Math.PI) = " + Math.round(Math.PI));
        System.out.println("Math.round(Math.E) = " + Math.round(Math.E));
        System.out.println("Math.min(Math.PI,Math.E) = " + Math.min(Math.PI,Math.E));
        System.out.println("");
        System.out.println("");
    }
}
