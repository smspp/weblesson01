package webLesson01;

public class Note{
	private String english;
	private String japanese;
	private String exe;

 //何も処理しないコンストラクタ
public Note(){

}

 //初期値セットされたコンストラクタ
public Note(String english, String japanese, String exe){
	this.english = english;
	this.japanese = japanese;
	this.exe = exe;
}

 //ゲッターとセッター
public String getEnglish(){
	return english;
}
public void setEnglish(String english){
	this.english = english;
}

public String getJapanese(){
	return japanese;
}
public void setJapanese(String japanese){
	this.japanese = japanese;
}

public String getExe(){
	return exe;
}
public void setExe(String exe){
	this.exe = exe;
}


public String toString(){
	return(this.english
			+ "//"
			+ this.japanese
			+ "　");

	}


}