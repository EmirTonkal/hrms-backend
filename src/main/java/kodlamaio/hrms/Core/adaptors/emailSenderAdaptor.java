package kodlamaio.hrms.Core.adaptors;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.zemailVerification.emailSender;

@Service
public class emailSenderAdaptor implements emailAdaptor {

	emailSender emailS = new emailSender();
	
	@Override
	public boolean emailSend(String email) {


		return emailS.emailVerification(email);
		
		
	}

}
