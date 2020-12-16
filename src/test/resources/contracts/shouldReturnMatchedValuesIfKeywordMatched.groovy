import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return matched values if keyword is matched"
    request {
        method GET()
        urlPath("/documents") {
            queryParameters {
                parameter 'keyword': value(c(anyNonEmptyString()), p("text"))
            }
        }
    }
    response {
        status 200
        body("Lorem ips ${fromRequest().query("keyword")} lorem ips")
    }
}