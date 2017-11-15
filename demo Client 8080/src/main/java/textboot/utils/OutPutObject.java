package textboot.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OutPutObject {
	private static Log log=LogFactory.getLog(OutPutObject.class);
	public static void printjson(HttpServletResponse response,String message){
		
		response.setContentType("text/html;charset=utf-8");
		JSONObject json = JSONObject.fromObject(message);
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			System.out.println("result:"+json);
			log.info("result:"+json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printstr(HttpServletResponse response,String message){
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(message);
			log.info("result:"+message);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printjson(HttpServletResponse response,Map objMap){
		response.setContentType("text/html;charset=utf-8");
		JSONArray json = JSONArray.fromObject(objMap);
		try {
			PrintWriter out = response.getWriter();
			out.print(json);
			System.out.println(json);
			log.info("result:"+json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printString(HttpServletResponse response,String result){
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(result);
			System.out.println(result);
			log.info("result:"+result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printjson(HttpServletResponse response,List objList){
		response.setContentType("text/html;charset=utf-8");
		JSONArray jsonArray = JSONArray.fromObject(objList);
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonArray);
			log.info("result:"+jsonArray);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
