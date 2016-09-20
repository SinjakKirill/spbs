package by.bstu.sinjakkirill.basejava.laba_3;
import static java.lang.Math.*;

/**
 * Created by Sinyak Kirill on 19.09.2016.
 * @autor Sinjak Kirill
 * @version 1.0
 *
 */
public class JavaTestTepy {

    public class WrapperString{
        public WrapperString(String _string) {
            this._string = _string;
        }

        public String get_string() {
            return _string;
        }

        public void set_string(String _string) {
            this._string = _string;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrapperString that = (WrapperString) o;

            return _string != null ? _string.equals(that._string) : that._string == null;



        }

        @Override
        public int hashCode() {
            return _string != null ? _string.hashCode() : 0;
        }

        String _string = new String("hvksdnzkvws");

        public void replace (char oldchar, char newchar){
            for(int i = 0; i < _string.length(); i++){
                if(_string.charAt(i) == oldchar){
                    //_string.set(i, newchar);
                    System.out.println(newchar);
                }
                else{
                    System.out.println(oldchar);
                }
            }
        }

        class InnerClass{
            /*@Override
            public  void  replace(char oldchar, char newchar){

            }*/
        }
    }

    static int sint;
    final int  _int1 = 1;
    public final int _int2 = 2;
    public static  final int _int3 = 3;

    public static void main(String[] args) {

        /**
         * @return void
         * @throws
         * @param String[] args
         */

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

        //создание классов оболочек
        Integer _obInteger = new Integer("1234");
        Boolean _obBoolean = new Boolean(true);
        Character _obCharacter = new Character('9');
        Byte _obByte = new Byte("127");
        Short _obShort = new Short("444");
        Long _obLong = new Long("9999999");
        Double _obDouble = new Double("21.999");

        _obInteger += _obByte;
        System.out.println("Вывод _obByte после сдвига: " + _obInteger);

        char[][] c1;
        char[] c2[];
        char c3[][];

        c1 = new char[3][];
        c1[0] = new char[2];
        c1[1] = new char[3];
        c1[2] = new char[4];

        System.out.println("c1.length: " + c1.length);
        System.out.println("c1.length[0]: " + c1[0].length);
        System.out.println("c1.length[1]: " + c1[1].length);
        System.out.println("c1.length[2]: " + c1[2].length);

        c2 = new char[2][2];
        c2[0][0] = '7';
        c2[0][1] = '6';
        c2[1][0] = '0';
        c2[1][1] = '4';

        c1[0][0] = '5';
        c1[0][1] = '6';
        c1[1][0] = '2';
        c1[1][1] = '1';

        boolean  comRez = c1 == c2;
        System.out.println("boolean  comRez = c1 == c2: " + comRez);

        for(char[] i : c2){
            System.out.println(i);
        }

        System.out.println("");
    }
}
