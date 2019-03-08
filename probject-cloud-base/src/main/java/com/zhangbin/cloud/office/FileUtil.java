package com.zhangbin.cloud.office;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**文件上传下载工具类
 * @author admin
 *
 */
public class FileUtil {
	
	private static final String PATH = "files";
	/**
	 * 文件上传接口
	 * @param multipartFile
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Map<String, Object> uploadFile(MultipartFile multipartFile,String path) throws IOException {
		//文件大小限制为：4MB
		
		//原始文件名
		String originalFilename =multipartFile.getOriginalFilename();
		//新文件名
		String fileName = System.currentTimeMillis()+originalFilename;
		//文件保存路径
		String pathname = PATH+"/"+path;
		//输出文件
		File pFile= new File(pathname);
		if(!pFile.exists()) {
			pFile.mkdirs();
		}
		File file = new File(pFile, fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(file); 
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write(multipartFile.getBytes());
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		//返回数据供使用
		Map<String, Object> map = new HashMap<>();
		map.put("pathName", pathname);
		map.put("fileName", fileName);
		return map;
	}
	
	
	
}
