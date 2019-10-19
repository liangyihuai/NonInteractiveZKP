package zkp2.commons;

import org.bouncycastle.jcajce.provider.digest.SHA256;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.jcajce.provider.digest.SHA512;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class Commons {

    public static String computeSHA512(final InputStream inputStream) throws
            IOException {
        final byte[] dataBytes = new byte[1024];
        final SHA512.Digest digester = new SHA512.Digest();
        int nread = 0;
        while ((nread = inputStream.read(dataBytes)) != -1) {
            digester.update(dataBytes, 0, nread);
        }
        final byte[] mdbytes = digester.digest();
        // Convert the byte to hex format
        return new String(Hex.encode(mdbytes));
    }
    public static String calculateSha512(String message) throws IOException {
        SHA512.Digest md = new SHA512.Digest();
        md.update(message.getBytes("UTF-8"));
        return new String(Hex.encode(md.digest()));
    }

    public static String computeSHA256(final InputStream inputStream) throws
            IOException {
        final byte[] dataBytes = new byte[1024];
        final SHA256.Digest digester = new SHA256.Digest();
        int nread = 0;
        while ((nread = inputStream.read(dataBytes)) != -1) {
            digester.update(dataBytes, 0, nread);
        }
        final byte[] mdbytes = digester.digest();
        // Convert the byte to hex format
        return new String(Hex.encode(mdbytes));
    }
    public static String calculateSha256(String message) throws IOException {
        SHA256.Digest md = new SHA256.Digest();
        md.update(message.getBytes("UTF-8"));
        return new String(Hex.encode(md.digest()));
    }



    public static String computeSHA3512(final InputStream inputStream) throws
            IOException {
        final byte[] dataBytes = new byte[1024];
        final SHA3.DigestSHA3 digester = new SHA3.DigestSHA3(512);
        int nread = 0;
        while ((nread = inputStream.read(dataBytes)) != -1) {
            digester.update(dataBytes, 0, nread);
        }
        final byte[] mdbytes = digester.digest();
        // Convert the byte to hex format
        return new String(Hex.encode(mdbytes));
    }
    public static String calculateSha3512(String message) throws IOException {
        SHA3.DigestSHA3 md = new SHA3.DigestSHA3(512);
        md.update(message.getBytes("UTF-8"));
        return new String(Hex.encode(md.digest()));
    }

    public static BigInteger multi(BigInteger v1, BigInteger v2){
        return v1.multiply(v2);
    }

}
