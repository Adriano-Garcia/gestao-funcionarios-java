package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.TrabalhadorLevel;

public class Trabalhador {

	private String nome;
	private TrabalhadorLevel level;
	private double salarioBase;

	private Departamento departamento;

	List<ContratosHoras> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, TrabalhadorLevel level, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TrabalhadorLevel getLevel() {
		return level;
	}

	public void setLevel(TrabalhadorLevel level) {
		this.level = level;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratosHoras> getContratos() {
		return contratos;
	}

	public void addContratos(ContratosHoras contrato) {
		contratos.add(contrato);
	}

	public void removeContratos(ContratosHoras contrato) {
		contratos.remove(contrato);
	}

	public double renda(int month, int year) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratosHoras c : contratos) {
			cal.setTime(c.getData());
			int c_month = cal.get(Calendar.MONTH);
			int c_year = 1 + cal.get(Calendar.YEAR);
			if(month == c_month && year == c_year) {
				soma += c.valorTotal();
			}
			
		}
		return soma;

	}

}