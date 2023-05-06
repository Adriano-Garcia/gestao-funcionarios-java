package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratosHoras;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.TrabalhadorLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador:");
		System.out.print("nome: ");
		String nome =sc.nextLine();
		System.out.print("Level: ");
		String level =sc.nextLine();
		System.out.print("Salário base: ");
		double salario = sc.nextDouble();
		
		Trabalhador func = new Trabalhador(nome, TrabalhadorLevel.valueOf(level), salario, new Departamento(nomeDepartamento));
		
		System.out.print("quantos contratos para esse trabalhador? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato #" + i + ":");
			System.out.print("Data: (DD/MM/YYYY): ");
			Date dataContrato = f.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valor = sc.nextDouble();
			System.out.print("Quantidade de horas: ");
			int horas = sc.nextInt();
			ContratosHoras contrato = new ContratosHoras(dataContrato, valor, horas);
			func.addContratos(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular a renda (MM/YYYY): ");
		String monthEyear = sc.next();
		int month = Integer.parseInt(monthEyear.substring(0, 2));
		int year = Integer.parseInt(monthEyear.substring(3));
		
		System.out.println();
		System.out.println("nome: " + func.getNome());
		System.out.println("Departamento: " + func.getDepartamento().getNome());
		System.out.println("Renda para " + monthEyear + ": " + String.format("%.2f", func.renda(month, year)));
		
		
		sc.close();
	}

}
