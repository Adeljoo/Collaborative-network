package Resource.bdiv3;

import jadex.bridge.service.types.clock.IClockService;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Description;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

@Description("This agent offers profile information.")
@Agent
@ProvidedServices(@ProvidedService(type=IExtendedChService.class, 
	implementation=@Implementation(EveServiceBDI.class)))
@RequiredServices({
	@RequiredService(name="clockservice", type=IClockService.class, 
		binding=@Binding(scope=Binding.SCOPE_PLATFORM)),
	@RequiredService(name="chatservices", type=IExtendedChService.class, multiple=true,
		binding=@Binding(dynamic=true, scope=Binding.SCOPE_PLATFORM))
})
public class EveBDI {

}
