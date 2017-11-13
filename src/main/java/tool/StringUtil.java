package tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public final class StringUtil
{
    private StringUtil()
    {
    }

    /** 
	 * 将输入的字符串转换为首字母大写
	 * @param str 要转换的字符串
	 * @return 变为首字母大写的字符串
	 */
	public static String headUpper(String str)
	{
		if(str == null ||str.length() == 0)
		{
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
  
	/** 
	 * 将输入的字符串转换为首字母小写
	 * @param str 要转换的字符串
	 * @return 变为首字母大写的字符串
	 */
	public static String headLower(String str)
	{
		if(str == null ||str.length() == 0)
		{
			return str;
		}
		return Character.toLowerCase(str.charAt(0)) + str.substring(1);
	}
    
    /**
     * This method trim the input variable, so if it contains only spaces, then
     * it will be empty string, then we have 0 token :-) The returned value is
     * never null. If the input String is null, an empty String array will be
     * returned All tokens are trimed before returning
     */
    public static String[] getStringArray(String inputValue, String delim)
    {
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim,false);
        String[] ret = new String[t.countTokens()];
        int index = 0;
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            ret[index] = token;
            index++;
        }
        return ret;
    }
    
    /**
     * This method trim the input variable, so if it contains only spaces, then
     * it will be empty string, then we have 0 token :-) The returned value is
     * never null. If the input String is null, an empty String array will be
     * returned All tokens are trimed before returning
     */
    public static String[] getStringCArray(String inputValue, String delim)
    {
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim,false);
        String[] ret = new String[t.countTokens()];
        int index = t.countTokens();
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            index--;
            ret[index] = token;
           
        }
        return ret;
    }
    
    public static int[] getIntArray(String inputValue, String delim){
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim);
        int[] ret = new int[t.countTokens()];
        int index = 0;
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            try{
            	ret[index] = Integer.parseInt(token);
            	index++;
            }catch(NumberFormatException ne){
            	ne.printStackTrace();
            }
            
        }
        
        return ret;
        
    }
    
    public static long[] getLongArray(String inputValue, String delim){
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim);
        long[] ret = new long[t.countTokens()];
        int index = 0;
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            try{
                ret[index] = Long.parseLong(token);
                index++;
            }catch(NumberFormatException ne){
                ne.printStackTrace();
            }
            
        }
        
        return ret;
        
    }

    public static List getStringList(String inputValue, String delim)
    {
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim);
        List ret = new ArrayList();
        int index = 0;
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            ret.add(token);
            index++;
        }
        return ret;
    }
    

    
    public static Map getStringMap(String inputValue,String defvalue ,String delim)
    {
        if (inputValue == null)
            inputValue = "";
        inputValue = inputValue.trim();// very important
        java.util.StringTokenizer t = new java.util.StringTokenizer(inputValue, delim);
        Map ret = new HashMap();
        int index = 0;
        while (t.hasMoreTokens())
        {
            String token = t.nextToken().trim();
            // check for valid value here if needed
            ret.put(token,defvalue);
            index++;
        }
        return ret;
    }


    public static Object trimNull(Object object)
    {
        return object != null ? object : "";
    }

    /**
     * rem: 去掉内容中的HTML代码
     */
    public static String StripHTML(String str)
    {

        if (str == null || str.length() <= 0)
            return "";

        String temp = str;
        temp = temp.replaceAll("\\<.[^\\<]*\\>", "");
        temp = temp.replaceAll("\\<\\/[^\\<]*\\>", "");

        return temp;
    }

    public static Object map(Map map, Object key, Object defaultValue)
    {

        return (key != null && map.get(key) != null) ? map.get(key) : defaultValue;
    }

    public static Object map(Map map, Object key)
    {
        return (key != null && map.get(key) != null) ? map.get(key) : key;
    }

    /**
     * 获取重复的字符串 [不想要就输入 "" 空串]
     * 
     * @param base
     *            元字符串
     * @param split
     *            分割字符串
     * @param cover
     *            包围字符串
     * @param count
     *            重复次数
     */
    public static String formatString(String base, String cover, String split, int count)
    {
        StringBuffer buffer = new StringBuffer((base.length() + split.length() + cover.length() * 2) * count);
        for (int i = 0; i < count; i++)
        {
            buffer.append(cover);
            buffer.append(base);
            buffer.append(cover);
            buffer.append(split);
        }
        /* 避开调用同步方法 buffer.toString().substring() */
        return count > 0 ? buffer.toString().substring(0, buffer.length() - split.length()) : "";
    }

    public static String[] getStringArrays(String to, String cc, String bcc, String delim)
    {
        String[] toMail = getStringArray(to, delim);
        String[] ccMail = getStringArray(cc, delim);
        String[] bccMail = getStringArray(bcc, delim);
        String[] ret = new String[toMail.length + ccMail.length + bccMail.length];
        int index = 0;
        for (int i = 0; i < toMail.length; i++)
        {
            ret[index] = toMail[i];
            index++;
        }
        for (int i = 0; i < ccMail.length; i=i++)
        {
            ret[index] = ccMail[i];
            index++;
        }
        for (int i = 0; i < bccMail.length; i++)
        {
            ret[index] = bccMail[i];
            index++;
        }
        return ret;
    }

    public static String[] getDiffStringArrays(String to, String cc, String bcc, String delim)
    {
        String[] toMail = getStringArray(to, delim);
        String[] ccMail = getStringArray(cc, delim);
        String[] bccMail = getStringArray(bcc, delim);
        //String[] ret = new String[t.countTokens()];
        Set set = new HashSet();
        //int index = 0;
        for (int i = 0; i < toMail.length; i++)
        {
            set.add(toMail[i]);
        }
        for (int i = 0; i < ccMail.length; i++)
        {
            set.add(ccMail[i]);
        }
        for (int i = 0; i < bccMail.length; i++)
        {
            set.add(bccMail[i]);
        }
        return (String[]) set.toArray(new String[0]);
    }

    public static String getEmptyStringIfNull(String str)
    {
        if (str == null)
            return "";
        return str;
    }

    public static String space(String value)
    {
        return value != null ? value : "";
    }

    /**
     * This method accepts name with char, number or '_' or '.'
     * <p>
     * This method should be used to check all LoginName input from user for
     * security.
     * 
     * @todo: use StringBuffer
     */
    public static void checkGoodName(String str) throws Exception
    {
        int length = str.length();
        char c = 0;

        for (int i = 0; i < length; i++)
        {
            c = str.charAt(i);
            if ((c >= 'a') && (c <= 'z'))
            {
                // lower char
            }
            else if ((c >= 'A') && (c <= 'Z'))
            {
                // upper char
            }
            else if ((c >= '0') && (c <= '9')/* && (i != 0) */)
            {
                // minhnn: as of 31 Jan 2004, i relax the LoginName checking
                // so that the LoginName can start with an numeric char
                // hopefully it does not introduce a security bug
                // because this value will be inserted into sql script

                // numeric char
            }
            else if (((c == '_') || (c == '.') || (c == '@')) && (i != 0))
            {
                // minhnn: as of 12 Jan 2005, i relax the LoginName checking
                // so that it can have '@' because manyone use email as a
                // LoginName

                // _ char

                // If you need to allow non-ASCII chars, please uncomment the
                // below "else if"
                // However, this is not recommended since there will be
                // potential security
                //} else if (c >= 0x80) {
                // by huxn allow NON-ASCII char
            }
            else
            {
                // not good char, throw an BadInputException
                //@todo : localize me
                throw new Exception("");
            }
        }// for
    }

    public static String getShorterString(String str, int maxLength)
    {

        return getShorterString(str, "...", maxLength);
    }

    public static String getShorterStr(String str, int maxLength)
    {
    
        return getShorterString(str, "...", maxLength);
    }

    public static String getShorterString(String input, String tail, int length)
    {
        char[] characters = input.toCharArray();
        StringBuffer buffer = new StringBuffer(length);
        int i = 0;
        for (int j = 0; i < characters.length && j < length; i++)
        {
            char character = characters[i];
            j += (character >= 0 && character <= 255) ? 1 : 2;
            buffer.append(character);
        }
        return i < characters.length ? buffer.append(tail).toString() : buffer.toString() ;
    }

    /**
     * Get the shorter string, this is the old implementation before 4 Otc,
     * 2004. This implementation does not check the space as the break one.
     * 
     * @param str
     *            String the input string
     * @param maxLength
     *            int the max length of the shorter string
     * @return String the string after being making shorter
     */
    public static String getShorterStringIgnoreSpace(String str, int maxLength)
    {
        if (maxLength < 0)
            throw new IllegalArgumentException("The maxLength < 0 is not allowed.");
        if (str == null)
            return "";
        if (str.length() <= maxLength)
            return str;
        return str.substring(0, maxLength) + "...";
    }

    /**
     * Replace the occured char to a String
     * 
     * @param input
     *            String the input string
     * @param from
     *            char the char that is used to search
     * @param to
     *            String the string that will replace the char
     * @return String the string after being replaced
     */
    public static String replace(String input, char from, String to)
    {
        if (input == null)
        {
            return null;
        }

        char[] s = input.toCharArray();
        int length = s.length;
        StringBuffer ret = new StringBuffer(length * 2);

        for (int i = 0; i < length; i++)
        {
            if (s[i] == from)
            {
                ret.append(to);
            }
            else
            {
                ret.append(s[i]);
            }
        }// for
        return ret.toString();
    }

    public static String replaceKeyWord(String str, Map<String,String> data){
    	
    	if(data == null || data.isEmpty()){
    		return str;
    	}
    	
    	char[] s = str.toCharArray();
        int length = s.length;
        StringBuffer ret = new StringBuffer(length * 2);
        
        long maxkl = 0;
        
        //首字母特征分析
        Map<String,Long> spedata = new HashMap<String,Long>();        
        for(Iterator its = data.entrySet().iterator(); its.hasNext();) {
			Map.Entry entrys = (Map.Entry) its.next(); 
            String skey = (String)entrys.getKey();            
                      
            if(skey.length() > maxkl){
            	maxkl = skey.length();
            }
            char[] skeys = skey.toCharArray();
      
        	spedata.put(String.valueOf(skeys[0]), maxkl);
           
        }
        
    
        
        String temp = "";
        int k=0;        
        for (int i = 0; i < length; i++)
        {
        	k ++;
        	
        	String n = String.valueOf(s[i]);
        	
    		if(spedata.get(n) != null){
    			maxkl = spedata.get(n);
    		}else{
    			maxkl = 0;
    		}
    		
    		if(maxkl > 0){
    			
    			//尝试 maxkl次
    			if(i + maxkl <= length){
    				String rd= "";
    				int ct = 0;
    				String lrd = "";
    				String ltm = "";
        			String tm = String.valueOf(s[i]);
        			for(int cts=0;cts< maxkl;cts++){//最大后后继预测
        				if(i+cts+1 >= length){
        					tm = tm + String.valueOf(s[i+cts]);
        				}else{
        					
        					tm = tm + String.valueOf(s[i+cts+1]);
        				}
        				rd= data.get(tm);
            			if(rd != null && rd.length()> 0){
            				ltm = tm;
            				lrd = rd;
            				ct ++;
            		
            			}
        			}
        	
        			if(lrd != null && lrd.length()> 0){
    	        		ret.append(lrd);
    	        		temp = "";
    	        		k=0;
    	        		i = i + (ltm.length() -1);
    	        		
    	        	}else if(ct > 0 && lrd != null && lrd.length()== 0){
    	        		ret.append(ltm);
    	        		i = i + (ltm.length() -1);
    	        	}
        			if(ct > 0){        				
        				continue;
        			}
    			}
    			
    			
    			
    		}

     
        		

        		
	
        	temp = n;
        	ret.append(n);
        }
        
      //  ret.append(temp);
    	return ret.toString();
    }
    
    /**
     * This method can be replaced by getStringArray
     */
    public static Collection getSeparateString(String strContent, String pattern)
    {
        int beginIndex = 0;
        Collection coResult = new ArrayList();
        String result;
        int position = strContent.indexOf(pattern, beginIndex); // Get the first
        // position
        while (position != -1)
        {
            result = strContent.substring(beginIndex, position);
            if (!result.trim().equals(""))
            {
                coResult.add(result);
            }
            beginIndex = position + pattern.length(); //we add the length of
            // the partern such as ';'
            position = strContent.indexOf(pattern, beginIndex);
        }

        return coResult;
    }
    
    
    /** 
     * rem: 
     * par: 
     */
    public static String[] getSeparateStrs(String strContent, String pattern)
    {
        String[] retValue = null;
        int beginIndex = 0;
        if(strContent == null || strContent.length() <= 0)
            return retValue;
        
        String result = "";
        int position = strContent.indexOf(pattern, beginIndex); // Get the first
        int length = 0;
        
          
        if(strContent.length() == strContent.lastIndexOf(pattern) + 1){
            length = strContent.length() - strContent.replaceAll(pattern, "").length();
        }else{
        
            length = strContent.length() - strContent.replaceAll(pattern, "").length() + 1;
        }
        
        retValue = new String[length];
        int i = 0;
        String temp = strContent;
        
        // position
        while (position != -1 && temp.length() != 0)
        {
            result = strContent.substring(beginIndex, position);     
            
            retValue[i] = result;            
            beginIndex = position + pattern.length(); //we add the length of
            i++;
            // the partern such as ';'
            position = strContent.indexOf(pattern, beginIndex);
        }
        
        if(beginIndex != strContent.length()){
           
            result = strContent.substring(beginIndex, strContent.length());   
            System.out.println("==="+result);
            retValue[i] = result; 
        }
            
        return retValue;
    }

    public static boolean containsWord(String source, String splitRegex, String checkWord)
    {
        String[] words = source.split(splitRegex);
        checkWord = checkWord.trim();
        for (int i = 0; i < words.length; i++)
        {
            String key = words[i].trim();
            if (key.equalsIgnoreCase(checkWord))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert a password to a hidden format, usually the asterisk character is
     * used, such as 'secret' is converted to '******'
     * 
     * @param password
     *            String the input password that need to convert to hidden
     *            format
     * @return String the password after being converted to the hidden format
     */
    public static String getHiddenPassword(String password)
    {
        password = getEmptyStringIfNull(password);
        int length = password.length();
        if (length == 0)
            return password;
        StringBuffer hiddenPassword = new StringBuffer(length);
        for (int i = 0; i < length; i++)
        {
            hiddenPassword.append('*');
        }
        return hiddenPassword.toString();
    }
    
    

    
    

    public static String replace(String s, String oldStar,String oldEnd, String newStar,String newEnd) {
      if ( (s == null) || (oldStar == null) || (newStar == null)) {
        return null;
      }

    
      
      int y = s.indexOf(oldStar);

      if (y >= 0) {
        StringBuffer sb = new StringBuffer();
        int length = oldStar.length();
        int x = 0;

        while (x <= y) {
          sb.append(s.substring(x, y));         
          sb.append(newStar);
          if(s.indexOf(oldEnd,y) != -1)
          sb.append(s.substring(y + length, s.indexOf(oldEnd,y)));
          sb.append(newEnd);
          
          x = s.indexOf(oldEnd,y) + oldEnd.length() ;
          y = s.indexOf(oldStar, x);
        }
        sb.append(s.substring(x));

        return sb.toString();
      } else {
        return s;
      }
    }
    
    public static String replace2(String s, String oldStar,String oldEnd, String newStar,String newEnd) {
        if ( (s == null) || (oldStar == null) || (newStar == null)) {
          return null;
        }

      
        
        int y = s.indexOf(oldStar);

        if (y >= 0) {
          StringBuffer sb = new StringBuffer();
          int length = oldStar.length();
          int x = 0;

          while (x <= y) {
            sb.append(s.substring(x, y));         
            sb.append(newStar);
            
            
            sb.append(newEnd);
            if(s.indexOf(oldEnd,y) != -1){
	            x = s.indexOf(oldEnd,y) + oldEnd.length() ;
	            y = s.indexOf(oldStar, x);
            }
          }
          sb.append(s.substring(x));

          return sb.toString();
        } else {
          return s;
        }
      }


    
}