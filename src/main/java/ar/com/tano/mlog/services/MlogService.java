package ar.com.tano.mlog.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ar.com.tano.mlog.domain.MLog;
import ar.com.tano.mlog.domain.MLogDTO;

@Service
public class MlogService {
	private static final String JSON_FOLDER_PATH = "C:\\mlog";
	private static final String JSON_FILE_PATH = JSON_FOLDER_PATH + "\\mlogs.json";
	Gson gson;
	
	public MlogService(){
		gson = new Gson();
	}
	
	public List<MLogDTO> getMlogsDTO() throws IOException{
		List<MLogDTO> mlogs = new ArrayList<MLogDTO>();
		mlogs = mlogListAdapter(getMLogsFromJson());
		return mlogs;
	}
	
	public List<MLog> getMlogs() throws IOException{
		return getMLogsFromJson();
	}
	
	public MLog createMlog(MLogDTO mlogDto) throws IOException {
		MLog mlog = mlogDTOAdapter(mlogDto);
		List<MLog> mlogs = getMLogsFromJson();
		Long max = 0L;
		if(!mlogs.isEmpty()){
			max = Collections.max(mlogs, Comparator.comparing(c -> c.getId())).getId();
		}
		mlog.setId(++max);
		mlogs.add(mlog);
		setMLogsIntoJson(mlogs);
		return mlog;
	}
	
	public MLogDTO updateMlog(MLogDTO mlogDto) throws IOException {
		MLog mlog = mlogDTOAdapter(mlogDto);
		List<MLog> logs = getMLogsFromJson();
		MLog oldLog = logs.stream().filter(b -> b.getId() == mlog.getId()).findFirst().get();
		logs.remove(oldLog);
		logs.add(mlog);
		setMLogsIntoJson(logs);
		return mlogAdapter(mlog);
	}
	
	public void removeMlog(Long id) throws IOException{
		List<MLog> logs = getMLogsFromJson();
		MLog mlogToRemove = logs.stream().filter(b -> b.getId() == id).findFirst().get();
		logs.remove(mlogToRemove);
		
		setMLogsIntoJson(logs);
	}
	private List<MLog> getMLogsFromJson() throws IOException {
		List<MLog> mlogs;
		try{
			BufferedReader br = new BufferedReader(new FileReader(JSON_FILE_PATH));
			mlogs = gson.fromJson(br, new TypeToken<List<MLog>>(){}.getType());
		} catch (NullPointerException npe){
			mlogs = new ArrayList<>();
		}
		if(mlogs == null){
			mlogs = new ArrayList<>();
		}
		return mlogs;
	}
	
	private void setMLogsIntoJson(List<MLog> mlogs) throws IOException {
		FileWriter writer = new FileWriter(JSON_FILE_PATH);
		writer.write(gson.toJson(mlogs));
		writer.close();
	}
	
	private MLog mlogDTOAdapter(MLogDTO dto){
		MLog mlog = new MLog();
		
		mlog.setId(dto.getId());
		mlog.setContent(dto.getContent());
		mlog.setTitle(dto.getTitle());
		if(dto.getId()!=null){
			mlog.setPublicationDate(dto.getPublicationDate());
		}else{
			mlog.setPublicationDate(new Date());
		}
		
		mlog.setCategories(dto.getCategories());
		
		return mlog;
	}
	
	private MLogDTO mlogAdapter(MLog mlog){
		MLogDTO dto = new MLogDTO();
		copyObjects(dto, mlog);
		return dto;
	}
	
	private List<MLogDTO> mlogListAdapter(List<MLog> mlogs){
		List<MLogDTO> mlogsDTO = new ArrayList<MLogDTO>();
		MLogDTO dto;
		for (MLog mlog : mlogs) {
			dto = new MLogDTO();
			copyObjects(dto, mlog);
			
			mlogsDTO.add(dto);
		}
		
		return mlogsDTO;
	}

	private void copyObjects(MLogDTO dto, MLog mlog) {
		dto.setId(mlog.getId());
		dto.setTitle(mlog.getTitle());
		dto.setContent(mlog.getContent());
		dto.setPublicationDate(mlog.getPublicationDate());
		if(!CollectionUtils.isEmpty(mlog.getCategories())){
			dto.setCategories(mlog.getCategories());
		}
		dto.setMainImage(mlog.getMainImage());
		dto.setModificationDate(mlog.getModificationDate());
	}

	public MLogDTO getMlog(Long id) throws IOException {
		List<MLog> logs = getMLogsFromJson();
		return mlogAdapter(logs.stream().filter(b -> b.getId() == id).findFirst().get());
	}
}
