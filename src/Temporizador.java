import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Temporizador extends Timer{

    private Timer timer;
    private Relogio relogionatela;

    public Temporizador(JLabel lblInterface){
        timer = new Timer();
        relogionatela = new Relogio(lblInterface);
        timer.schedule(relogionatela, 0, 100);
    }
}
