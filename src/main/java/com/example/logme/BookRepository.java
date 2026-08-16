package com.example.logme;

//Spring Date Jpaが提供するリポジトリインターフェース
//SQL書かなくても、オブジェクト操作でDB操作が可能

// HelloControllerにRepositoryメソッドは記入済(findByIdとか)
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepositoryを継承し、基本的なDB操作(findByIdなど)が可能
// <Book,Long>←主キーはBookだよ
public interface BookRepository extends JpaRepository<Book,Long>{

}
