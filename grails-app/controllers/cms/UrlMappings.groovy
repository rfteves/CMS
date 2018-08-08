package cms

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/cms")
        "/versions"(view:"/versions")
        "/contact"(view:"/contact")
        "/page"(view:"/page")
        "500"(view:'/error')
        "404"(view:'/404')
    }
}
