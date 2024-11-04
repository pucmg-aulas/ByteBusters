package view;

import javax.swing.*;
import controller.ClienteController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarVeiculoView extends JFrame {
    private JTextField txtPlaca;
    private JTextField txtClienteId;
    private JButton btnConfirmar;

    public CadastrarVeiculoView(ClienteController clienteController) {
        setTitle("Cadastrar Veículo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelPlaca = new JLabel("Placa do Veículo:");
        labelPlaca.setBounds(50, 30, 120, 25);
        add(labelPlaca);

        txtPlaca = new JTextField();
        txtPlaca.setBounds(180, 30, 150, 25);
        add(txtPlaca);

        JLabel labelCliente = new JLabel("ID do Cliente:");
        labelCliente.setBounds(50, 70, 120, 25);
        add(labelCliente);

        txtClienteId = new JTextField();
        txtClienteId.setBounds(180, 70, 150, 25);
        add(txtClienteId);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(100, 110, 200, 30);
        add(btnConfirmar);

        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String clienteId = txtClienteId.getText();
        
                boolean sucesso = ClienteController.cadastrarVeiculo(clienteId, placa);
        
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo. Verifique o ID do cliente.");
                }
                dispose();
            }
        });
        

        setVisible(true);
    }

    public String getPlaca() {
        return txtPlaca.getText();
    }

    public String getClienteSelecionado() {
        return txtClienteId.getText();
    }
}