package com.myretail.domain

class Price {
	Double price
	static belongsTo = [product : Product]
}
