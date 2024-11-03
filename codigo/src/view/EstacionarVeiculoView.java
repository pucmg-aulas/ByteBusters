package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.EstacionamentoController;

public class EstacionarVeiculoView extends JFrame {
    private EstacionamentoController estacionamentoController;

    public EstacionarVeiculoView(EstacionamentoController estacionamentoController) {
        this.estacionamentoController = estacionamentoController;
        setTitle("Estacionar Veículo");
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

                if (!placa.isEmpty()) {
                    boolean sucesso = estacionamentoController.ocuparVaga(placa);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Veículo estacionado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao ocupar vaga. Verifique se a placa está correta e se há vagas disponíveis.");
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "A placa do veículo é necessária.");
                }
            }
        });

        setVisible(true);
    }
}
