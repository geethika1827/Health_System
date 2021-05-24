package Package;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Configuration {

	public StandardServiceRegistry getSsr() {
		return ssr;
	}

	public void setSsr(StandardServiceRegistry ssr) {
		this.ssr = ssr;
	}

	public Metadata getMeta() {
		return meta;
	}

	public void setMeta(Metadata meta) {
		this.meta = meta;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getT() {
		return t;
	}

	public void setT(Transaction t) {
		this.t = t;
	}

	private StandardServiceRegistry ssr;
	private Metadata meta;
	private SessionFactory factory;
	private Session session;
	private Transaction t;

	public Configuration() {
		
		this.ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		this.meta = new MetadataSources(ssr).getMetadataBuilder().build();
		this.factory = meta.getSessionFactoryBuilder().build();
		this.session = factory.openSession();
		this.t = (Transaction) session.beginTransaction();
	}
}
