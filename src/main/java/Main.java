package main.java;

import console.UI;
import domain.Nota;
import domain.Student;
import domain.Tema;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

public class Main {

  public static void main(String[] args) {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
    UI consola = new UI(service);
    consola.run();

    service.saveStudent("100", "Alex", 935);
    service.saveTema("200", "Lab1_TH", 7, 4);
    service.saveNota("100", "200", 10, 5, "good");

    //PENTRU GUI
    // de avut un check: daca profesorul introduce sau nu saptamana la timp
    // daca se introduce nota la timp, se preia saptamana din sistem
    // altfel, se introduce de la tastatura
  }
}
