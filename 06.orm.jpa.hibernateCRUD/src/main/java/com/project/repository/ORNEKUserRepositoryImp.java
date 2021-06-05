package com.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public class ORNEKUserRepositoryImp {

	/*
	 * ESKİ USÜL OLARAK BU ŞEKİLDE İNTERFACEYİ İMPLEMENT EDEN BİR CLASS İLE
	 * REPOSİTORY CLASSINI YAPMIŞ OLSAYDIK AŞAĞIDAKİ GİBİ YAPACAKTIK,TABİ ŞUAN HATA
	 * VERDİĞİ İÇİN YUKARI CLASS İSMİNİN YANINA İMPLEMENT USERREPOSİTORY YAZMADIM
	 * AMA ORAYADA İMPLEMENT ETTİĞİMİZ İNTERFACEYİ YAZACAKTIK.AMA ARTIK SPRİNG BOOT'TA
	 * USERREPOSİTORY ADINDAKİ İNTERFACEDEKİ GİBİ REPOSİTORY CLASSLARI HAZIRLANIYOR.
	 * HATTA QUERYLER İÇİN METODUN İÇİNİ DOLDURAMAMAYA DA ÇÖZÜM VAR METONLARIN ÜSTÜNE
	 * @QUERY ANOTASYONU İLE DOLDURUYORUZ.
	 */
	
	
	
	@PersistenceContext
	EntityManager entityManager;

	public List<User> findMaxUsersById(int userId) {
		String query = "Select u FROM User u WHERE u.userId =< :userId";
		TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
		typedQuery.setParameter("userId", userId);
		return typedQuery.getResultList();
	}

}
