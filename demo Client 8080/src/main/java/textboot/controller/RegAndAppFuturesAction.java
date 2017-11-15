package textboot.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;  
import java.util.Map;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

import Decoder.BASE64Decoder;

import textboot.bean.TbClientTax;
import textboot.bean.TbClientTaxInfo;
import textboot.dao.TbtaxDAO;
import textboot.dao.TbtaxInfoDAO;

  

@RestController  
@RequestMapping("kiiik")  
public class RegAndAppFuturesAction{
	
	
	
	@Autowired  
	private TbtaxDAO tbtaxdao;
	@Autowired 
	private TbtaxInfoDAO tbtaxinfodao;
	
	@Value("${server.port}")
    String port;
	
	@RequestMapping("findtax")  
    public Map<String, Object> findTax(@RequestParam  String mobile)  {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list =new ArrayList<Object>();
        list=tbtaxinfodao.findTaxInfoByMobile(mobile);
        List<Object> listTax=new ArrayList<Object>();//保存数据库中取到并遍历的涉税信息
		TbClientTax clientTax = tbtaxdao.findClientTaxByMobile(mobile); 
		try {
			//TbClientTax clientTax = null;
			/*if (request.getParameter("mobile") != null
					&& !request.getParameter("mobile").equals("")) {
				mobile = request.getParameter("mobile");
				clientTax=(TbClientTax) applicationService.findClientTaxByMobile(mobile);
			}*/
			if (clientTax != null) {									
				if(list.size()>0&&list!=null){								
					for(int i=0;i<list.size();i++){
						Map<String, Object> maps = new HashMap<String, Object>();
						Object[] obj=(Object[]) list.get(i);
						maps.put("tax_country",obj[0]);
						maps.put("cause", obj[1] == null ? "" :obj[1]);
						maps.put("tax_num", obj[2] == null ? "" :obj[2]);
						maps.put("tax_create_time",obj[3]);
						listTax.add(maps);
					}									
				}									
				map.put("message", "getTaxInfoByMobile");
				map.put("result", "success");
				map.put("tax_resident_type", clientTax.getTax_resident_type());
				map.put("bor_country", clientTax.getBor_country());
				map.put("bor_pro", clientTax.getBor_pro());
				map.put("bor_city", clientTax.getBor_city());
				map.put("bor_area", clientTax.getBor_area());
				map.put("tax_job",clientTax.getTax_job());
				map.put("contact_pro", clientTax.getContact_pro());
				map.put("contact_city", clientTax.getContact_city());
				map.put("contact_area", clientTax.getContact_area());
				if(list!=null&&list.size()>0){
					map.put("tax", listTax);
				}else{
					map.put("tax", "");
				}
			} else {
				map.put("message", "getTaxInfoByMobile");
				map.put("result", "success");
				map.put("tax_resident_type", null);
				map.put("bor_country",null);
				map.put("bor_pro", null);
				map.put("bor_city", null);
				map.put("bor_area", null);
				map.put("tax_job",null);
				map.put("contact_pro", null);
				map.put("contact_city", null);
				map.put("contact_area", null);
				map.put("tax", "");											
			}
		} catch (Exception ex) {
			map.put("message", "getTaxInfoByMobile");
			map.put("result", "fail");
			map.put("reason", "系统异常！程序错误！");
			ex.printStackTrace();
		}
		map.put("port", port);
       return map;
    }  
	
	@RequestMapping("savetax")
	public Map<String, Object> regSaveTaxInfo(String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<TbPersonClient> personlist =new ArrayList<TbPersonClient>();
		try {
			String tax="";
			String mobile = "";
			String tax_country = "";
			String tax_num = "";
			String cause = "";
			String bor_country = "";
			String bor_pro = "";
			String bor_city = "";
			String bor_area = "";
			String tax_resident_type = "";
			String tax_job = "";
			String contact_pro = "";
			String contact_city = "";
			String contact_area = "";
			TbClientTax clientTax=null; 
			
			//String msg=request.getParameter("msg");
			//将base64替换成的空格，再次换回+
			msg= msg.replaceAll(" ", "+");
			System.out.println(msg);
			// decode数据
			BASE64Decoder de = new BASE64Decoder();
			//得到json数组
			String jsonStr=new String(de.decodeBuffer(msg), "UTF-8");
			System.out.println("decodeJson= "+jsonStr);
			JSONObject json = JSONObject.fromObject(jsonStr);
			System.out.println("Json= ===>"+json);
			String tax_create_time =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			tax_resident_type=json.getString("tax_resident_type");
			System.out.println("jijii====="+tax_resident_type);
			mobile=json.getString("mobile");
			System.out.println("mobile======"+mobile);
			if(json.has("bor_country")){
				bor_country=json.getString("bor_country");
			}
			if(json.has("bor_pro")){
				bor_pro=json.getString("bor_pro");
			}
			if(json.has("bor_city")){
				bor_city=json.getString("bor_city");
			}
			if(json.has("bor_area")){
				bor_area=json.getString("bor_area");
			}
			
			
			tax_job=json.getString("tax_job");
			
			contact_pro=json.getString("contact_pro");
			contact_city=json.getString("contact_city");
			contact_area=json.getString("contact_area");
			
			
			if(json.has("tax")){
				tax=json.getString("tax");
			
			System.out.println("tax----------------------->"+tax);
			JSONArray jsontax = JSONArray.fromObject(tax);
			System.out.println("jsontax="+jsontax);
			
			if(jsontax!=null){
				for(int i=0;i<jsontax.size();i++){
					JSONObject obj=JSONObject.fromObject(jsontax.getJSONObject(i));
					System.out.println("obj="+obj);
					tax_country=obj.getString("tax_country");
					System.out.println("country="+tax_country);
					tax_num=obj.getString("tax_num");
					cause=obj.getString("cause");
					System.out.println("tax_num="+tax_num);
					System.out.println("cause="+cause);
					if(tax_country.equals("")||tax_country==null){continue;}
					if(((tax_num.equals("")||tax_num==null) && !cause.equals(""))||(!tax_num.equals("") && (cause==null||cause.equals("")))){
						TbClientTaxInfo tTax = new TbClientTaxInfo();
						tTax.setTax_create_time(tax_create_time);
						tTax.setMobile(mobile);
						tTax.setTax_country(tax_country);
						tTax.setTax_num(tax_num);
						tTax.setCause(cause);
						tbtaxinfodao.save(tTax);
						//applicationService.save(tTax);
					}else{	
						map.put("message", "regSaveTaxInfo");
						map.put("result", "fail");
						map.put("reason", "请填写纳税识别号，如果不能提供纳税识别号，请填写原因！！");
						//OutPutObject.printjson(response, map);
						return map;
					}
				}
			}
			}
			if (mobile != null) {
				clientTax=(TbClientTax) tbtaxdao.findClientTaxByMobile(mobile);
				if(clientTax!=null){		
						clientTax.setMobile(mobile);							
						clientTax.setTax_resident_type(tax_resident_type);							
						clientTax.setBor_country(bor_country);							
						clientTax.setBor_pro(bor_pro);						
						clientTax.setBor_city(bor_city);						
						clientTax.setBor_area(bor_area);						
						clientTax.setTax_job(tax_job);					
						clientTax.setContact_pro(contact_pro);						
						clientTax.setContact_city(contact_city);						
						clientTax.setContact_area(contact_area);
						clientTax.setCreate_time_of_tax(tax_create_time);
					tbtaxdao.save(clientTax);
				}else if(clientTax==null){
					TbClientTax clientTaxnew=new TbClientTax();
					clientTaxnew.setMobile(mobile);
					System.out.println("mobile====="+mobile);					
					clientTaxnew.setTax_resident_type(tax_resident_type);
					System.out.println("tax_resident_type========="+tax_resident_type);						
					clientTaxnew.setBor_country(bor_country);
					System.out.println("bor_country========"+bor_country);						
					clientTaxnew.setBor_pro(bor_pro);
					System.out.println("bor_pro========"+bor_pro);					
					clientTaxnew.setBor_city(bor_city);
					System.out.println("bor_city========"+bor_city);					
					clientTaxnew.setBor_area(bor_area);
					System.out.println("bor_area========"+bor_area);						
					clientTaxnew.setTax_job(tax_job);
					System.out.println("tax_job========"+tax_job);			
					clientTaxnew.setContact_pro(contact_pro);
					System.out.println("contact_pro========"+contact_pro);					
					clientTaxnew.setContact_city(contact_city);
					System.out.println("contact_city========"+contact_city);					
					clientTaxnew.setContact_area(contact_area);
					System.out.println("contact_area========"+contact_area);
					clientTaxnew.setCreate_time_of_tax(tax_create_time);
					System.out.println("Create_time_of_tax========"+tax_create_time);
					tbtaxdao.save(clientTaxnew);
				}
				map.put("message", "regSaveTaxInfo");
				map.put("result", "success");	
			} 
		} catch (Exception ex) {
			map.put("message", "regSaveTaxInfo");
			map.put("result", "fail");
			map.put("reason", "系统异常！程序错误！");
			//OutPutObject.printjson(response, map);
			ex.printStackTrace();
		}
		//OutPutObject.printjson(response, map);
		return map;
	}
	
	
}





