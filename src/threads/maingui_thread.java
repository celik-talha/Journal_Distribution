package threads;
import gui.*;
public class maingui_thread implements Runnable{
    @Override
    public void run() {
        MainGUI mainGUI = new MainGUI();
        mainGUI.setVisible(true);
    }
}
