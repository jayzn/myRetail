import com.myretail.domain.Product
import com.myretail.domain.Price

class BootStrap {
    def init = { 
		Product product = new Product(
			sku : "AEX143",
			name: "Stroller",
			category: "baby",
			price: (new Price(price: 199.99))
			).save(flush:true)
		Product product1 = new Product(
			sku : "IOL123",
			name: "Optimus Prime",
			category: "toys",
			price: (new Price(price: 13.37))
			).save(flush:true)
		Product product2 = new Product(
			sku : "XYZ904",
			name: "Sega Genesis",
			category: "toys",
			price: (new Price(price: 149.99))
			).save(flush:true)
    }
    def destroy = {
    }
}
