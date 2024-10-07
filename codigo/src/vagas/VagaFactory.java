// src/vagas/VagaIdoso.java
package vagas;

public class VagaFactory {

    public static Vaga criarVaga(String tipo, String id) {
        switch (tipo) {
            case "VagaRegular":
                return new VagaRegular(id);
            case "VagaIdoso":
                return new VagaIdoso(id);
            case "VagaPCD":
                return new VagaPCD(id);
            case "VagaVIP":
                return new VagaVIP(id);
            default:
                return null;
        }
    }
}
