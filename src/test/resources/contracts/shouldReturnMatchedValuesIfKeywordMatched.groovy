import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return matched values if keyword is matched"
    request {
        method GET()
        urlPath("/documents") {
            queryParameters {
                parameter 'keyword': anyNonEmptyString()
            }
        }
    }
    response {
        status 200
        body("Lorem ips ${fromRequest().query("keyword")} lorem ips")
    }
}