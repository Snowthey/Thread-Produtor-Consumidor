import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class ThreadProdutor extends Thread {

    ArrayList<Integer> buffercircular = new ArrayList<Integer>(100);
    int valor = 0;
    public Semaphore Mutex = new Semaphore(1);
    public boolean Encerrar = false;
    JTextArea ListaInterfaceGrafica;
    Thread objetoThreadProdutor;

    ThreadProdutor(JTextArea lista){
        ListaInterfaceGrafica = lista;
        objetoThreadProdutor = new Thread(this);
        objetoThreadProdutor.start();
    }

    public void run(){
        while(!Encerrar){
            try{
                Mutex.acquire();

                if(buffercircular.size() < 100){
                    buffercircular.add(valor);
                    ListaInterfaceGrafica.append(Integer.toString(valor) + "\n");
                    valor++;
                }

                Mutex.release();
                Thread.sleep(10);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
