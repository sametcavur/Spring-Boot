package com.project.repository;

import com.project.model.User;

public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository<User, Integer>{

	
	
/*
	// ******************* PAGİNG FİND ALL İŞLEMİ*****************************
	
		@Autowired
		PagingAndSortingRepository repo;
	
		@RequestMapping(value = "/findallguser", method = RequestMethod.GET)
		@ResponseBody
		public String findPagingAllUser() {
			//Verileri her sayfada 3 er tane olacak şekilde sayfa sayfa bölüyor,
			//Alttaki pageRequest içinde ise 2.sayfadaki 3 veriyi ver demek
		Pageable pageable = PageRequest.of(2,3); 
		Page<User> users = repo.findAll(pageable);
		int userCount = 0;
		for (@SuppressWarnings("unused")
		User user : users) {
			userCount++;
		}
		return "Kayıtlı User Sayısı : " + userCount;
		}
		
		
		
		
	// ******************* SORTİNG FİND ALL İŞLEMİ*****************************
	 * İsme göre sıralayarak verdik
	
	@Autowired
	PagingAndSortingRepository repo;

	@RequestMapping(value = "/findallsortuser", method = RequestMethod.GET)
	@ResponseBody
	public String findSortingAllUser() {
	Sort sort = Sort.by("userName");	
	Iterable<User> users = repo.findAll(sort);
	int userCount = 0;
	for (@SuppressWarnings("unused")User user : users) {
		System.out.println(user);
		userCount++;
	}
	return "Kayıtlı User Sayısı : " + userCount;
}
		 */
	
	
}
