plugins {
    java
    `maven-publish`
}

extensions.configure<PublishingExtension> {    
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "slne-space"
            url = uri(System.getenv("REPOSITORY_URL") ?: "https://packages.slne.dev/maven/p/surf/maven")
            credentials {
                username = System.getenv("JB_SPACE_CLIENT_ID")
                password = System.getenv("JB_SPACE_CLIENT_SECRET")
            }
        }
    }
}
