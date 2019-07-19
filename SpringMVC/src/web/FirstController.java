package web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.User;

@SessionAttributes({"name","","",""})//�����ݴ洢��session�У���modelmap���ʹ��
@Controller	//���������Ŀ������ܱ� dispatchservlet ������
public class FirstController {
	//@requestMapping(value="����·��"��method = ������ʽ��)
	//��springmvc�У������б��еĲ����൱��request.getparameter,���˷���������ķ����ǵȼ۵�
	/*public String aaa(HttpServletRequest request) {
		System.out.println("aaa");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("pass"));
		return "aaaa";
	}*/
	
	//ǰ��name���Ժͺ�̨������һ��
	/*public String aaa(String username,String pass) {
		System.out.println("aaa");
		System.out.println(username);
		System.out.println(pass);
		return "aaaa";
	}*/
	
	//ǰ��name���Ժͺ�̨��������һ�� ʹ�� 	  RequsetParam��"username"��
	/*public String aaa(@RequestParam("username")String n,@RequestParam("pass")String p) {
		System.out.println("aaa");
		System.out.println(n);
		System.out.println(p);
		return "aaaa";
	}*/
	
	/**
	 * ��ǰ�˴�ֵ�����ַ���
	 *  1.request.setAttribute
		2.model.addAttribute("name", n);
		3.map.put("name", n);
		4.modelandview   org.springframework.web.servlet.ModelAndView;
		5.SessionAttributes
	**/
//	2,3
	//@requestParam(value="ǰ��name��" defaultvalue=��Ĭ��ֵ�� required=���Ƿ�Ĭ��һ��Ҫ���ݲ�����)
	/*public String aaa(@RequestParam("username")String n,@RequestParam(value="pass", 
			defaultValue="1",required=false)Integer pass,Model model,ModelMap map) {
		System.out.println("aaa");
		System.out.println(n);
		System.out.println(pass);
		//model.addAttribute("name", n);
		map.put("name", n);
		pass.toString();
		return "aaaa";
	}*/
//	5
	@RequestMapping(value = "/bbb")//ǰ������·�� ��ͬ��servlet�е�@webservlet 
	public String aaa(@RequestParam("username") String n,Integer pass, Model model,
			ModelMap map) {
		System.out.println("aaa");
		System.out.println(n);
		System.out.println(pass);
		map.put("name",1);
		pass.toString();
		return "aaaa";
	}
	@RequestMapping("/ccc")
	public String ccc() {
		return "NewFile";
	}
//	4
	@RequestMapping("/bbb3")
	public ModelAndView aaa3(String username) {
		System.out.println("aaa");
		ModelAndView andView = new ModelAndView();
		andView.addObject("name", username);
		andView.setViewName("aaaa");
		return andView;
	}
	
	
	//(String[] n) �ȼ���Request.getparameternames (���ն��ֵ)
	@RequestMapping("from")
	public String aaa(String[] n) {
		System.out.println(Arrays.toString(n));
		return "aaaa";
	}
	/**
	 * @PathVariable �� restful �������ݽ��ջ��ʹ���൱��@requestParam
	 * @param age
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping("/testrest/{age}/{name}/{id}")
	public String runff( @PathVariable("age")String age, 
						 @PathVariable("name")String name,
						 @PathVariable("id")String id) {
		System.out.println(age);
		System.out.println(id);
		return "aaaa";
	}
	
	
	//�쳣ע��
	
	/**
	 * ������getCLASS
	 * 
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	public String av() {
		return "exception";
	}
	
	@RequestMapping("test")
	@ResponseBody//������ת��Ϊǰ������Ҫ�����ݣ�ssm�Դ����ַ���ת����ȥ
	public User jsonTest(String username,String password) {
		User user = new User();
		user.setAa(password);
		List<String> list = new ArrayList<String>();
		list.add("asdeer");
		list.add("345345");
		list.add("546456");
		Map<String, Object> map = new HashMap<>();
		map.put("123","456");
		map.put("32","324");
		user.setMap(map);
		user.setList(list);
		return user;
	}
}
























