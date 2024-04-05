package alumnojavadoc;

//Esta clase representa a un alumno, guardando datos de el

/**
 *
 * @author Usuario
 */
public class AlumnoJavaDoc {

    private static int contador_Alumnos = 1; // Contador para asignar un ID unico a cada alumno
    private String nombre = ""; // Nombre del alumno
    private int Edad = 0; // Edad del alumno
    private double nota = 0.0; // Nota del alumno
    private String calificacion = ""; // Calificación del alumno
    private int id = 0; // ID del alumno

    //Este es el constructor de la clase alumno, recib eel nombre, edad y nota del alumno

    /**
     *
     * @param nombre Nombre del alumno
     * @param edad Edad del alumno
     * @param nota Nota del alumno
     */
    public AlumnoJavaDoc(String nombre, int edad, double nota) {
        try {
            setNombre(nombre);
            setEdad(edad);
            setNota(nota);
            calificacion = calcularCalificacion();
            id = contador_Alumnos++;
        } catch (Exception e) {
            System.out.println("No se pudo crear el alumno");
        }
    }

    //Devuelve el id del alumno

    /**
     *
     * @return Id del alumno
     */
    public int getId() {
        return id;
    }

    //Devuelve el nombre del alumno

    /**
     *
     * @return Nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    //Establece el nombre del alumno

    /**
     *
     * @param nombre Nuevo nombre del alumno
     * @throws IllegalArgumentException si es nulo o mayor a 100 caracteres devuelve una excepcion
     */
    public void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre != null && nombre.trim().length() > 0 && nombre.trim().length() < 100) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío ni tener más de 100 caracteres");
        }
    }

    //Devuelve la edad del alumno

    /**
     *
     * @return Edad del alumno
     */
    public int getEdad() {
        return Edad;
    }

    //Establece la edad del alumno

    /**
     *
     * @param edad Nueva edad del alumno
     * @throws IllegalArgumentException si es mayor a 100 ni menor que 0
     */
    public void setEdad(int edad) throws IllegalArgumentException {
        if (edad > 0 && edad < 100) {
            this.Edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe ser mayor que 0 y menor que 100");
        }
    }

    //Devuelve la nota del alumno

    /**
     *
     * @return nota del alumno
     */
    public double getNota() {
        return nota;
    }

    //Establece la nota del alumno

    /**
     *
     * @param nota nueva nota del alumno
     * @throws IllegalArgumentException si la edad es menor o igual a 0, o mayor o igual a 100
     */
    public void setNota(double nota) throws IllegalArgumentException {
        if (nota >= 0.0 && nota <= 10.0) {
            this.nota = (double) Math.round(nota * 100) / 100;
            calificacion = calcularCalificacion();
        } else {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
    }

    //Devuelve la nota del alumno

    /**
     *
     * @return calificacion del alumno
     */
    public String getCalificacion() {
        return calificacion;
    }

    //Calcula la calificacion del alumno dependiendo de su nota
    private String calcularCalificacion() {
        if (nota < 5.0) {
            return "Suspenso";
        } else if (nota <= 5.99) {
            return "Suficiente";
        } else if (nota <= 6.99) {
            return "Bien";
        } else if (nota <= 8.99) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }

    //Devuelve de manera grafica los atributos de un alumno
    @Override
    public String toString() {
        return "Alumno{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", edad=" + Edad
                + ", nota=" + nota
                + ", calificacion='" + calificacion + '\''
                + '}';
    }

}

