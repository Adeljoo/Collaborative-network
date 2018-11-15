package Resource.bdiv3;



import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import jadex.bdiv3.annotation.Belief;
import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.Goals;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.Publish;
import jadex.bdiv3.annotation.Trigger;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.component.IRequiredServicesFeature;
/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jadex.bdiv3.annotation.Belief;
import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.PlanAborted;
import jadex.bdiv3.annotation.PlanBody;
import jadex.bdiv3.annotation.PlanFailed;
import jadex.bdiv3.annotation.PlanPrecondition;
import jadex.bdiv3.annotation.Publish;
import jadex.bdiv3.annotation.Trigger;
import jadex.bdiv3.runtime.IPlan;
import jadex.bdiv3.runtime.impl.PlanFailureException;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;*/
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.DefaultResultListener;
import jadex.commons.future.IFuture;
/*import jadex.commons.future.ExceptionDelegationResultListener;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;*/
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Description;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;


//rules
//norm 

/**
 *  BOb bdi agent.
 */



@Description("This agent provides a basic chat service.")
@Agent
@ProvidedServices(@ProvidedService(type=IlogSevice.class, 
	implementation=@Implementation(BobServiceBDI.class)))
@RequiredServices({
	@RequiredService(name="clockservice", type=IClockService.class, 
		binding=@Binding(scope=Binding.SCOPE_PLATFORM)),
	@RequiredService(name="chatservices", type=IlogSevice.class, multiple=true,
		binding=@Binding(dynamic=true, scope=Binding.SCOPE_PLATFORM)),
	@RequiredService(name="transser", type=ITranslationService.class, multiple=true,
	binding=@Binding(dynamic=true,scope=Binding.SCOPE_PLATFORM))
})
/*@Goals(@Goal(clazz=CheckGoal.class, 
publish=@Publish(type=ICheckService.class)))*/
public class BobBDI 
{
	
	
	
	}
