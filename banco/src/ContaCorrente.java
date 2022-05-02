public class ContaCorrente extends Conta{

  

	public ContaCorrente(Cliente cliente) {
		// TODO Auto-generated constructor stub
		super(cliente);
	}

	@Override
    public void extrato() {
        System.out.println(String.format("======= Extrato CC ======"));
        super.imprimirInfoComuns("CC");
    }
}
