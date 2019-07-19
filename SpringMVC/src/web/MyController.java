package web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.User;

@SessionAttributes("name1")
@Controller
public class MyController {

//��springMVC�У������б��еĲ��� �ȼ��� request.getparameter("")
	@RequestMapping("/b2") //@requestMapping(value="����·��"��method="����ʽ")
	public String b2(HttpServletRequest req) {
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("pass"));
		return "aaaa";
	}
	
//ǰ���������̨������һ��ʱ
	@RequestMapping("/b3")
	public String b3(String username,String pass) {
		System.out.println(username);
		System.out.println(pass);
		return"aaaa";
	}
	
//ǰ�����Ժͺ�̨��������һ��ʱ ʹ��@RequestParam ע��
	@RequestMapping("/b4")	//@requestParam(value="ǰ��name��" defaultvalue=��Ĭ��ֵ�� required=���Ƿ�Ĭ��һ��Ҫ���ݲ�����)
	public String b4(@RequestParam(value="username",defaultValue="haha" , required=false )String n
			,@RequestParam(value="pass",defaultValue="138",required=false)Integer ps) {
		System.out.println(n);
		System.out.println(ps);
		return "aaaa";
	}
	
//���ն��ֵʱ����(String[] n)  �ȼ��� Request.getparameternames	
	@RequestMapping("from111")
	public String b5(String[] n) {
		System.out.println(Arrays.toString(n));
		return "aaaa";
	}
	
//springmvc����ͨ�� ���� �������� (����� ������=ǰ��name����  ʱ��������Ҫ���ַ�������)
	@RequestMapping("/b")
	public String b(User user ) {
		System.out.println(user.getAa());
		return "aaaa";
	}
	
	/**
	 * 	��ֵ�����ַ���
	 *  1.request.setAttribute
		2.model.addAttribute("name", n);
		3.map.put("name", n);
		4.modelandview   		org.springframework.web.servlet.ModelAndView;
		5.SessionAttributes		��modelmap�����
	**/
	
//����һ	
	@RequestMapping("/b6")
	public String b6(HttpServletRequest req,@RequestParam("pass")Integer p) {
		System.out.println(req.getParameter("username"));
		System.out.println(p);
		req.setAttribute("name", "hahahahahahahaha");
		return "aaaa";
	}
	
//������
	@RequestMapping("/b7")
	public String b7(@RequestParam("username")String n,@RequestParam(value="pass",defaultValue="138"
			,required=false) Integer p,Model model) {
		System.out.println(n);
		System.out.println(p);
		model.addAttribute("name", p);
		return "aaaa";
	}
	
//������
	@RequestMapping("/b8")
	public String b8(@RequestParam("username")String n,@RequestParam("pass")Integer p,ModelMap map) {
		System.out.println(n);
		System.out.println(p);
		map.put("name", p);
		return "aaaa";
	}
	
//������
	@RequestMapping("/b9")
	public ModelAndView b9(@RequestParam("username")String n,@RequestParam("pass")Integer p) {
		System.out.println(n);
		System.out.println(p);
		ModelAndView andView = new ModelAndView();
		andView.addObject("name", p);
		andView.setViewName("aaaa");
		return andView;
	}
	
//������
	@RequestMapping("b0")
	public String b0(@RequestParam("username")String n,@RequestParam("pass")Integer p,ModelMap map) {
		System.out.println(n);
		System.out.println(p);
		map.put("name1", 123123124);
		return "aaaa";
	}
	@RequestMapping("/b00")
	public String b000() {
		return "NewFile";
	}
	
//�쳣ע��
	@ExceptionHandler(NullPointerException.class)
	public String exception() {
		return "exception111";
	}
	@RequestMapping("/b000")
	public String b000(@RequestParam("username")String n,Integer p) {
		System.out.println(n);
		System.out.println(p.toString());
		return "aaaa000";
	}
	
//ajax��ֵ
	@RequestMapping("test111")
	@ResponseBody
	public User JsonTest(String username,String password) {
		User user = new User();
		user.setAa(username);
		List<String> list = new ArrayList<String>();
		list.add("hahahah");
		list.add("lalalal");
		list.add("heiheihei");
		Map<String,Object> map= new HashMap<>();
		map.put("ooo","34092349");
		map.put("3434", "fkjsdlkjskjflkjsfask");
		user.setMap(map);
		user.setList(list);
		return user;
	}
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
