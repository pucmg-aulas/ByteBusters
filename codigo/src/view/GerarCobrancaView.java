package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.EstacionamentoController;

public class GerarCobrancaView extends JFrame {
    private EstacionamentoController estacionamentoController;

    public GerarCobrancaView(EstacionamentoController estacionamentoController) {
        this.estacionamentoController = estacionamentoController;
        setTitle("Gerar Cobrança");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelPlaca = new JLabel("Placa do Veículo:");
        labelPlaca.setBounds(50, 30, 120, 25);
        add(labelPlaca);

        JTextField txtPlaca = new JTextField();
        txtPlaca.setBounds(180, 30, 150, 25);
        add(txtPlaca);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(100, 70, 200, 30);
        add(btnConfirmar);

        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText().trim();
                
                String recibo = estacionamentoController.desocuparVaga(placa);
                
                if (recibo != null) {
                    JOptionPane.showMessageDialog(null, recibo);
                } else {
                    JOptionPane.showMessageDialog(null, "Veículo não encontrado ou não está estacionado.");
                }
                dispose();
            }
        });

        setVisible(true);
    }
}
