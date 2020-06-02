package com.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vo.Person;

@Repository("zhuceDaoImpl")
public class ZhuceDaoImpl implements ZhuceDaoInf {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 注册
	 * 
	 * @param person
	 */
	public int zhuce(Person person) {
		int id = 0;
		// 添加
		id = (Integer) hibernateTemplate.save(person);
		return id;
	}

	/**
	 * 删除数据
	 * 
	 * @param person
	 */
	public void deletePerson(Person person) {
		// 删除
		this.hibernateTemplate.delete(person);
	}

	/**
	 * 更改数据
	 * 
	 * @param person
	 */
	public void updatePerson(Person person) {
		// 更新，在不查询的情况下修改（没有赋值的地方会改为null值）
		this.hibernateTemplate.update(person);
	}

	/**
	 * 根据id更改密码
	 * 
	 * @param id
	 * @param pwd
	 */
	public void updatePerson(int id, String pwd) {
		Person person = getPerson(id);
		// 更新
		person.setPwd(pwd);
		this.hibernateTemplate.update(person);
	}

	/**
	 * 更改或添加数据
	 * 
	 * @param person
	 */
	public void updateorsavePerson(Person person) {
		// 有就更新，没有就添加
		this.hibernateTemplate.saveOrUpdate(person);
	}

	/**
	 * 根据id查询数据
	 * 
	 * @param id
	 * @return Person
	 */
	public Person getPerson(int id) {
		// get方法查询
		return (Person) this.hibernateTemplate.get(Person.class, id);
	}

	/**
	 * Find查询所有数据
	 * 
	 * @return List<Person>
	 */
	public List<Person> findPerson() {
		// 获取多条数据
		List<Person> list = hibernateTemplate.find("from Person");

		return list;
	}

	/**
	 * Iterator查询所有数据
	 * 
	 * @return Iterator<Person>
	 */
	public Iterator<Person> iteratorPerson() {
		// hibernateTemplate.iterate(String queryString)
		Iterator<Person> iterator = hibernateTemplate.iterate("from Person");
		return iterator;
	}

	/**
	 * Find根据id查询
	 * 
	 * @param id
	 * @return List<Person>
	 */
	public List<Person> findPerson(int id) {
		// find(hql,Object)两个参数
		List<Person> list = hibernateTemplate.find("from Person where id = ?",
				new Integer(id));
		return list;
	}

	/**
	 * Iterator根据id查询
	 * 
	 * @param id
	 * @return Iterator<Person>
	 */
	public Iterator<Person> iteratorPerson(int id) {
		// hibernateTemplate.iterate(String queryString)
		Iterator<Person> iterator = hibernateTemplate.iterate("from Person",
				new Integer(id));
		return iterator;
	}

	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return List<Person>
	 */
	public List<Person> findPerson(String name) {
		String sname = "%" + name + "%";
		// find(hql,Object)两个参数,模糊查询
		List<Person> list = hibernateTemplate.find(
				"from Person where name like ?", sname);
		return list;
	}

	/**
	 * 根据姓名密码查询
	 * 
	 * @param name
	 * @param pwd
	 * @return List<Person>
	 */
	public List<Person> findPerson(String name, String pwd) {
		String hql = "from Person where name = ? and pwd = ?";
		// find(String queryString, Object[] values); 二个参数,第二个参数是数组
		List<Person> list = hibernateTemplate.find(hql, new String[] { name,
				pwd });
		return list;
	}

	/**
	 * 根据id，name查询数据
	 * 
	 * @param id
	 * @param name
	 * @return List<Person>
	 */
	public List<Person> findByExample(int id, String name) {
		Person example = new Person();
		example.setId(id);
		example.setName(name);
		// 相当于 select * from Person where id =1 and name = '张三'
		List<Person> list = hibernateTemplate.findByExample(example);
		return list;
	}

	/**
	 * 根据年龄查询数据，从firstResult开始，查询maxResults条
	 * 
	 * @param age
	 * @param firstResult
	 * @param maxResults
	 * @return List<Person>
	 */
	public List<Person> findByExample(int age, int firstResult, int maxResults) {
		Person example = new Person();
		example.setId(age);
		// findByExample(Object exampleEntity, int firstResult, int maxResults)
		List<Person> list = hibernateTemplate.findByExample(example,
				firstResult, maxResults);
		return list;
	}
}
