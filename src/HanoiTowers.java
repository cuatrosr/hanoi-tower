
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HanoiTowers {

    private int[] towers;
    private int disks;
    private static final int TOWER_AMOUNT = 3;
    private static final int TOWER_1 = 0;
    private static final int TOWER_2 = 1;
    private static final int TOWER_3 = 2;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int ammountInt;
    private static int[] integerHanoi;

    public HanoiTowers(int n) {
        towers = new int[TOWER_AMOUNT];
        disks = n;
        towers[TOWER_1] = n;
        towers[TOWER_2] = 0;
        towers[TOWER_3] = 0;
    }

    //First call
    public void hanoi() throws IOException {
        bw.write(towers[TOWER_1] + " " + towers[TOWER_2] + " " + towers[TOWER_3] + "\n");
        hanoi(disks, TOWER_1, TOWER_3, TOWER_2);
    }

    public void hanoi(int k, int origin, int target, int aux) throws IOException {
        if (k > 0) {
            hanoi(k - 1, origin, aux, target);
            towers[origin]--;
            towers[target]++;
            bw.write(towers[TOWER_1] + " " + towers[TOWER_2] + " " + towers[TOWER_3] + "\n");
            hanoi(k - 1, aux, target, origin);
        }
    }

    public static void readFile() throws IOException {
        ammountInt = Integer.parseInt(br.readLine());
        integerHanoi = new int[ammountInt];
        for (int i = 0; i < ammountInt; i++) {
            integerHanoi[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
        HanoiTowers hn;
        for (int i = 0; i < ammountInt; i++) {
            hn = new HanoiTowers(integerHanoi[i]);
            hn.hanoi();
            if (i != ammountInt-1) {
                bw.write("\n");
            }
        }
        br.close();
        bw.close();
    }
}