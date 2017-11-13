package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;


public class MakeIbator
{
	
	public static void createSql(String dbUser,String Dbpwd,String dbUrl){
		 	String sql = "select a.COLUMN_NAME,a.DATA_TYPE,a.DATA_LENGTH,a.NULLABLE,COMMENTS from all_tab_columns a ,all_col_comments b where "
             + " a.Table_Name=b.table_Name and a.column_name=b.column_name and a.Table_Name=? and a.owner=b.owner and a.owner=?";
		 	Connection con = null;
		 	try{
		 		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 		con = DriverManager.getConnection(dbUrl, dbUser, Dbpwd);
		 	}catch(Exception ex){
		 		
		 	}finally{
		 		try{
		 		if(con != null){
		 			con.close();
		 		}}catch(Exception ex){
		 			
		 		}
		 	}
 
	}
	
    public static void main(String[] args)
    {
        String xml = "";       
        try
        {
        	//java文件运行路径
        	String javaHome = "E://Java//jdk1.6//bin//java";
        	//ibator 工具目录位置
        	String ibator = "D:\\\\mybator";
        	//项目名称
        	String appName = "FilmSys";
        	//数据库连接地址
            String dbUrl = "jdbc:mysql://localhost:3306/filmdb";
            //数据库用户名            
            String dbUser = "root";
            //数据库密码
            String dbPwd = "14789";
            //项目包名
            String packages ="com.film";
            
            
            //SQL文件位置
            File b = new File("D:\\tab_order.sql");
            BufferedReader bis = new BufferedReader(new FileReader(b));
            String t = "";
            
            boolean start = false;
            while ((t = bis.readLine()) != null)
            {
                 if(!start && t.indexOf("create")>-1 && t.indexOf("table")>-1)
                 {                     
                     start = true;
                    
                     String tableName = t.substring(t.indexOf("table")+6,t.indexOf("(")).trim();                     
                     String tableBean = "";
                     
                     char[] tt = tableName.toCharArray();                     
                     boolean tmpFlag = true;
                     int st = tableName.indexOf("_")+1;
                     for (int i = st; i < tt.length; i++)
                     {
                         if(tmpFlag)
                         {
                             tableBean += String.valueOf(tt[i]).toUpperCase();
                             tmpFlag = false;
                         }
                         else
                         {
                             if(tt[i] == '_')
                             {
                                 tmpFlag = true;
                                 continue;
                             }
                             else
                                 tableBean += String.valueOf(tt[i]);
                         }
                     }
                     
                     tableBean += "Bean";
                     System.out.println("<sqlMap url=\"file:///${contextRealPath}/WEB-INF/config/sqlmap/autogenerate/"+tableName.toUpperCase()+"_SqlMap.xml\"/>");
                     xml += "<table tableName=\""+tableName+"\" domainObjectName=\""+tableBean+"\">\n\t<property name=\"useActualColumnNames\" value=\"false\"/>\n";
//                     System.out.println(tableName.toUpperCase());
                 }
                 else
                 {
                 if(start)
                 {
                     if(t.indexOf("primary")>-1)
                     {

                         //xml += "\t<generatedKey column=\""+t.substring(t.indexOf("primary key")+11,t.indexOf(")")).trim().replaceAll("\\(", "")+"\" sqlStatement=\"ORACLE\" identity=\"true\" />\n" ;
                         if(t.indexOf(");")>-1)
                         {
                             start = false;
                             xml +="</table>\n";
                         }
                         continue;
                     }
                     if(t.indexOf(");")>-1)
                     {
                         start = false;
                         xml +="</table>\n";
                         continue;
                     }
                     
                     //处理特殊类型
                     t = t.replaceAll("long varchar", "longvarchar");
                     
                     t = t.replaceAll("\t", "*");
                     
                     String tmp = t.replaceAll(" ", "*");
                     
                    
                     String[] bb = tmp.split("\\*");           
                     String field  = "";
                     String dataType = "";
                     for (int i = 0; i < bb.length; i++)
                     {   
                         
                         
                         if(field.equals("") && !bb[i].equals(""))
                         {
                             field = bb[i].trim();
                            // field = field.replaceAll(" ", "");
                             continue;
                         }
                         else if(dataType.equals("") && !bb[i].equals(""))
                         {
                             dataType = bb[i].trim().toUpperCase();
                             break;
                         }
                     }
                     
                     
                     
                     if(dataType.indexOf("NUMBER(") > -1){                    	 
                    	 dataType = dataType.replace("),", "");                    	 
                    	 if(dataType.indexOf(',')>-1){
                    		 dataType = "DOUBLE";
                    	 }
                     }
                     
                     //System.out.println("dataType==" + dataType);
                     
                     if(dataType.indexOf("(")>-1)
                         dataType = dataType.substring(0,dataType.indexOf('('));
                     if(dataType.indexOf(',')>-1)
                         dataType = dataType.substring(0,dataType.indexOf(','));
                     if(dataType.equals("DATE"))
                         dataType = "Date";
                     
                     if("DOUBLE".equals(dataType)){
                         xml += "\t<columnOverride column=\""+field.toLowerCase()+"\" jdbcType=\"NUMBER\" javaType=\"Double\"/>\n";                         
                     }else{
                         xml += "\t<columnOverride column=\""+field.toLowerCase()+"\" jdbcType=\""+ dataType + "\" javaType=\""+toJavaType(dataType)+"\"/>\n";
                         
                     }
                  }
                 }
            }
            
            xmls = xmls.replaceAll("\\{ibator\\}", ibator);
            xmls = xmls.replaceAll("\\{appName\\}", appName);
            xmls = xmls.replaceAll("\\{dbUrl\\}", dbUrl);
            xmls = xmls.replaceAll("\\{dbUser\\}", dbUser);
            xmls = xmls.replaceAll("\\{dbPwd\\}", dbPwd);
            xmls = xmls.replaceAll("\\{packages\\}", packages);
            xmls = xmls.replaceAll("\\{body\\}", xml);
            
            FileUtil.writeFile(xmls, ibator + File.separator+ appName+".xml" , "GBK");            
            //创建目录
            FileUtil.createDirs(ibator + File.separator+ appName+File.separator+"src", true);
            
            bats = bats.replaceAll("\\{appName\\}", appName);
            bats = bats.replaceAll("\\{javaHome\\}", javaHome);
            FileUtil.writeFile(bats, ibator + File.separator+ appName+".bat" , "GBK");  
            System.out.println("\n\n请执行："+ibator + File.separator+ appName+".bat 该文件，\n\n即可自动生成代码。");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    private static String toJavaType(String dataType)
    
    {   
        
dataType = dataType.toUpperCase();
        
       
        
        if(dataType.equals("NUMBER"))
        {
            return "Long";
        }
        else if(dataType.equals("INT"))
        {
            return "Integer";
        }
        else if(dataType.equals("VARCHAR2"))
        {
            return "String";
        }
        else if(dataType.equals("VARCHAR"))
        {
            return "String";
        }
        else if(dataType.equals("LONGVARCHAR"))
        {
            return "String";
        }
        else if(dataType.equals("NCLOB"))
        {
            return "String";
        }
        else if(dataType.equals("TEXT"))
        {
            return "String";
        }
        else if(dataType.equals("BLOB"))
        {
            return "byte[]";
        }
        else if(dataType.equals("DATE"))
        {
            return "java.sql.Timestamp";
        }
        else if(dataType.equals("TIMESTAMP"))
        {
            return "java.sql.Timestamp";
        }
        else if(dataType.equals("CHAR"))
        {
            return "String";
        }   else
            return "";
        
        
    }
    
    
    public static String xmls = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>   "
    +"\n <!DOCTYPE ibatorConfiguration                                                                 "
    +"\n   PUBLIC \"-//Apache Software Foundation//DTD Apache iBATIS Ibator Configuration 1.0//EN\"    "
    +"\n   \"http://ibatis.apache.org/dtd/ibator-config_1_0.dtd\">                                     "
    +"\n <ibatorConfiguration>                                                                         "
    +"\n    <classPathEntry location=\"{ibator}\\mysql-connector-java-5.1.7.jar\" />                                      "
    +"\n                                                                                               "
    +"\n   <ibatorContext id=\"DB2Tables\" targetRuntime=\"Ibatis2Java5\">                             "
    +"\n     <jdbcConnection driverClass=\"com.mysql.jdbc.Driver\"                           "
    +"\n         connectionURL=\"{dbUrl}\"                                                            "
    +"\n         userId=\"{dbUser}\"                                                                  "
    +"\n         password=\"{dbPwd}\">                                                                "
    +"\n     </jdbcConnection>                                                                         "
    +"\n                                                                                               "
    +"\n 	<javaTypeResolver>                                                                           "
    +"\n 	  <property name=\"forceBigDecimals\" value=\"false\" />                                     "
    +"\n 	</javaTypeResolver>                                                                          "
    +"\n                                                                                               "
    +"\n                                                                                               "
    +"\n 	<javaModelGenerator targetPackage=\"{packages}.bean\"                                "
    +"\n 		targetProject=\"{ibator}\\{appName}\\src\">                                                "
    +"\n      <property name=\"enableSubPackages\" value=\"false\"/>                                   "
    +"\n      <property name=\"trimStrings\" value=\"true\"/>                                          "
    +"\n                                                                                               "
    +"\n     </javaModelGenerator>                                                                     "
    +"\n                                                                                               "
    +"\n     <sqlMapGenerator targetPackage=\"sqlmap.autogenerate\"                                    "
    +"\n         targetProject=\"{ibator}\\{appName}\">                                              "
    +"\n      <property name=\"enableSubPackages\" value=\"false\"/>                                   "
    +"\n     </sqlMapGenerator>                                                                        "
    +"\n                                                                                               "
    +"\n 	<daoGenerator type=\"SPRING\" targetPackage=\"{packages}.dao\"                       "
    +"\n         targetProject=\"{ibator}\\{appName}\\src\">                                           "
    +"\n      <property name=\"enableSubPackages\" value=\"false\"/>                                   "
    +"\n      <property name=\"methodNameCalculator\" value=\"default\"/>                              "
    +"\n      <property name=\"exampleMethodVisibility\" value=\"public\"/>                            "
    +"\n    		<property name=\"rootInterface\" value=\"com.film.base.BaseBeanDao\"/>        "
    +"\n    		<property name=\"rootClass\" value=\"com.film.base.BaseBeanDaoImpl\"/>        "
    +"\n     </daoGenerator>                                                                           "
    +"\n                                                                                               "
    +"\n 	{body}			                                                                                 "
    +"\n                                                                                               "
    +"\n                                                                                               "
    +"\n   </ibatorContext>                                                                            "
    +"\n </ibatorConfiguration>                                                                        ";
    
    public static String bats = "@echo off                                                       "
    +"\n{javaHome} -jar ibator.jar -configfile  {appName}.xml "
    +"\necho \"over!\"                                                    "
    +"\npause                                                           ";
}
