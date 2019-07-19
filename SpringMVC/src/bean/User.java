package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {

	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	
	
	private String aa;
	private int v;
	
	private List<String> list;
	private Set<String> set;
	private Map<String, Object> map;
	
}
