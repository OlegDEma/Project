package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.VudOfFlowerService;

public class VudOfFlowerEditor extends PropertyEditorSupport {
	
	private VudOfFlowerService vudOfFlowerService;

	public void VudOfFlowerService(VudOfFlowerService vudOfFlowerService) {
		this.vudOfFlowerService = vudOfFlowerService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(vudOfFlowerService.findOne(Integer.parseInt(text)));
	}

}
