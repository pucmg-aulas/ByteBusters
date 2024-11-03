package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class CriarEstacionamentoView extends JFrame {
    public CriarEstacionamentoView(EstacionamentoController controller) {
        setTitle("Criar Estacionamento");
        setSize(300, 200);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 10, 160, 25);
        add(txtNome);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(10, 40, 80, 25);
        add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 40, 160, 25);
        add(txtEndereco);

        JLabel lblTotalVagas = new JLabel("Total de Vagas:");
        lblTotalVagas.setBounds(10, 70, 100, 25);
        add(lblTotalVagas);

        JTextField txtTotalVagas = new JTextField();
        txtTotalVagas.setBounds(100, 70, 160, 25);
        add(txtTotalVagas);

        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(100, 110, 100, 25);
        add(btnCriar);

        btnCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String endereco = txtEndereco.getText();
                int totalVagas = Integer.parseInt(txtTotalVagas.getText());
                
                controller.criarEstacionamento(nome, endereco, totalVagas);
                JOptionPane.showMessageDialog(null, "Estacionamento criado com sucesso!");
                dispose();
            }
        });

        setVisible(true);
    }
}
