import java.util.Scanner;

public class Main{
    
	public static void main(String[] args){
		int escolha = 5;
		
		Scanner s = new Scanner(System.in);

	    double valor = 0;
		
		
		
		Cliente calos =new Cliente();
        calos.setNome("Calos");        
		Conta cc= new ContaCorrente(calos);
        Conta poupanca = new ContaPoupança(calos);
        
        
        
        
        
        
        System.out.println("+++++++++++++++++++++");
        System.out.println("+                   +");
        System.out.println("+++++ BEM VINDO +++++");
        System.out.println("+                   +");
        System.out.println("+++++++++++++++++++++ \n");

        while(escolha!=0) {
        	
        	System.out.println("1-Depositar 2-Sacar 3-Transferir 4-Extrato 0-Sair\n ");
        	escolha=s.nextInt();
        	switch (escolha) {
        		case 1:
        			System.out.println("Entre com o valor a depositar\n");
        			valor=s.nextInt();
        			cc.depositar(valor);
        			break;
        
        		case 2:
        			System.out.println("Entre com o valor a sacar\n");
        			valor=s.nextInt();
        			cc.sacar(valor);
        			break;
        		
        		case 3:
        			System.out.println("Entre com o valor a transferir para poupanca\n");
        			valor=s.nextInt();
        			cc.transferir(valor, poupanca);
        			break;
			
        		case 4:
        			cc.extrato();
        			poupanca.extrato();
        			break;
        	}
        
        }
        System.out.println("\n+++++++++++++ Volte Sempre +++++++++++ \n");
	}   
}