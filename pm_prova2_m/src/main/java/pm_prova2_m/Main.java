package pm_prova2_m;

public class Main {
    public static void main(String[] args) {
        Moto moto = newMoto("XXXXX", "Yamaha", 2024, 230.00, DISPONIVEL, 500, "Pneu - OK");
        Carro carro = newCarro("XXXXX", "Mitsubishi", 2025, 521.00, ALUGADO, 4, 10)
        Van van = newVan("XXXXX", "VANZINHA123", 2021, 600.00, MANUTENCAO, 20, "Motor - Fundido")

        Basico alugBasico("Abner", 1, 830, ATIVO, 98, [moto, van] )
        Premium alugPremium("Hannah", 8, 1, 1121.00, 280, [carro, van])
    }
}