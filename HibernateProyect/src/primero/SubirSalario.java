package primero;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;


public class SubirSalario {

	public static void main(String[] args) {
		// Obtener la sesión actual
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    // Crear la sesión
	    Session session = sessionFactory.openSession();
	    // Crear una transacción de la sesión
	    Transaction tx = session.beginTransaction();
	    String salario = args[0];
	    Departamentos dep = new Departamentos();
	    dep = (Departamentos) session.load(Departamentos.class,
	    (byte) 10);
	    try {
	    
	    //nuevo salario
	    Set<Empleados> listaemple = dep.getEmpleadoses();
	    Iterator<Empleados> it = listaemple.iterator();
	    while (it.hasNext()) {
	    	Empleados emple = it.next();
	    	System.out.printf("%s * %.2f %n",
	    	emple.getApellido(), emple.getSalario());
	    	float NuevoSalario = emple.getSalario() + Float.parseFloat(salario);
	    	emple.setSalario(NuevoSalario);
		    System.out.printf("%s * %.2f %n",
			    	emple.getApellido(), emple.getSalario());
		    session.update(emple);
	    }
	   
	    tx.commit();

	    }catch (ObjectNotFoundException o) {
	    System.out.println("NO EXISTE EL EMPLEADO...");
	    }catch (ConstraintViolationException c){
	    System.out.println("NO SE PUEDE ASIGNAR UN DEPARTAMENTO QUE NO EXISTE ");
	    }catch (Exception e) {
	    System.out.println("ERROR NO CONTROLADO....");
	    e.printStackTrace();
	    }

	}

}
