package com.jpa.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Test {
	@PersistenceContext
	EntityManager em;
        public static void main(String[] args) {
        	// 1. 创建EntityManagerFactory
    		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpademo");

    		// 2. 创建EntityManager
    		EntityManager entityManager = factory.createEntityManager();

    		//add(entityManager);
           //search(entityManager, "ww");
           //update(entityManager,1,"newname");
           //delete(entityManager, 13);
    		//searchM(entityManager);
    		//addR(entityManager);
    		//addC(entityManager);
    		addB(entityManager);
    		// 6. 关闭EntityManager
    		entityManager.close();

    		// 7. 关闭EntityManagerFactory
    		factory.close();
    	}
       //添加
    	public static void add(EntityManager entityManager) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作		
    		User user = new User();
    		user.setName("tom1");
    		user.setPassword("1234516");
    		// 添加user到数据库，相当于hibernate的save();insert
    		entityManager.persist(user);
    		// 5. 提交事务
    		transaction.commit();
    	}
    	public static void addR(EntityManager entityManager) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作		
    		Troler roler=new Troler();
    		roler.setRname("we");
    		// 添加user到数据库，相当于hibernate的save();insert
    		entityManager.persist(roler);
    		// 5. 提交事务
    		transaction.commit();
    	}
    	public static void addC(EntityManager entityManager) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作		
    		Tcode code=new Tcode();
    		code.setCid(13);
    		code.setCname("sssss");
    		// 添加user到数据库，相当于hibernate的save();insert
    		entityManager.persist(code);
    		// 5. 提交事务
    		transaction.commit();
    	}
    	public static void addB(EntityManager entityManager) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作		
    		Book book=new Book();
    		Person person=new Person();
    		//person.setPid(3);
    		person.setPname("lp");
    		book.setBname("ghjhj");
    		book.setPerson(person);
    		System.out.println(person.getList());
    		// 添加user到数据库，相当于hibernate的save();insert
    		entityManager.persist(person);
    		entityManager.persist(book);
    		// 5. 提交事务
    		transaction.commit();
    	}
       //修改
    	public static void update(EntityManager entityManager,int id,String name) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作
    		/*User user=entityManager.find(User.class,id);
    		user.setName(name);
    		user=entityManager.merge(user);
    		System.out.println(user);*/
    		entityManager.createNativeQuery("update User set name=?1 where id=?2").setParameter(1,name).setParameter(2, id).executeUpdate();
    		// 5. 提交事务
    		transaction.commit();
    	}
    	//删除
    	public static void delete(EntityManager entityManager,int id) {
    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
    		// 4. 持久化操作
    		User user=entityManager.find(User.class,id);
    		entityManager.remove(user);
    		// 5. 提交事务
    		transaction.commit();
    	}
    	
    	//查找
    	public static void search(EntityManager entityManager, String name) {

    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
           //SELECT u FROM User u WHERE u.name like ?  User是实体
List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.name like ? ").setParameter(1, name).getResultList();
    		for (int i = 0; i < list.size(); i++) {
    			System.out.println(list.get(i).toString());
    		}
    	}
    	//查找
    	public static void searchM(EntityManager entityManager) {

    		// 3.开启事务	
    		EntityTransaction transaction = entityManager.getTransaction();
    		transaction.begin();
           //SELECT u FROM User u WHERE u.name like ?  User是实体
List<Troler> list = entityManager.createQuery("SELECT u FROM Troler u ").getResultList();
    		for (int i = 0; i < list.size(); i++) {
    			System.out.println(list.get(i).toString());
    		}
    	}
    	
    	
		}

