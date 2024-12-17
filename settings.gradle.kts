rootProject.name = "DevOps"

buildCache {
    remote<HttpBuildCache> {
        url = uri("http://91.206.15.113:5071/cache/")
        isAllowInsecureProtocol = true
        isAllowUntrustedServer = true
        isPush = true
    }
}

