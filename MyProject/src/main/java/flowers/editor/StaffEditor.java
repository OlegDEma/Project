package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.StaffService;

public class StaffEditor extends PropertyEditorSupport{
	
	private StaffService staffService;

	public void StaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(staffService.findOne(Integer.parseInt(text)));
	}

}
