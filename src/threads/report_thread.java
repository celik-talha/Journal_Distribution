package threads;
import gui.*;
public class report_thread implements Runnable{
    @Override
    public void run() {
        ReportGUI reportGUI = new ReportGUI();
        reportGUI.setVisible(true);
    }
}
