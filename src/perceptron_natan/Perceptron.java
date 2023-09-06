package perceptron_natan;

/**
 *
 * @author natbr
 */
public class Perceptron{

    private double[] w = new double[3];
    private double NET = 0;
    private final int epocasMax = 30;
    private int count = 0;
    private int[][] mtzAprendizado = new int[4][3];

    public int getCount() {
        return this.count;
    }

    public Perceptron() {
        this.mtzAprendizado[0][0] = 0;
        this.mtzAprendizado[0][1] = 0;
        this.mtzAprendizado[0][2] = 0;

        this.mtzAprendizado[1][0] = 0;
        this.mtzAprendizado[1][1] = 1;
        this.mtzAprendizado[1][2] = 0;

        this.mtzAprendizado[2][0] = 1;
        this.mtzAprendizado[2][1] = 0;
        this.mtzAprendizado[2][2] = 0;

        this.mtzAprendizado[3][0] = 1;
        this.mtzAprendizado[3][1] = 1;
        this.mtzAprendizado[3][2] = 1;

        w[0] = 0;
        w[1] = 0;
        w[2] = 0;
    }

    public int executar(int x1, int x2) {
        NET = (x1 * w[0]) + (x2 * w[1]) + ((-1) * w[2]);
        if (NET >= 0) {
            return 1;
        }
        return 0;
    }
    
    public void arrumaPeso(int i, int saida) {
        for (int j = 0; j < w.length; j++) {
            w[j] += (1 * (mtzAprendizado[i][2] - saida) * (j == 2 ? -1 : mtzAprendizado[i][j]));
        }
    }

    public void treinar() {
        boolean treinou = true;
        int saida;

        for (int i = 0; i < mtzAprendizado.length; i++) {
            saida = executar(mtzAprendizado[i][0], mtzAprendizado[i][1]);

            System.out.println("Índice da linha: " + i);
            System.out.println("Valor de saída: " + saida);
            System.out.println("Valor esperado: " + mtzAprendizado[i][2]);

            if (saida != mtzAprendizado[i][2]) {
                arrumaPeso(i, saida);
                treinou = false;
            }
        }

        this.count++;

        if ((treinou == false) && (this.count < this.epocasMax)) {
            treinar();
        }
    }

    int executar(int[] entrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}