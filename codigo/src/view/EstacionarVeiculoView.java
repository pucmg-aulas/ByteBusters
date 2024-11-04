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
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelPlaca = new JLabel("Placa do Veículo:");
        labelPlaca.setBounds(50, 30, 120, 25);
        add(labelPlaca);

        JTextField txtPlaca = new JTextField();
        txtPlaca.setBounds(180, 30, 150, 25);
        add(txtPlaca);

        JLabel labelTipoDeVaga = new JLabel("Tipo de Vaga:");
        labelTipoDeVaga.setBounds(50, 70, 120, 25);
        add(labelTipoDeVaga);

        JComboBox<String> cmbTiposDeVaga = new JComboBox<>(new String[] {"Normal", "Pcd", "Idoso", "Vip"});
        cmbTiposDeVaga.setBounds(180, 70, 150, 25);
        add(cmbTiposDeVaga);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(100, 120, 200, 30);
        add(btnConfirmar);

        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText().trim();
                String tipoDeVaga = (String) cmbTiposDeVaga.getSelectedItem();

                if (!placa.isEmpty()) {
                    boolean sucesso = estacionamentoController.ocuparVaga(placa, tipoDeVaga);

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
