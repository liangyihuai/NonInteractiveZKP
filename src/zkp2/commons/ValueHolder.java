package zkp2.commons;

import java.io.FileInputStream;
import java.math.BigInteger;
public class ValueHolder {
    private static BigInteger a;
    private static BigInteger b;
    private static BigInteger c;
    private static FileInputStream d;
    public ValueHolder(BigInteger a, BigInteger b, BigInteger c, FileInputStream d) {
        ValueHolder.a =a;
        ValueHolder.b=b;
        ValueHolder.c=c;
        ValueHolder.d=d;
    }
    public ValueHolder(BigInteger publicKeyY, BigInteger r, BigInteger u) {
        ValueHolder.a=publicKeyY;
        ValueHolder.b=r;
        ValueHolder.c=u;
    }
    public static BigInteger getA() {
        return a;
    }
    public static BigInteger getB() {
        return b;
    }
    public static BigInteger getC() {
        return c;
    }
    public static FileInputStream getD() {
        return d;
    }
}
