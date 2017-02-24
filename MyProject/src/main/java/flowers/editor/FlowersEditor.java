package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.FlowersService;

public class FlowersEditor extends PropertyEditorSupport{
	
private final FlowersService flowersService;
	
	public FlowersEditor(FlowersService flowersService){
		this.flowersService = flowersService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(flowersService.findOne(Integer.parseInt(text)));
	}

}
