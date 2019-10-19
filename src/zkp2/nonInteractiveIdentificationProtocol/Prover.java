package zkp2.nonInteractiveIdentificationProtocol;

import org.bouncycastle.util.BigIntegers;
import zkp2.commons.Commons;
import zkp2.commons.ValueHolder;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
public class Prover {
    public static ValueHolder prover() throws IOException {
        SecureRandom random = new SecureRandom();
        BigInteger primeP = new BigInteger("294318880544991639594266924362588035491");
        BigInteger primitiveRootg = new BigInteger("2");
        /*the message that needs to be signed*/
        FileInputStream messageM = new FileInputStream("C:\\Users\\media\\Desktop\\temp\\sample.txt");
        BigInteger ONE = BigInteger.valueOf(1);
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger secretKeyX = BigIntegers.createRandomInRange(TWO, primeP.subtract(ONE), random);
        BigInteger publicKeyY = primitiveRootg.modPow(secretKeyX, primeP);
        BigInteger r = BigIntegers.createRandomInRange(ONE, primeP.subtract(ONE), random);
        BigInteger R = primitiveRootg.modPow(r, primeP);
        String hashMessage =
                Commons.computeSHA256(messageM).concat(Commons.calculateSha256(String.valueOf(R)));
        BigInteger hashResultBigInteger = new BigInteger(hashMessage, 16);
        /*computes her own challenge*/
        BigInteger challengeC = hashResultBigInteger.modPow(ONE, primeP.subtract(ONE));
        BigInteger ubefore = r.add(Commons.multi(challengeC, secretKeyX));
        BigInteger u = ubefore.modPow(ONE,primeP.subtract(ONE));
        /*sends Y,R,u and the message to the verifier */
        return new ValueHolder(publicKeyY,R,u,messageM);
    }
}
