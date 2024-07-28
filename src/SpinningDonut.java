public class SpinningDonut {
    public static void main(String[] args) {
        double A = 0, B = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            double[] z = new double[1760];
            char[] b = new char[1760];
            for (int i = 0; i < 1760; i++) {
                b[i] = ' ';
                z[i] = 0;
            }
            for (double j = 0; j < 6.28; j += 0.07) { // j <=> theta
                for (double i = 0; i < 6.28; i += 0.02) { // i <=> phi
                    double c = Math.sin(i),
                            d = Math.cos(j),
                            e = Math.sin(A),
                            f = Math.sin(j),
                            g = Math.cos(A),
                            h = d + 2,
                            D = 1 / (c * h * e + f * g + 5),
                            l = Math.cos(i),
                            m = Math.cos(B),
                            n = Math.sin(B),
                            t = c * h * g - f * e;
                    int x = (int) (40 + 30 * D * (l * h * m - t * n)),
                            y = (int) (12 + 15 * D * (l * h * n + t * m)),
                            o = x + 80 * y,
                            N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                    if (22 > y && y > 0 && x > 0 && 80 > x && D > z[o]) {
                        z[o] = D;
                        b[o] = ".,-~:;=!*#$@" .charAt(N > 0 ? N : 0);
                    }
                }
            }
            System.out.print("\u001b[H");
            for (int k = 0; k < 1760; k++) {
                sb.append(k % 80 == 79 ? "\n" : b[k]);
            }
            System.out.flush();
            System.out.print(sb);
            sb.setLength(0);
            A += 0.04;
            B += 0.02;
        }
    }
}
