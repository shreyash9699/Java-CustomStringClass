import java.util.*;
class MyStringIndexOutOfBoundException extends RuntimeException {
	public MyStringIndexOutOfBoundException(String msg)
	{
		super(msg);
	}
}

final class MyString 
{
	char [] arr;

	public MyString() {
		arr = new char[0];
	}

	public MyString(String str) {
		arr = new char[str.length()];
		for(int i =0;i<str.length();i++)
			arr[i]=str.charAt(i);
	}

	public MyString(StringBuffer sb){
		this(sb.toString());
	}

	public MyString(StringBuilder sb){
		this(sb.toString());
	}

	public MyString(char [] arr) {
		this.arr = new char[arr.length];
		for (int i=0;i<arr.length;i++) 
			this.arr[i] = arr[i];	
	}

	public MyString(char[] arr,int start,int count) {
		if((start+count)>arr.length)
			throw new MyStringIndexOutOfBoundException(" String index out of range:"+(start+count));
		this.arr = new char[count];
		for(int i=start,j=0;i<(start+count);i++,j++) {
			this.arr[j]=arr[i];
		}
	}

	public int length() {
		return arr.length;
	}

	public boolean isEmpty() {
		return arr.length ==0;
	}

	public char charAt(int idx) {
		if(idx<0||idx>arr.length-1){
			throw new MyStringIndexOutOfBoundException ("String index out of range:"+idx);
			
		}
		return arr[idx];
	}

	public int codePointAt(int idx) {
		if(idx<0||idx>arr.length-1){
			throw new MyStringIndexOutOfBoundException ("String index out of range:"+idx);
			
		}
		return arr[idx];
	}

	public int codePointBefore(int idx) {
		return codePointAt(idx-1);
	}

	public int codePointCount(int start,int end) {
		if(start>end||start<0||end>=arr.length||end<0||start>=arr.length) {
			throw new IndexOutOfBoundsException();
		}
		return end -start;
	}

	public MyString toUpperCase() {
		char [] newArr = new char[arr.length];
		for(int i=0;i<newArr.length;i++) {
			char ch = arr[i];
			newArr[i] = (ch>=97 && ch<=122)?(char)(ch-32):ch; 
		}
		return new MyString(newArr);
	}

	public MyString toLowerCase() {
		char [] newArr = new char[arr.length];
		for (int i=0;i<newArr.length;i++) {
			char ch = arr[i];
			newArr[i] = ch>=65 && ch<=90 ? (char)(ch+32):ch; 			
		}
		return new MyString(newArr);
	}

	public int indexOf(char ch) {
		for (int i=0;i<arr.length ;i++ ) {
			if(arr[i]==ch)
				return i;
		}
		return -1;
	}

	public int indexOf(char ch,int idx) {
		for(int i=idx;i<arr.length;i++) {
			if(arr[i]==ch)
				return i;
		}
		return -1;
	}

	public int lastIndexOf(char ch) {
		for (int i=arr.length-1;i>=0 ;i--) {
			if(arr[i]==ch)
			return i;
		}
		return -1;
	}

	public MyString concat(MyString str) {
		char [] newArr = new char[arr.length+str.length()];
		int idx=0;
		for(int i=0;i<arr.length;i++) {
			newArr[idx++] = arr[i];
		}
		for(int i=0;i<str.length();i++) {
			newArr[idx++] = str.charAt(i);
		}
		return new MyString(newArr);
	}

	public boolean startsWith (MyString prefix,int start) {
			if(arr.length<prefix.length()|| start>=arr.length||start<0||prefix.length()>(prefix.length()+start)) return false;
			for(int i=start,j=0;i<(prefix.length()+start);i++) {
				if(arr[i]!=prefix.charAt(j++))
					return false;
			}
			return true;
	}

	public boolean startsWith (MyString prefix) {
		return startsWith(prefix,0);
	}

	public boolean contains(MyString str) {
		for(int i=0;i<arr.length;i++) {
			if(startsWith(str,i))
				return true;
		}
		return false;
	}

	public boolean endsWith(MyString suffix) {
		if(arr.length<suffix.length()) return false;
			for(int i=suffix.length()-1,j=arr.length-1;i>=0;i--,j--) {
				if(arr[j]!=suffix.charAt(i))
					return false;
			}
			return true;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MyString)) return false;
		MyString str = (MyString)obj;

		if(arr.length!=str.length()) return false;

		for(int i=0;i<str.length();i++) {
			if(arr[i]!=str.charAt(i)) return false;
		}
		return true;
	}

	public boolean contentEquals(StringBuffer sb) {
		MyString obj = new MyString(sb);
		return this.equals(obj);
	}

	public boolean equalsIgnoreCase(MyString str) {
		return this.toLowerCase().equals(str.toUpperCase());
	}

	public MyString replace(char oldChar,char newChar) {
		char[] newArr = arr.clone();
		for(int i=0;i<arr.length;i++) {
			if(newArr[i]==oldChar)
				newArr[i]=newChar;
		}
		return new MyString(newArr);
	}

	public MyString substring(int start,int end) {
		char [] str = new char[end-start]; 
		for(int i=start,j=0;i<end;i++) {
			str[j++] = arr[i];
		}
		return new MyString(str);
	}

	public MyString substring(int offset) {
		return substring(offset,arr.length);
	}

	public MyString trim() {
		int start=0,end=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=' '){
				start = i;
			    break;
			}
		}
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]!=' ') {
				end = i+1;
			    break;
			}
		}
		return substring(start,end);
	}



	@Override
	public String toString(){
		String str = "";
		for(char ele:arr) 
			str+=ele;
		return str;
	}

}
