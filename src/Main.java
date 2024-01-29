import org.ltsAhMe.pvz.PlantVsZombie;
import org.ltsAhMe.pvz.Rander.Room.RoomMana;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (args.length ==0){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.showDialog(null,"设置资源文件夹");
                PlantVsZombie.gameResDir =fileChooser.getSelectedFile().getAbsolutePath()+"/";

        }
        new PlantVsZombie();

    }
}
