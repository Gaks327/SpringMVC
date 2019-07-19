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

//在springMVC中，参数列表中的参数 等价于 request.getparameter("")
	@RequestMapping("/b2") //@requestMapping(value="请求路径"，method="请求方式")
	public String b2(HttpServletRequest req) {
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("pass"));
		return "aaaa";
	}
	
//前端属性与后台参数名一致时
	@RequestMapping("/b3")
	public String b3(String username,String pass) {
		System.out.println(username);
		System.out.println(pass);
		return"aaaa";
	}
	
//前端属性和后台参数名不一致时 使用@RequestParam 注解
	@RequestMapping("/b4")	//@requestParam(value="前端name名" defaultvalue=“默认值” required=“是否默认一定要传递参数”)
	public String b4(@RequestParam(value="username",defaultValue="haha" , required=false )String n
			,@RequestParam(value="pass",defaultValue="138",required=false)Integer ps) {
		System.out.println(n);
		System.out.println(ps);
		return "aaaa";
	}
	
//接收多个值时，用(String[] n)  等价于 Request.getparameternames	
	@RequestMapping("from111")
	public String b5(String[] n) {
		System.out.println(Arrays.toString(n));
		return "aaaa";
	}
	
//springmvc可以通过 对象 接收数据 (对象的 属性名=前端name属性  时间类型需要用字符串接收)
	@RequestMapping("/b")
	public String b(User user ) {
		System.out.println(user.getAa());
		return "aaaa";
	}
	
	/**
	 * 	传值的五种方法
	 *  1.request.setAttribute
		2.model.addAttribute("name", n);
		3.map.put("name", n);
		4.modelandview   		org.springframework.web.servlet.ModelAndView;
		5.SessionAttributes		与modelmap相配合
	**/
	
//方法一	
	@RequestMapping("/b6")
	public String b6(HttpServletRequest req,@RequestParam("pass")Integer p) {
		System.out.println(req.getParameter("username"));
		System.out.println(p);
		req.setAttribute("name", "hahahahahahahaha");
		return "aaaa";
	}
	
//方法二
	@RequestMapping("/b7")
	public String b7(@RequestParam("username")String n,@RequestParam(value="pass",defaultValue="138"
			,required=false) Integer p,Model model) {
		System.out.println(n);
		System.out.println(p);
		model.addAttribute("name", p);
		return "aaaa";
	}
	
//方法三
	@RequestMapping("/b8")
	public String b8(@RequestParam("username")String n,@RequestParam("pass")Integer p,ModelMap map) {
		System.out.println(n);
		System.out.println(p);
		map.put("name", p);
		return "aaaa";
	}
	
//方法四
	@RequestMapping("/b9")
	public ModelAndView b9(@RequestParam("username")String n,@RequestParam("pass")Integer p) {
		System.out.println(n);
		System.out.println(p);
		ModelAndView andView = new ModelAndView();
		andView.addObject("name", p);
		andView.setViewName("aaaa");
		return andView;
	}
	
//方法五
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
	
//异常注解
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
	
//ajax传值
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
