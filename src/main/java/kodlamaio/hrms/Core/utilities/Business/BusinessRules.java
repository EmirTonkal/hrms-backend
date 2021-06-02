package kodlamaio.hrms.Core.utilities.Business;

import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;

public class BusinessRules {

	 public static Result run(Result... logics){
	        for(Result logic:logics){
	            if(!logic.isSuccess()){
	                return logic;
	            }
	        }
	        return new SuccessResult();
	    }
	
}
