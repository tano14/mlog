package ar.com.tano.mlog;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	private static final String JSON_FOLDER_PATH = "C:\\mlog";
	private static final String JSON_FILE_PATH = JSON_FOLDER_PATH + "\\mlogs.json";
	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		try {
			System.out.println("---CREANDO ARCHIVO JSON");
			File folder = new File(JSON_FOLDER_PATH);
			folder.setReadable(Boolean.TRUE);
			folder.setWritable(Boolean.TRUE);
			folder.setExecutable(Boolean.TRUE);
			folder.mkdir();
			File file = new File(JSON_FILE_PATH);
			file.setReadable(Boolean.TRUE);
			file.setWritable(Boolean.TRUE);
			file.setExecutable(Boolean.TRUE);
			if (file.createNewFile()){
				System.out.println("---ARCHIVO JSON CREADO");
			} else {
				System.out.println("---ARCHIVO JSON EXISTENTE");
			}
		} catch (IOException e) {
			System.out.println("---NO SE PUDO CREAR EL ARCHIVO JSON");
		}
	}
	

}
