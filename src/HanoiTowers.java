
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;

public class HanoiTowers extends javax.swing.JFrame {

    private int[] towers;
    private int disks;
    private static final int TOWER_AMOUNT = 3;
    private static final int TOWER_1 = 0;
    private static final int TOWER_2 = 1;
    private static final int TOWER_3 = 2;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int ammountInt;
    private static int[] integerHanoi;
    private static String msg = "";

    public HanoiTowers() {
    }

    public HanoiTowers(int n) {
        towers = new int[TOWER_AMOUNT];
        disks = n;
        towers[TOWER_1] = n;
        towers[TOWER_2] = 0;
        towers[TOWER_3] = 0;
    }

    //First call
    public void hanoi() throws IOException {
        msg += towers[TOWER_1] + " " + towers[TOWER_2] + " " + towers[TOWER_3] + "\n";
        hanoi(disks, TOWER_1, TOWER_3, TOWER_2);
    }

    public void hanoi(int k, int origin, int target, int aux) throws IOException {
        if (k > 0) {
            hanoi(k - 1, origin, aux, target);
            towers[origin]--;
            towers[target]++;
            msg += towers[TOWER_1] + " " + towers[TOWER_2] + " " + towers[TOWER_3] + "\n";
            hanoi(k - 1, aux, target, origin);
        }
    }

    public void readFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File file = chooser.getSelectedFile();
        br = new BufferedReader(new FileReader(file));
        ammountInt = Integer.parseInt(br.readLine());
        integerHanoi = new int[ammountInt];
        for (int i = 0; i < ammountInt; i++) {
            integerHanoi[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        HanoiTowers hn = new HanoiTowers();
        hn.readFile();
        for (int i = 0; i < ammountInt; i++) {
            hn = new HanoiTowers(integerHanoi[i]);
            hn.hanoi();
            if (i != ammountInt - 1) {
                msg += "\n";
            }
        }
        hn.saveFile();
        br.close();
        bw.close();
        System.out.println("paso?");
        System.exit(0);
    }

    public void saveFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(msg);
    }
}
