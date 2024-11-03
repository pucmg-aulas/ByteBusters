package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastrarVeiculoView extends JFrame {
    private JTextField txtPlaca;
    private JComboBox<String> cmbClientes;
    private JButton btnCadastrar, btnVoltar;

    public CadastrarVeiculoView() {
        setTitle("Cadastro de Veículo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panel.add(txtPlaca);

        panel.add(new JLabel("Cliente:"));
        cmbClientes = new JComboBox<>(); // Você deve popular o comboBox com os clientes existentes
        panel.add(cmbClientes);

        btnCadastrar = new JButton("Cadastrar Veículo");
        btnVoltar = new JButton("Voltar");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnCadastrar);
        btnPanel.add(btnVoltar);

        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public String getPlaca() {
        return txtPlaca.getText();
    }

    public String getClienteSelecionado() {
        return (String) cmbClientes.getSelectedItem();
    }

    public void setClientes(String[] clientes) {
        cmbClientes.removeAllItems();
        for (String cliente : clientes) {
            cmbClientes.addItem(cliente);
        }
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }

    public void addVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }
}
