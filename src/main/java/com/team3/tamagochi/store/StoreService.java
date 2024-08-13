package com.team3.tamagochi.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.files.FileManager;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class StoreService {

	@Autowired
	StoreDAO storeDAO;
	
	@Autowired
	FileManager fileManager;
	
	public List<WishListDTO> getWishList (UsersDTO usersDTO) {
		return storeDAO.getWishList(usersDTO);
	}
	
	public int deleteWishList (WishListDTO wishListDTO) {
		return storeDAO.deleteWishList (wishListDTO);
	}
	
	public List<ItemFileDTO> filedetail(List<ItemDTO> list) {
		
		List<ItemFileDTO> fileList = new ArrayList<ItemFileDTO>();
		
		for(ItemDTO dto:list) {
			fileList.add(storeDAO.filedetail(dto));
		}
		
		return fileList;
		
	}

	public List<ItemDTO> getItemList(ItemDTO itemDTO, Pager pager) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		

		map.put("itemDTO", itemDTO);
		map.put("pager", pager);

		pager.makerow();
		
		Integer totalCount = storeDAO.getTotalCount(map);
		
		pager.makeNum(totalCount);
		
		
		return storeDAO.getItemList(map);
	}

	public ItemDTO getItemDetail(ItemDTO itemDTO) throws Exception {

		return storeDAO.getItemDetail(itemDTO);
	}

	public int addItem(ItemDTO itemDTO, MultipartFile file, HttpSession session) throws Exception {

		Long num = storeDAO.getNum();
		itemDTO.setItem_num(num);
		int result = storeDAO.addItem(itemDTO);
	
		if (file == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("/resources/img/item");

		System.out.println(path);
		
		String filename = fileManager.fileSave(file, path);
		
		System.out.println(filename);
		
		ItemFileDTO itemFileDTO = new ItemFileDTO();
		
		itemFileDTO.setFile_name(filename);
		itemFileDTO.setOri_name(file.getOriginalFilename());
		itemFileDTO.setItem_num(num);
		
		result = storeDAO.addfile(itemFileDTO);
		
		
		
		return result;
	}

	public int updateItem(ItemDTO itemDTO) {

		return storeDAO.updateItem(itemDTO);
	}

	public int deleteItem(ItemDTO itemDTO) {

		return storeDAO.deleteItem(itemDTO);
	}
	
	public int addWishList(WishListDTO wishListDTO) {
		return storeDAO.addWishList(wishListDTO);
	}

}
