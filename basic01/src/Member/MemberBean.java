package Member;

import java.util.*;

public class MemberBean {
	private int id;
	private String name;
	private String mail;
	private String tel;
	
	public int getId() {
		return id;
	}
	public int getNewId() {
		if(tel!=null) {
			id = Objects.hash(name, mail, tel);
			System.out.println(toString());
		}
		return id;
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", name=" + name + ", mail=" + mail + ", tel=" + tel + "]";
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public String getTel() {
		return tel;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
