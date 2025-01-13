rootProject.name = "DevOps"

if (System.getenv("GRADLE_REMOTE_CACHE_URL") != null) {
    buildCache {
        remote<HttpBuildCache> {
            url = uri(System.getenv("GRADLE_REMOTE_CACHE_URL"))
            isAllowInsecureProtocol = true
            isAllowUntrustedServer = true
            isPush = System.getenv("GRADLE_REMOTE_CACHE_PUSH").toBoolean()
            credentials {
                username = System.getenv("GRADLE_REMOTE_CACHE_USERNAME")
                password = System.getenv("GRADLE_REMOTE_CACHE_PASSWORD")
            }
        }
    }
}
