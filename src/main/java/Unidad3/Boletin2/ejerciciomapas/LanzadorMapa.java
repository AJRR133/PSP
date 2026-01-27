package Unidad3.Boletin2.ejerciciomapas;

public class LanzadorMapa {
    public static void main(String[] args) {
        String[] posiblesIds = {"A1", "B2", "C3", "D4", "Z9", "A1"};

        for (int i = 0; i < 10; i++) {
            String idAProbar = posiblesIds[i % posiblesIds.length];
            new HiloClienteMapa(idAProbar).start();
        }
    }
}