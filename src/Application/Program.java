package Application;

import Dominio.BootCamp;
import Dominio.Curso;
import Dominio.Dev;
import Dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BootCamp bootcamp = new BootCamp();

		int qtdCursos = 0;
		while(qtdCursos < 1) {
			System.out.print("Quantos cursos deseja cadastar no BootCamp? ");
			qtdCursos = sc.nextInt();
		}

		int i = 0;
		while(i < qtdCursos) {
			System.out.print("Nome do Curso: ");
			sc.nextLine();
			String nomeCurso = sc.nextLine();

			System.out.print("Descrição do Curso: ");
			String descricaoCurso = sc.nextLine();

			System.out.print("Carga Horária: ");
			int cargaHoraria = sc.nextInt();
			
			Curso curso = new Curso();
			curso.setTitulo(nomeCurso);
			curso.setDescricao(descricaoCurso);
			curso.setCargaHoraria(cargaHoraria); 
			bootcamp.addCurso(curso);

			i++;
		}
		
		String opMentoria = null;
		boolean running = true;
		while(running) {
			
			System.out.print("Deseja cadastar uma Mentoria? S/N: ");
			opMentoria = sc.next();
			
			if(opMentoria.equals("S") || opMentoria.equals("s")) {

				System.out.print("Quantas mentorias deseja cadastrar? ");
				int qtdMonitorias = sc.nextInt();

				i = 0;
				while(i < qtdMonitorias) {
					System.out.print("Titulo da Mentoria: ");
					sc.nextLine();
					String nomeMonitoria = sc.nextLine();

					System.out.print("Descrição do Mentoria: ");
					String descricaoMonitoria = sc.nextLine();

					Mentoria mentoria = new Mentoria();
					mentoria.setTitulo(nomeMonitoria);
					mentoria.setDescricao(descricaoMonitoria);
					mentoria.setData(LocalDate.now());

					bootcamp.addMentoria(mentoria);
					i++;
				} 	
				running = false;
			} else if (opMentoria.equals("N") || opMentoria.equals("n")) {
				running = false;
			} else {
				System.out.println("Opção Inválida!\n");
			}
		}	

		System.out.print("Nome do BootCamp: ");
		sc.nextLine();
		String nomeBootcamp = sc.nextLine();
		System.out.print("Descrição do BootCamp: ");
		String descricaoBootcamp = sc.nextLine();

		bootcamp.setNome(nomeBootcamp);
		bootcamp.setDescricao(descricaoBootcamp);
		bootcamp.getConteudos().addAll(bootcamp.getCursos());
		if(opMentoria.equals("S") || opMentoria.equals("s")) {
			bootcamp.getConteudos().addAll(bootcamp.getMentorias());			
		}else {
			System.out.println("Nenhuma mentoria cadastrada!");
		}

		System.out.printf("\n******** BOOTCAMP %s ********\n", bootcamp.getNome());

		System.out.println();
		Dev devGuilherme = new Dev();
		devGuilherme.setNome("Guilherme");
		devGuilherme.inscreverBootCamp(bootcamp);
		System.out.printf("*** Dev %s ***\n", devGuilherme.getNome());
		System.out.println("Conteúdos Inscritos" + devGuilherme.getConteudosInscritos());
		System.out.println();
		devGuilherme.progredir();
		System.out.println("Progrediu!");
		System.out.println("-------------------------------------");
		System.out.println("Conteúdos Inscritos" + devGuilherme.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos" + devGuilherme.getConteudosConcluidos());
		System.out.println("XP: " + devGuilherme.calcularXp());

		System.out.println("-----------------------------------------------------\n");

		Dev devJoao = new Dev();
		devJoao.setNome("João");
		devJoao.inscreverBootCamp(bootcamp);
		System.out.printf("*** Dev %s ***\n", devJoao.getNome());
		System.out.println("Conteúdos Inscritos" + devJoao.getConteudosInscritos());
		System.out.println();
		devJoao.progredir();
		System.out.println("Progrediu!");
		System.out.println("-------------------------------------");
		System.out.println("Conteúdos Inscritos" + devJoao.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos" + devJoao.getConteudosConcluidos());
		System.out.println("XP: " + devJoao.calcularXp());


		sc.close();
	}

}
