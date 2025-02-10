package primero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main {

	public static void main(String[] args) {
		//obtener la sesión actual
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//crear la sesión
		Session session = sesion.openSession();
        //crear una transacción de la sesión
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en la tabla DEPARTAMENTOS.");
		Departamentos dep = new Departamentos();
		dep.setDeptNo((byte) 62);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		session.save(dep);
		tx.commit();
		session.close();
		System.exit(0);

	}

}
