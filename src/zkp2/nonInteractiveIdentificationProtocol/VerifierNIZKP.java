package zkp2.nonInteractiveIdentificationProtocol;

import zkp2.commons.Commons;
import zkp2.commons.ValueHolder;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
public class VerifierNIZKP {
    public static boolean verify() throws IOException {
        BigInteger primeP = new
                BigInteger("294318880544991639594266924362588035491");
        BigInteger primitiveRootg = new BigInteger("2");
        BigInteger ONE = BigInteger.valueOf(1);
        BigInteger Y = ValueHolder.getA();
        BigInteger R = ValueHolder.getB();
        BigInteger u = ValueHolder.getC();
        String hashMessage = Commons.calculateSha256(String.valueOf(R));
        BigInteger hashResultBigInteger = new BigInteger(hashMessage, 16);
        /*computes challenge c separately*/
        BigInteger challengeC = hashResultBigInteger.modPow(ONE,
                primeP.subtract(ONE));
 /*verifies if g^u mod p which is the LHS = R.Y^c mod p which is the
RHS
 * modular multiplication is carried out in this fashion (R(mod p))*
Y^c(mod p))(mod p)*/
        BigInteger LHS = primitiveRootg.modPow(u, primeP);
        BigInteger RHS1 = R.modPow(ONE, primeP);
        BigInteger RHS2 = Y.modPow(challengeC, primeP);
        BigInteger partialRHS = Commons.multi(RHS1, RHS2);
        BigInteger RHS = partialRHS.modPow(ONE, primeP);
        return LHS.equals(RHS);
    }
}
