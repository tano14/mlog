package ar.com.tano.mlog.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ar.com.tano.mlog.domain.MLog;

@Service
public class CategoryService {

	@Autowired
	private MlogService mlogServ;
	
	public Set<String> getCategories() throws IOException{
		Set<String> categories = new HashSet<>();
		
		List<MLog> mlogs = mlogServ.getMlogs();
		 
		for (MLog dto : mlogs) {
			if(!CollectionUtils.isEmpty(dto.getCategories())){
				categories.addAll(dto.getCategories());
			}
		}
		
		return categories;
	}
}
