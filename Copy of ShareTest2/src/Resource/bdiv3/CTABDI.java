package Resource.bdiv3;

//import jadex.bdiv3.annotation.Goal;
//import jadex.bdiv3.annotation.Goals;
import jadex.bdiv3.annotation.Plan;
//import jadex.bdiv3.annotation.Publish;
import jadex.bdiv3.annotation.Trigger;
//import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.Service;
import jadex.bridge.service.types.clock.IClockService;
/*import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.commons.future.ExceptionDelegationResultListener;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;*/
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

//import java.text.DateFormat;

import java.util.HashMap;
import java.util.Map;

/**
 *  The translation agent B5.
 *  
 *  BDI goal that is automatically published as service.
 */
@Agent
@Service
@ProvidedServices(@ProvidedService(type=ITranslationService.class, 
implementation=@Implementation(value=TranslationServiceBDI.class)))
@RequiredServices({
@RequiredService(name="clockservice", type=IClockService.class, 
	binding=@Binding(scope=Binding.SCOPE_PLATFORM)),
@RequiredService(name="chatservices", type=IlogSevice.class, multiple=true,
	binding=@Binding(dynamic=true, scope=Binding.SCOPE_GLOBAL)),
@RequiredService(name="transser", type=ITranslationService.class, multiple=true,
binding=@Binding(dynamic=true,scope=Binding.SCOPE_PLATFORM))
})
/*@Goals(@Goal(clazz=UserProfile.class, 
	publish=@Publish(type=ITranslationService2.class)))//, method="translateEnglishGerman")))
*/public class CTABDI 
{
	//-------- attributes --------

/*	@Agent
	protected IInternalAccess agent;
//protected DateFormat format;
//normcondition	
	
	*//** The wordtable. *//*
	protected Map<String, String> wordtable;

	//-------- methods --------

	*//**
	 *  Create a new plan.
	 *//*
	@AgentCreated
	public void body()
	{
//		System.out.println("Created: "+this);
		this.wordtable = new HashMap<String, String>();
		this.wordtable.put("Alice", "1000");
		this.wordtable.put("Bob", "1000");
		this.wordtable.put("P2", "200");
		this.wordtable.put("P1", "50");
		this.wordtable.put("Eve", "1000");
	}
	
	*//**
	 *  Plan reacts to the automatically created 
	 *  translation goal.
	 *  @param tg The translation goal.
	 *//*
	@Plan(trigger=@Trigger(goals=UserProfile.class))
	public String translatePlan(String eword)
	{
		return  wordtable.get(eword);
	}
	*/
	
	
//	@Plan(trigger=@Trigger(goals=TranslationGoal.class))
//	public void translatePlan(TranslationGoal tg)
//	{
//		String eword = wordtable.get(tg.getEWord());
//		tg.setGWord(eword);
//	}

	
}
