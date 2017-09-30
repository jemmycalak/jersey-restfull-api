package jersey.restfull.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="user_object")
@XmlType(propOrder= {"name","notelp"})
public class user_object {
	
	private String name;
	private int notelp;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setNotelp(int notelp) {
		this.notelp = notelp;
	}
	
	@XmlElement
	public int getNotelp() {
		return notelp;
	}

}
