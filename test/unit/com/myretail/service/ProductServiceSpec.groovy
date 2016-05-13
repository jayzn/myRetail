package com.myretail.service

import com.myretail.domain.Price
import com.myretail.domain.Product;

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(ProductService)
@Mock([Product, Price])
class ProductServiceSpec extends Specification {

	ProductService service
	Product product1
	
    def setup() {
		service = new ProductService()
		product1 = new Product(
			sku: "AEX143",
			category: "baby",
			name: "Stroller",
			price: (new Price(price: 199.99)))
		product1.save(flush: true, validate: false)
		Product product2 = new Product(
			sku : "IOL123",
			name: "Optimus Prime",
			category: "toys",
			price: (new Price(price: 13.37)))
		product2.save(flush: true, validate: false)
		Product product3 = new Product(
			sku: "FRT154",
			category: "baby",
			name: "Pacifier",
			price: (new Price(price: 15.45)))
		product3.save(flush: true, validate: false)
    }

    void "test getProductInfoById returns product info for the given product id"() {
		when:
		Map<String, String> prdInfo = service.getProductInfoById((String) product1.id)
		
		then:
		prdInfo.sku == "AEX143"
		prdInfo.category == "baby"
		prdInfo.name == "Stroller"
		prdInfo.price == 199.99
    }
	
	void "test getAllProductsInfo returns all products info"() {
		when:
		List<Map<String, String>> allPrdInfo = service.getAllProductsInfo()
		
		then:
		allPrdInfo.size() == 3
		allPrdInfo[0].sku == "AEX143"
		allPrdInfo[1].sku == "IOL123"
		allPrdInfo[2].sku == "FRT154"
	}
	
	void "test getProductInfoByCategory returns all products info for the given category"() {
		when:
		List<Map<String, String>> allPrdInfo = service.getProductInfoByCategory("baby")
		
		then:
		allPrdInfo.size() == 2
		allPrdInfo[0].sku == "AEX143"
		allPrdInfo[1].sku == "FRT154"
	}
}
