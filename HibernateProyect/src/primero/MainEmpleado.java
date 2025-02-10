package primero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainEmpleado {
	public static void main(String[] args) {
	    // Obtener la sesión actual
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    // Crear la sesión
	    Session session = sessionFactory.openSession();
	    // Crear una transacción de la sesión
	    Transaction tx = session.beginTransaction();

	    // Información del empleado a insertar
	    System.out.println("Inserto un EMPLEADO EN EL DEPARTAMENTO 10.");
	    Float salario = new Float(1500); // inicializo el salario
	    Float comision = new Float(10);  // inicializo la comisión
	    
	    Empleados em = new Empleados(); // creo un objeto empleado
	    em.setEmpNo((short) 4455);
	    em.setApellido("PEPE");
	    em.setDir((short) 7499); // el director es el empleado 7499
	    em.setOficio("VENDEDOR");
	    em.setSalario(salario);
	    em.setComision(comision);

	    // Se crea un objeto Departamentos para asignárselo al empleado
	    Departamentos d = new Departamentos();
	    d.setDeptNo((byte) 10); // El número de departamento es 10
	    em.setDepartamentos(d);

	    // Fecha de alta, calculamos la fecha actual
	    java.util.Date hoy = new java.util.Date();
	    java.sql.Date fecha = new java.sql.Date(hoy.getTime());
	    em.setFechaAlt(fecha);

	    // Guardar el empleado en la base de datos
	    session.save(em);

	    // Confirmar la transacción
	    tx.commit();

	    // Cerrar la sesión
	    session.close();

	    // Finalizar el programa
	    System.exit(0);
	}

}
