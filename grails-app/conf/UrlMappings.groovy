class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		"/product/$id"(controller: "product", action: "show")
		"/productList"(controller: "product", action: "list")
		"/productList/$cat"(controller: "product", action: "list")
		
	}
}
