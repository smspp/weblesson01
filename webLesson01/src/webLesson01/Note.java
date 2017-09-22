package webLesson01;

public class Note{
	private String title;
	private String naiyou;
	private String answer;
	private String site;

 //何も処理しないコンストラクタ
public Note(){

}

 //初期値セットされたコンストラクタ
public Note(String title, String naiyou, String answer, String site){
	this.title = title;
	this.naiyou = naiyou;
	this.answer = answer;
	this.site = site;
}

 //ゲッターとセッター
public String getTitle(){
	return title;
}
public void setTitle(String title){
	this.title = title;
}

public String getNaiyou(){
	return naiyou;
}
public void setNaiyou(String naiyou){
	this.naiyou = naiyou;
}

public String getAnswer(){
	return answer;
}
public void setAnswer(String answer){
	this.answer = answer;
}

public String getSite(){
	return site;
}
public void setSite(String site){
	this.site = site;

}

}