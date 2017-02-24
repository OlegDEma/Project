package flowers.dto;

import java.util.ArrayList;
import java.util.List;

import flowers.entity.Flowers;
import flowers.entity.User;

public class DtoUtilMapper {

	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}
	
	
	
	
	public static List<FlowersDTO> flowersToflowersDTO(List<Flowers> flowers) {

		List<FlowersDTO> flowersDTOs = new ArrayList<FlowersDTO>();

		for (Flowers flower : flowers) {

			FlowersDTO flowersDTO = new FlowersDTO();
			flowersDTO.setId(flower.getId());
			flowersDTO.setName(flower.getName());
			flowersDTO.setPrice((int) flower.getPrice());
			flowersDTO.setpImage(flower.getpImage());

			flowersDTOs.add(flowersDTO);

		}

		return flowersDTOs;

	}
	
	
	
	

}
