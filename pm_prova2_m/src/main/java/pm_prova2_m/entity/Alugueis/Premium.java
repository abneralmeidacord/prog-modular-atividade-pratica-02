public class Premium extends Aluguel {
    private final double km;
    
    public Premium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status, double km, ArrayList<Veiculo> veiculos) {
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
        this.km =km
    }

    public boolean possuiSeguroIncluso() {
        return true;
    }
}
