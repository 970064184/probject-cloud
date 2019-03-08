package com.zhangbin.cloud.office;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressBase.CellPosition;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.exception.BusinessException;

/**excel 导入功能
 * @author admin
 *
 */
public class ExcelUtil {
	
	private static final int DEFAULT_START_LINE = 0;
	/**
	 * excel导入功能
	 * @param in
	 * @param clazz
	 * @param startLine
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static <T> List<T> convertSheetToList(InputStream in,Class<T>clazz,int startLine) throws IOException, Exception{
		
		List<T> list = new ArrayList<>();
		Workbook wb = new XSSFWorkbook(in);
		if(null != wb) {
			
			Sheet sheet = wb.getSheetAt(0);
			int count = sheet.getLastRowNum();
			if(startLine <0) {
				startLine = DEFAULT_START_LINE;
			}
			for (int i = startLine; i <= count; i++) {
				Row row = sheet.getRow(i);
				if(row == null) {
					continue;
				}
				T obj = convertLineToObj(clazz,row);
				if(obj == null) {
					continue;
				}
				list.add(obj);
			}
		}
		return list;
	}

	private static <T> T convertLineToObj(Class<T> clazz, Row row) throws InstantiationException, IllegalAccessException {
		T obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			 ExcelImport annotation  = field.getAnnotation(ExcelImport.class);
			 if(annotation !=null && row.getLastCellNum() >= annotation.columIndex()) {
				 //每行对应的单元格遍历
				 Cell cell = row.getCell(annotation.columIndex());
				 if(cell ==null) {
					 throw new BusinessException(CodeEnum.SYSTEM_EXCEL_IMPORT_ERROR);
				 }
				 field.setAccessible(true);
				 field.set(obj, getCellValue(cell));
			 }
			 
		}
		return obj;
	}

	private static Object getCellValue(Cell cell) {
		if(cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == CellType.NUMERIC) {
			DecimalFormat df = new DecimalFormat("0.00");
			String str = df.format(cell.getNumericCellValue());
			return str;
		}
		return String.valueOf(cell.getStringCellValue());
	}
	/**
	 * Excel导出，不加密
	 * @param <T>
	 * @param title 表格标题名
	 * @param headersName 表格属性列名数组
	 * @param headersId 表格属性列名对应的字段---你需要导出的字段名（为了更灵活控制你想要导出的字段）
	 * @param dtoList 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象（任意类型，例如实体和Map集合都行）
	 * @param response 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @return
	 * @throws Exception
	 */
    public  <T> String exportXExcel(String title, String[] headersName,String[] headersId,
                            List<T> dtoList,HttpServletResponse response) throws Exception {
    	return excleHandler(title, headersName, headersId, dtoList,ExcelEncrypt.NO,null, response);
    }
    
    /**
	 * Excel导出，会根据密码进行加密
     * @param <T>
	 * @param title 表格标题名
	 * @param headersName 表格属性列名数组
	 * @param headersId 表格属性列名对应的字段---你需要导出的字段名（为了更灵活控制你想要导出的字段）
	 * @param dtoList 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象（任意类型，例如实体和Map集合都行）
	 * @param password 密码
	 * @param response 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @return
	 * @throws Exception
	 */
    public  <T> String exportXExcel(String title, String[] headersName,String[] headersId,
                            List<T> dtoList,String password,HttpServletResponse response) throws Exception {
    	return excleHandler(title, headersName, headersId, dtoList,ExcelEncrypt.YES,password, response);
    }

	private <T> String excleHandler(String title, String[] headersName, String[] headersId, List<T> dtoList,ExcelEncrypt excelEncrypt,String password,
			HttpServletResponse response)
			throws IllegalAccessException, GeneralSecurityException, InvalidFormatException {
		/*（一）表头--标题栏*/
        Map<Integer, String> headersNameMap = new HashMap<>();
        int key=0;
        for (int i = 0; i < headersName.length; i++) {
            if (!headersName[i].equals(null)) {
                headersNameMap.put(key, headersName[i]);
                key++;
            }
        }
        /*（二）字段*/
        Map<Integer, String> titleFieldMap = new HashMap<>();
        int value = 0;
        for (int i = 0; i < headersId.length; i++) {
            if (!headersId[i].equals(null)) {
                titleFieldMap.put(value, headersId[i]);
                value++;
            }
        }
        /* （三）声明一个工作薄：包括构建工作簿、表格、样式*/
        XSSFWorkbook  wb = new XSSFWorkbook ();
        XSSFSheet  sheet = wb.createSheet(title);
//        sheet.setDefaultColumnWidth((short)15);
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        CellStyle  style = wb.createCellStyle();
        XSSFRow  row = sheet.createRow(0);
//        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell;
        Collection<String> c = headersNameMap.values();//拿到表格所有标题的value的集合
        Iterator<String> it = c.iterator();//表格标题的迭代器
        /*（四）导出数据：包括导出标题栏以及内容栏*/
        //根据选择的字段生成表头
//        short size = 0;
        int size = 0;
        while (it.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(it.next().toString());
            cell.setCellStyle(style);
            size++;
        }
        //表格标题一行的字段的集合
        Collection<String> zdC = titleFieldMap.values();
        Iterator<T> labIt = dtoList.iterator();//总记录的迭代器
        int zdRow =0;//列序号
        while (labIt.hasNext()) {//记录的迭代器，遍历总记录
            int zdCell = 0;
            zdRow++;
            row = sheet.createRow(zdRow);
            T l = (T) labIt.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            String className = l.getClass().getName();
            if ("java.util.HashMap".equals(className) || "java.util.LinkedHashMap".equals(className)){
            	 Map<String, Object> mapTemp=(Map<String, Object>) l;
            	Iterator<String> zdIt = zdC.iterator();//一条记录的字段的集合的迭代器
            	while (zdIt.hasNext()) {
                    String tempField =zdIt.next();//字段的暂存
                    Object temvalue=mapTemp.get(tempField);
                    if (temvalue == null) {
                    	temvalue="";
                    }
                    row.createCell(zdCell).setCellValue(temvalue.toString());//写进excel对象
                    zdCell++;
                }
            }else{
            	 Field[] fields = l.getClass().getDeclaredFields();	
                 for(String column:headersId){
                 	for (Field field : fields) {
                 		if (column.equals(field.getName())) {
                 			field.setAccessible(true);
                 			Object textVal = null;
                 			textVal = field.get(l);
                 			if (textVal == null) {
                 				textVal = "";
     						}
                 			 row.createCell(zdCell).setCellValue(textVal.toString());//写进excel对象
                              zdCell++;
                 		}
     				}
                 }	
            }
        }
        try {
        	OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename="+title+".xlsx");
            response.setContentType("application/msexcel");
        	if(ExcelEncrypt.YES==excelEncrypt){
	            ByteArrayOutputStream bout = new ByteArrayOutputStream();
	            wb.write(bout);
	            bout.flush();
	            ByteArrayInputStream workbookinput = new ByteArrayInputStream(bout.toByteArray());
	            POIFSFileSystem fs = new POIFSFileSystem();
	            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
	            Encryptor enc = info.getEncryptor();
	            enc.confirmPassword(password);
	            OutputStream os = enc.getDataStream(fs);
	            OPCPackage opc = OPCPackage.open(workbookinput);
	            opc.save(os);
	            fs.writeFilesystem(output);
	            
	            fs.close();
	            output.close();
	            opc.close();
	            workbookinput.close();
	            bout.close();
        	}else{
 	           wb.write(output);
 	           wb.close();
 	           output.close();
        	}
          //  os.close();
           /* OutputStream os = enc.getDataStream(fs);
            opc.save(os);
            opc.close();*/
           
            System.out.println("导出成功!");
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        }
		return title;
	}
	
    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出
     *导出xls
     * title         表格标题名
     * headersName  表格属性列名数组
     * headersId    表格属性列名对应的字段---你需要导出的字段名（为了更灵活控制你想要导出的字段）
     *  dtoList     需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象（任意类型，例如实体和Map集合都行）
     *  out         与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param <T>
	 * @return 
	 * @throws Exception 
     */
    public  <T> String exportExcel(String title, List<String> headersName,List<String> headersId,
                            List<T> dtoList) throws Exception {
    	/*（一）表头--标题栏*/
        Map<Integer, String> headersNameMap = new HashMap<>();
        int key=0;
        for (int i = 0; i < headersName.size(); i++) {
            if (!headersName.get(i).equals(null)) {
                headersNameMap.put(key, headersName.get(i));
                key++;
            }
        }
        /*（二）字段*/
        Map<Integer, String> titleFieldMap = new HashMap<>();
        int value = 0;
        for (int i = 0; i < headersId.size(); i++) {
            if (!headersId.get(i).equals(null)) {
                titleFieldMap.put(value, headersId.get(i));
                value++;
            }
        }
        /* （三）声明一个工作薄：包括构建工作簿、表格、样式*/
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(title);
//        sheet.setDefaultColumnWidth((short)15);
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = wb.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell;
        Collection<String> c = headersNameMap.values();//拿到表格所有标题的value的集合
        Iterator<String> it = c.iterator();//表格标题的迭代器
        /*（四）导出数据：包括导出标题栏以及内容栏*/
        //根据选择的字段生成表头
//        short size = 0;
        int size = 0;
        while (it.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(it.next().toString());
            cell.setCellStyle(style);
            size++;
        }
        //表格标题一行的字段的集合
        Collection<String> zdC = titleFieldMap.values();
        Iterator<T> labIt = dtoList.iterator();//总记录的迭代器
        int zdRow =0;//列序号
        while (labIt.hasNext()) {//记录的迭代器，遍历总记录
            int zdCell = 0;
            zdRow++;
            row = sheet.createRow(zdRow);
            T l = (T) labIt.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            String className = l.getClass().getName();
            if ("java.util.HashMap".equals(className) || "java.util.LinkedHashMap".equals(className)){
            	Map<String, Object> mapTemp=(Map<String, Object>) l;
            	Iterator<String> zdIt = zdC.iterator();//一条记录的字段的集合的迭代器
            	while (zdIt.hasNext()) {
            		 String tempField =zdIt.next();//字段的暂存
                     Object temvalue=mapTemp.get(tempField);
                     if (temvalue == null) {
                     	temvalue="";
                     }
                     row.createCell(zdCell).setCellValue(temvalue.toString());//写进excel对象
                     zdCell++;
                }
            }else{
            	Field[] fields = l.getClass().getDeclaredFields();//获得JavaBean全部属性
            	for (short i = 0; i < fields.length; i++) {//遍历属性，比对
                Field field = fields[i];
                String fieldName = field.getName();//属性名
                Iterator<String> zdIt = zdC.iterator();//一条字段的集合的迭代器
                while (zdIt.hasNext()) {//遍历要导出的字段集合
                    if (zdIt.next().equals(fieldName)) {//比对JavaBean的属性名，一致就写入，不一致就丢弃
                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);//拿到属性的get方法
                        Class tCls = l.getClass();//拿到JavaBean对象
                        try {
                            Method getMethod = tCls.getMethod(getMethodName,
                                    new Class[] {});//通过JavaBean对象拿到该属性的get方法，从而进行操控
                            Object val = getMethod.invoke(l, new Object[] {});//操控该对象属性的get方法，从而拿到属性值
                            String textVal = null;
                            if (val!= null) {
                                textVal = String.valueOf(val);//转化成String
                            }else{
                                textVal = null;
                            }
//                            row.createCell((short) zdCell).setCellValue(textVal);//写进excel对象
                            row.createCell(zdCell).setCellValue(textVal);//写进excel对象
                            zdCell++;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            }
        }
        try {
        	File desktopDir = FileSystemView.getFileSystemView()
                    .getHomeDirectory();
        	String desktopPath = desktopDir.getAbsolutePath();
            FileOutputStream exportXls = new FileOutputStream(desktopPath+"\\"+title+".xls");
            wb.write(exportXls);
            exportXls.close();
            System.out.println("导出成功!");
            return desktopPath+"\\"+title+".xls";
        } catch (FileNotFoundException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        }
		return title;
    }

	/**
	 * 给xlsx的Excel文件设置打开文件的密码
	 * 
	 * @param excelFilePath
	 *            文件路径
	 * @param excelPassword
	 *            打开文件的密码
	 * @throws Exception
	 */
	public static void encryptExcel(String excelFilePath, String excelPassword) throws Exception {
		File fileSoucre = new File(excelFilePath);
		// Add password protection and encrypt the file
		POIFSFileSystem fs = new POIFSFileSystem();
		// EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
		EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
		Encryptor enc = info.getEncryptor();

		// set the password
		enc.confirmPassword(excelPassword);

		// encrypt the file
		OPCPackage opc = OPCPackage.open(fileSoucre, PackageAccess.READ_WRITE); // 文件只读
																			// （READ_WRITE
																			// 可读可写）
		OutputStream os = enc.getDataStream(fs);
		opc.save(os);
		opc.close();

		// save the file back to the filesystem
		FileOutputStream fos = new FileOutputStream(fileSoucre);
		fs.writeFilesystem(fos);
		fos.close();
	}
}
