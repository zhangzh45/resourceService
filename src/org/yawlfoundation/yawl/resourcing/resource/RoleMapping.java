package org.yawlfoundation.yawl.resourcing.resource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hsqldb.lib.HashSet;

public  class RoleMapping {
	InputStream is=this.getClass().getResourceAsStream("RoleMapping.xml");
    public RoleMapping() {
    }
    
    /**
     * method:getOrganizationRole
     * function:get the right organization role through the business role by parse the RoleMapping.xml
     * @param Brole business role
     * @return the right organization role
     */
    public Set<String> getOrganizeRole(String Brole){
    	SAXReader saxReader=new SAXReader();
    	Set<String> set=(Set<String>) new HashSet();
    	try {
    		File file=new File(RoleMapping.class.getResource("").getPath());//获取当前类的运行路径
    		//System.out.println(file);
			Document doc=saxReader.read(new File(file+"/RoleMapping.xml"));
			Element root=doc.getRootElement();//获取根节点
			Element businessRole=root.element("business-role");
			Iterator itElement=businessRole.elementIterator("Brole");//遍历business-role下面所有的Brole节点
			while(itElement.hasNext()){
				boolean isBrole=false;
				Element ele=(Element) itElement.next();
				Iterator itAttribute=ele.attributeIterator();
				while(itAttribute.hasNext()){
					Attribute att=(Attribute) itAttribute.next();
					String attValue=att.getValue();
				    if(attValue.equals(Brole)){
				    	isBrole=true;
				    }
				}
				if(isBrole){
					Iterator ref=ele.elementIterator("ref");
					while(ref.hasNext()){
					Element refEle=(Element) ref.next();
					Iterator refAttribute=refEle.attributeIterator();
					while(refAttribute.hasNext()){
						Attribute refAtt=(Attribute) refAttribute.next();
						String refAttValue=refAtt.getValue();
						//System.out.println(refAttValue);
						set.add(refAttValue);
						}
					}
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return set;
    }
    public void test() {
    	 ByteArrayOutputStream os=new ByteArrayOutputStream();
         byte[] buffer=new byte[1024];
         int len=-1;
         try {
			while((len=is.read(buffer))!=-1){
			 	os.write(buffer,0,len);
			 }
			 os.close();
	         is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String result=new String(os.toByteArray());
         
         System.out.println(result);
    }

}
