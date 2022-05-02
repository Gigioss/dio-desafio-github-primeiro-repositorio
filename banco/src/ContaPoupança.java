public class ContaPoupança extends Conta{

  
	public ContaPoupança(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void extrato() {
        System.out.println(String.format("======= Extrato Poupanca ======"));
        super.imprimirInfoComuns("Poupanca");
   
    }


}
