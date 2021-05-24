package Package;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAO {

	private boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int doc_insert(doctor_bean db) throws ClassNotFoundException, SQLException {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();
		int i = (Integer) session.save(db);
		t.commit();
		System.out.println("Insertion Successfull");
		factory.close();
		session.close();
		return i;
	}

	public int user_insert(user_bean user) throws ClassNotFoundException, SQLException {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();
		int i = (Integer) session.save(user);
		t.commit();
		System.out.println("Insertion Successfull");
		factory.close();
		session.close();
		return i;
	}

	public boolean email_search(String email) {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();
		Query q1 = session.createQuery("select email_id from doctor_bean");
		List<String> l1 = q1.getResultList();
		Query q2 = session.createQuery("select email_id from user_bean");
		List<String> l2 = q2.getResultList();
		for (String p : l1) {
			if (p.equals(email)) {
				return false;
			}
		}
		for (String r : l2) {
			if (r.equals(email)) {
				return false;
			}
		}
		t.commit();
		factory.close();
		session.close();
		return true;
	}

	public String password_search(String email, String password) throws NullPointerException {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q1 = session.createQuery("select password from doctor_bean where email_id=:email_abc");
		q1.setParameter("email_abc", email);
		String l1 = (String) q1.uniqueResult();
		this.status = true;
		if (l1 == null || l1 == "") {
			Query q2 = session.createQuery("select password from user_bean where email_id=:email_xyz");
			q2.setParameter("email_xyz", email);
			String l2 = (String) q2.uniqueResult();
			this.status = false;
			return l2;
		}
		t.commit();
		factory.close();
		session.close();
		return l1;
	}

	public List<doctor_bean> doctor_list() {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("from doctor_bean");
		List<doctor_bean> list = q.list();
		t.commit();
		factory.close();
		session.close();
		return list;
	}

	public List<user_bean> user_list() {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("from user_bean");
		List<user_bean> list = q.list();
		t.commit();
		factory.close();
		session.close();
		return list;
	}

	public String user_name(String email_id) {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("select user_name from user_bean where email_id=:email");
		q.setParameter("email", email_id);
		String username = (String) q.uniqueResult();
		t.commit();
		factory.close();
		session.close();
		return username;
	}

	public int aadhar_no(String email_id) {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("select aadhar_no from user_bean where email_id=:email");
		q.setParameter("email", email_id);
		int aadhar_no = (Integer) q.uniqueResult();
		t.commit();
		factory.close();
		session.close();
		return aadhar_no;
	}

	public int customer_insert(customer_bean customer) throws ClassNotFoundException, SQLException {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();
		int i = (Integer) session.save(customer);
		t.commit();
		System.out.println("Insertion Successfull");
		factory.close();
		session.close();
		return i;
	}

	public List<customer_bean> customer_list() {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("from customer_bean");
		List<customer_bean> list = q.list();
		t.commit();
		factory.close();
		session.close();
		return list;
	}

	public int delete_appointment(int id) {

		Configuration cfg = new Configuration();
		Session session = cfg.getSession();
		Transaction t = cfg.getT();
		SessionFactory factory = cfg.getFactory();

		Query q = session.createQuery("delete from customer_bean where appointment_id=:app_id");
		q.setParameter("app_id", id);
		int i = q.executeUpdate();
		t.commit();
		factory.close();
		session.close();
		return i;
	}

}
