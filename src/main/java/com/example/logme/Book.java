package com.example.logme;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// オブジェクトとDBのテーブルを対応させるクラス＝ORM
@Entity //このクラスをDBと紐づける
public class Book {
    @Id //主キー(pk)
    // ↓ ID自動生成（生成方法　＝　DBが自動採番（IDENTITY）
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Longはintより大きい整数の型(intは21億までしかない)

    private String title;
    private String author;
    private String memo;
    private String rating;
    private String status;
    private Boolean top10;

    //デフォルトコンストラクタ（引数なし）後ほどRepositoryクラスを利用
    //テーブルに関するオブジェクトを完成させたらRepositoryを作り、
    //注意！引数ありだとRepositoryメソッド実行不可なので、なしをきちんと書く
    public Book(){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getMemo(){
        return memo;
    }
    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getRating(){
        return rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Boolean getTop10(){
        return top10;
    }
    public void setTop10(Boolean top10){
        this.top10 = top10;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id ;
    }

}
