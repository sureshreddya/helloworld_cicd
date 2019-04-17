package helloboot.helloboot;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/helloboot")
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name) {
		String hostname, serverAddress;
		hostname = "error";
		serverAddress = "error";
		try {
		  InetAddress inetAddress;
		  inetAddress = InetAddress.getLocalHost();
		  hostname = inetAddress.getHostName();
		  serverAddress = inetAddress.toString();
		} catch (UnknownHostException e) {
		  e.printStackTrace();
		}
		return "Hello "+name+" !! , hostname :"+hostname+",serverAddress"+serverAddress+" ,on "+new Date();
	}

}
