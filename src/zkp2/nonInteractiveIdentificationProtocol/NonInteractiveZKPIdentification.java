package zkp2.nonInteractiveIdentificationProtocol;

/**
 * Large prime p = 2q + 1; Primitive root g.
 * <p>
 * Peggy the prover has secret key x (2 < x < p) and public key Y = gx (mod
 p)
 * <p>
 * Peggy computes R = gr (mod p) ,random r , 1 < r < p-1 and sends it to
 Vickie the verifier.
 * <p>
 * Peggy computes c = H(R, M) (mod p – 1).
 * <p>
 * Peggy computes u = r + cx and sends u to Vicki
 * <p>
 * Vicki computes c = H(R, M) and verifies that gu = (R)∙(Y)c (mod p)
 **/
public class NonInteractiveZKPIdentification {
    public static void main(String args[]) throws Exception {
        double startTime = System.currentTimeMillis();
        System.out.println("WELCOME TO NIZPK");
        ProverNIZKP.prover();
        System.out.println(VerifierNIZKP.verify());
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        System.out.println("Total time taken in milliseconds " + totalTime);
    }
}
