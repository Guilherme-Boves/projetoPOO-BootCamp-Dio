package Application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import Dominio.BootCamp;
import Dominio.Curso;
import Dominio.Dev;
import Dominio.Mentoria;

public class Program {

	public static void main(String[] args) {
		
		Curso curso = new Curso();
		curso.setTitulo("Curso de Java");
		curso.setDescricao("Descrição do curso Java");
		curso.setCargaHoraria(5);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso de C#");
		curso2.setDescricao("Descrição do curso C#");
		curso2.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria de Java");
		mentoria.setDescricao("Descrição da Mentoria de Java");
		mentoria.setData(LocalDate.now());
			
		Mentoria mentoria2 = new Mentoria();
		mentoria2.setTitulo("Mentoria de C#");
		mentoria2.setDescricao("Descrição da Mentoria de C#");
		mentoria2.setData(LocalDate.now());
		/*
		System.out.println(curso);
		System.out.println(curso2);
		System.out.println(mentoria);
		System.out.println(mentoria2);
		*/

		BootCamp bootcamp = new BootCamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição BootCamp Java Developer");
		bootcamp.getConteudos().add(curso);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev devGuilherme = new Dev();
		devGuilherme.setNome("Guilherme");
		devGuilherme.inscreverBootCamp(bootcamp);
		System.out.println("Conteúdos Inscritos" + devGuilherme.getConteudosInscritos());
		System.out.println();
		devGuilherme.progredir();
		devGuilherme.progredir();
		System.out.println("-");
		System.out.println("Conteúdos Inscritos" + devGuilherme.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos" + devGuilherme.getConteudosConcluidos());
		System.out.println("XP: " + devGuilherme.calcularXp());

		System.out.println("---------------");

		Dev devJoao = new Dev();
		devJoao.setNome("João");
		devJoao.inscreverBootCamp(bootcamp);
		System.out.println("Conteúdos Inscritos" + devJoao.getConteudosInscritos());
		System.out.println();
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		System.out.println("-");
		System.out.println("Conteúdos Inscritos" + devJoao.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos" + devJoao.getConteudosConcluidos());
		System.out.println("XP: " + devJoao.calcularXp());


	}

}
