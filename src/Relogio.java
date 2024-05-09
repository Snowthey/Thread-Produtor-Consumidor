import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import javax.swing.*;


public class Relogio extends TimerTask {

    JLabel interfaceGrafica;

    Relogio(JLabel label){
        interfaceGrafica = label;
    }

    @Override
    public void run() {
        try{
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localTime = LocalTime.now();
            interfaceGrafica.setText(formatoHora.format(localTime));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
