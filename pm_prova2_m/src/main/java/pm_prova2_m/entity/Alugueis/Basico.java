public class Basico extends Aluguel {
    private final double km;

    public Basico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status, double km, ArrayList<Veiculo> veiculos) {
        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
        this.km = km;
        this.veiculos = veiculos;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        if (km <= 100) {
            this.km =km
        } else {
            system.out.println("Kilometragen deve ser menor de 100km por dia")
        }
    }

    public boolean possuiSeguroIncluso() {
        return false;
    }
}
