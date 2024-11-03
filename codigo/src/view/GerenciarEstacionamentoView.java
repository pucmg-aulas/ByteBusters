package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.EstacionamentoController;

public class GerenciarEstacionamentoView extends JFrame {
    private EstacionamentoController estacionamentoController;

    public GerenciarEstacionamentoView(EstacionamentoController estacionamentoController) {
        this.estacionamentoController = estacionamentoController;
        setTitle("Gerenciar Estacionamento");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnOcuparVaga = new JButton("Ocupar Vaga");
        btnOcuparVaga.setBounds(100, 30, 200, 30);
        add(btnOcuparVaga);

        JButton btnGerarCobranca = new JButton("Gerar Cobrança");
        btnGerarCobranca.setBounds(100, 70, 200, 30);
        add(btnGerarCobranca);

        btnOcuparVaga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EstacionarVeiculoView(estacionamentoController);
            }
        });

        btnGerarCobranca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerarCobrancaView(estacionamentoController);
            }
        });

        setVisible(true);
    }
}
