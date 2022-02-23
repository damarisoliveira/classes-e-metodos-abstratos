package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pessoa pessoa;
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		
		
		for(int i = 1; i<=n; i++) {
			System.out.println("#" + i + ": ");
			
			System.out.println("Pessoa Física ou Juridica (f/j) ?");
			char esc = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			sc.nextLine();
			
			System.out.print("Rendimento anual: ");
			double rendAnual = sc.nextDouble();
			
			
			if(esc == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				
				pessoa = new PessoaFisica(nome, rendAnual, gastosComSaude);
				list.add(pessoa);
			}
			else {
				System.out.print("Número de funcionários: ");
				int funcionarios = sc.nextInt();
				
				pessoa = new PessoaJuridica(nome, rendAnual, funcionarios);
				list.add(pessoa);
			}
			
		}
		
		
		System.out.println("\nIMPOSTOS PAGOS: ");
		double soma = 0;
		for(Pessoa p : list) {
			double imposto = p.impostos();
			System.out.println(p.getNome() + ": $ " + String.format("%.2f", imposto));
			soma += imposto;
		}
		
		
		System.out.println("\nIMPOSTOS TOTAIS: $ " + String.format("%.2f", soma));
		sc.close();
	}

}
