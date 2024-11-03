package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class CobrancaController {
    private static List<Cobranca> cobrancasAtivas = new ArrayList<>();

    public static void adicionarCobranca(Cobranca cobranca) {
        cobrancasAtivas.add(cobranca);
    }

    public static Cobranca buscarCobrancaAtivaPorPlaca(String placa) {
        return cobrancasAtivas.stream()
                .filter(c -> c.getVeiculo().getPlaca().equals(placa) && c.getHoraSaida() == null)
                .findFirst()
                .orElse(null);
    }

    public static double calcularValorCobranca(String placa) {
        Cobranca cobranca = buscarCobrancaAtivaPorPlaca(placa);
        if (cobranca != null) {
            return cobranca.calcularValor();
        }
        return 0;
    }
}
