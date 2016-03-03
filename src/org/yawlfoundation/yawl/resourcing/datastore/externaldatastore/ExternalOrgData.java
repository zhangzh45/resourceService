package org.yawlfoundation.yawl.resourcing.datastore.externaldatastore;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/*
 * [Apache提供]直接通过AXIS调用远程的web service
 * */

public  class ExternalOrgData {

	private static final String endpoint = "http://127.0.0.1:8080/SSH_Prototype_J2EE_5.0/GetServiceInfoPort?wsdl";
	private static Call call;
	public static Call getCallInstance(){
		  try
		  {
			  if(call==null){
				  Service service = new Service();
		          call = (Call) service.createCall();
		          call.setTargetEndpointAddress(endpoint);
			  }          
		  }
		  catch (Exception e) 
		  {
            System.err.println(e.toString()); 
		  }
		  return call;	  
	}	
}

