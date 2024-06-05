import java.util.ArrayList;
import java.util.Scanner;

public class TeachersStudents {
    ArrayList <String> listTeachers;
    ArrayList <String> listStudents;
    ArrayList <ArrayList<String>> listGeneralGrouped;

    public TeachersStudents() {
        listTeachers = new ArrayList<String>();
        listStudents = new ArrayList<String>();
        listGeneralGrouped = new ArrayList<ArrayList <String>>();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Registrar profesores");
            System.out.println("2. Registrar estudiantes");
            System.out.println("3. Verificar estudiante");
            System.out.println("4. Verificar cantidad de estudiantes por profesor");
            System.out.println("5. Verificar profesor por nombre");
            System.out.println("6. Mostrar todos los profesores y sus estudiantes");
            System.out.println("7. Salir");

            option = Integer.parseInt(input.next());

            switch (option) {
                case 1:
                    registerTeachers();
                    break;
                case 2:
                    registerStudents();
                    break;
                case 3:
                    checkStudent();
                    break;
                case 4:
                    checkStudentsPerTeacher();
                    break;
                case 5:
                    checkTeacherByName();
                    break;
                case 6:
                    checkTeacher_Student();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    // Verifica si un estudiante existe en el sistema y muestra el profesor al que pertenece
    private void checkStudent() {
        String student;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el estudiante para verificar si se encuentra: ");
        student = input.next();
        boolean found = false;

        for (int i = 0; i < listGeneralGrouped.size(); i++) {
            for (int j = 0; j < listGeneralGrouped.get(i).size(); j++) {
                if (listGeneralGrouped.get(i).get(j).equals(student)) {
                    System.out.println("Se encontró el estudiante " + listGeneralGrouped.get(i).get(j) + " y pertenece al profesor " + listTeachers.get(i));
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("El estudiante no se encontró");
        }
    }

    // Verifica la cantidad de estudiantes que tiene un profesor específico
    private void checkStudentsPerTeacher() {
        String profesor;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el nombre del profesor para saber la cantidad de estudiantes: ");
        profesor = input.next();
        int counter = 0;

        for (int i = 0; i <= listTeachers.indexOf(profesor); i++) {
            if (listTeachers.indexOf(profesor) == i) {
                for (int j = 0; j < listGeneralGrouped.get(i).size(); j++) {
                    counter++;
                }
                System.out.println("La cantidad de estudiantes para el profesor " + listTeachers.get(listTeachers.indexOf(profesor)) + " es: " + counter);
            }
        }
    }

    // Verifica si un profesor existe en el sistema por nombre
    private void checkTeacherByName() {
        String nombre;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el nombre de el profesor a buscar: ");
        nombre = input.next();
        int x = 0;

        for (int i = 0; i < listTeachers.size(); i++) {
            if (listTeachers.get(i).contains(nombre)) {
                x++;
                break;
            }
        }
        if (x == 0) {
            System.out.println("No se encontró");
        } else {
            System.out.println("Se encontró");
        }
    }

    // Muestra todos los profesores con sus correspondientes estudiantes
    private void checkTeacher_Student() {
        for (int i = 0; i < listGeneralGrouped.size(); i++) {
            System.out.println(listTeachers.get(i) + ": " + listGeneralGrouped.get(i));
        }
    }

    // Registra estudiantes para cada profesor en el sistema
    private void registerStudents() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < listTeachers.size(); i++) {
            System.out.println("Ingresa la cantidad de estudiantes para el profesor " + (listTeachers.get(i)));
            int cant = Integer.parseInt(input.next());

            listStudents = new ArrayList<>();
            for (int j = 0; j < cant; j++) {
                String studentName;
                while (true) {
                    System.out.println("Ingresa el nombre de el estudiante " + (j + 1));
                    studentName = input.next();
                    if (!listStudents.contains(studentName)) {
                        listStudents.add(studentName);
                        break;
                    } else {
                        System.out.println("El nombre del estudiante ya existe. Ingresa un nombre diferente.");
                    }
                }
            }
            listGeneralGrouped.add(listStudents);
        }
    }

    // Registra profesores en el sistema
    private void registerTeachers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de profesores: ");
        int cant = Integer.parseInt(input.next());
        for (int i = 0; i < cant; i++) {
            String teacherName;
            while (true) {
                System.out.println("Ingresa el profesor " + (i + 1));
                teacherName = input.next();
                if (!listTeachers.contains(teacherName)) {
                    listTeachers.add(teacherName);
                    break;
                } else {
                    System.out.println("El nombre del profesor ya existe. Ingresa un nombre diferente.");
                }
            }
        }
    }
}
