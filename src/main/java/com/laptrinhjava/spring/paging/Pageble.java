package com.laptrinhjava.spring.paging;

import com.laptrinhjava.spring.sorting.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
