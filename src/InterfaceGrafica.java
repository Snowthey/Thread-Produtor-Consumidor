import java.awt.Container;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame implements ActionListener {

    private JButton btnIniciar;
    private JButton btnParar;
    private JLabel lblNumerosGerados;
    private JLabel lblNumerosProcessados;
    private JLabel lblRelogio;
    static private JTextArea listaNumerosGerados;
    static private JTextArea listaNumerosProcessados;
    private JScrollPane scrollListaNumerosGerados;
    private JScrollPane scrollListaNumerosProcessados;
    private Container janelaPrincipal;

    ThreadProdutor objetothreadProdutor;
    ThreadConsumidor objetothreadConsumidor;

    public InterfaceGrafica() {
        setSize(300, 640);
        setTitle("Threads");
        janelaPrincipal = getContentPane();
        janelaPrincipal.setLayout(null);

        btnIniciar = new JButton("Iniciar");
        btnParar = new JButton("Parar");
        lblRelogio = new JLabel("Relogio");
        lblNumerosGerados = new JLabel("Gerados");
        lblNumerosProcessados = new JLabel("Processados");
        listaNumerosGerados = new JTextArea();
        listaNumerosProcessados = new JTextArea();
        scrollListaNumerosGerados = new JScrollPane(listaNumerosGerados);
        scrollListaNumerosProcessados = new JScrollPane(listaNumerosProcessados);
        btnIniciar.setBounds(70, 550, 80, 40);
        btnParar.setBounds(160, 550, 80, 40);
        lblNumerosGerados.setBounds(50, 3, 100, 20);
        lblNumerosProcessados.setBounds(180, 3, 100, 20);
        scrollListaNumerosGerados.setBounds(30, 20, 100, 500);
        scrollListaNumerosProcessados.setBounds(160, 20, 100, 500);
        lblRelogio.setBounds(120, 520, 80, 40);

        janelaPrincipal.add(btnIniciar);
        janelaPrincipal.add(btnParar);
        janelaPrincipal.add(lblNumerosGerados);
        janelaPrincipal.add(lblNumerosProcessados);
        janelaPrincipal.add(scrollListaNumerosGerados);
        janelaPrincipal.add(scrollListaNumerosProcessados);
        janelaPrincipal.add(lblRelogio);

        setVisible(true);

        btnIniciar.addActionListener(this);
        btnParar.addActionListener(this);

        Temporizador reloginho = new Temporizador(lblRelogio);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Iniciar")) {
            listaNumerosGerados.setText("");
            listaNumerosProcessados.setText("");

            objetothreadProdutor = new ThreadProdutor(listaNumerosGerados);
            objetothreadConsumidor = new ThreadConsumidor(objetothreadProdutor, listaNumerosProcessados);
        }

        if(e.getActionCommand().equals("Parar")) {

            objetothreadProdutor.Encerrar = true;
            objetothreadConsumidor.Encerrar = true;
        }
    }

    public static void main(String[] args) {
        InterfaceGrafica tela = new InterfaceGrafica();
    }
}
