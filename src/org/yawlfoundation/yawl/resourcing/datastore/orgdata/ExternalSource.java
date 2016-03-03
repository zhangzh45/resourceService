package org.yawlfoundation.yawl.resourcing.datastore.orgdata;

import org.yawlfoundation.yawl.exceptions.YAuthenticationException;
import org.yawlfoundation.yawl.resourcing.resource.Participant;

public class ExternalSource extends DataSource{
	public ExternalSource(){	
	}

	@Override
	public ResourceDataSet loadResources() {
		// TODO Auto-generated method stub
		 ResourceDataSet ds = new ResourceDataSet(this) ;
		 Participant part=new Participant();
		 part.setID("12345678");
		 part.setUserID("12345678");
		 part.setFirstName("dou");
		 part.setLastName("lastname");
		 part.setPassword("12345678");
		 ds.putParticipant(part);
		 return ds;
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String insert(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importObj(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int execUpdate(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean authenticate(String userid, String password)
			throws YAuthenticationException {
		// TODO Auto-generated method stub
		return true;
	}
		
}
