import javax.swing.JTextArea;

public class ThreadConsumidor extends Thread {

    ThreadProdutor objetoThreadProdutor;
    Thread objetoThreadConsumidor;
    JTextArea ListaInterfaceGrafica;
    public boolean Encerrar = false;

    ThreadConsumidor(ThreadProdutor temp, JTextArea lista) {
        objetoThreadProdutor = temp;
        ListaInterfaceGrafica = lista;
        objetoThreadConsumidor = new Thread(this);
        objetoThreadConsumidor.start();
    }

    public void run() {
        while (!Encerrar) {
            try{
                objetoThreadProdutor.Mutex.acquire();

                if(objetoThreadProdutor.buffercircular.size() > 0){
                    int temp = objetoThreadProdutor.buffercircular.remove(0);
                    int processamento = temp * 100;
                    ListaInterfaceGrafica.append(Integer.toString(processamento) + "\n");
                }

                objetoThreadProdutor.Mutex.release();
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
